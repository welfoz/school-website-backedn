package pl.dmcs.springbootjsp_iwa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.springbootjsp_iwa.model.Student;
import pl.dmcs.springbootjsp_iwa.repository.StudentRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/students")
public class StudentRESTController {
//
//    private StudentRepository studentRepository;
//
//
//
//
//    @Autowired
//    public StudentRESTController(StudentRepository studentRepository, AddressRepository addressRepository, TeamRepository teamRepository) {
//        this.studentRepository = studentRepository;
//        this.addressRepository = addressRepository;
//        this.teamRepository = teamRepository;
//    }
//
////
////    @Autowired
////    public StudentRESTController(AddressRepository addressRepository) {
////    }
////
////    @Autowired
////    public StudentRESTController(TeamRepository teamRepository) {
////    }
//
//
//    @RequestMapping(method = RequestMethod.GET/* , produces = "application/xml"*/)
//    public List<Student> findAllStudents() { return studentRepository.findAll(); }
//
////    @RequestMapping(method = RequestMethod.POST)
////    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> students) {
////        studentRepository.saveAll(students);
////        return new ResponseEntity<List<Student>>(students, HttpStatus.CREATED);
////    }
//    @RequestMapping(method = RequestMethod.POST)
//    //@PostMapping
//    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
////        System.out.println(student.getAddress().getId());
//        if ((student.getAddress() != null)) {
//            // the address is precised in the request body
//            // then we can save it if it isn't already saved
//            if (( student.getAddress().getId() <= 0))  // if the address already exists we do not override it, we just add the student into, Si on peut que MERGE => on peut pas créer => donc faut créer à la mano, mais si on peut merge ET persist on peut pas ajouter des gens dans la team
//            { // if id not in the request body => id = 0
//                addressRepository.save(student.getAddress());
//            }
//        }
//        int i = 0;
////        System.out.println("LIST SIZE : " + student.getTeamList().size());
//        if (student.getTeamList() != null) {
//            while (i < student.getTeamList().size()) { // add student on existing team or create new team if id not in the request body
//                System.out.println(i);
//                if ((student.getTeamList().get(i).getId() <= 0))  // if the address already exists we do not override it, we just add the student into, Si on peut que MERGE => on peut pas créer => donc faut créer à la mano, mais si on peut merge ET persist on peut pas ajouter des gens dans la team
//                { // if id not in the request body => id = 0
//                    System.out.println("Adding a new team name...");
//                    teamRepository.save(student.getTeamList().get(i));
//                }
//                i++;
//            }
//        }
//
//        System.out.println("ucu");
//        studentRepository.save(student);
//        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
//    }
//
//
//    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
//    //@DeleteMapping("/{id}")
//    public ResponseEntity<Student> deleteStudent (@PathVariable("id") long id) {
//        Student student = studentRepository.findById(id);
//        if (student == null) {
//            System.out.println("Student not found!");
//            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
//        }
//        studentRepository.deleteById(id);
//        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
//    }
//
//   /** @RequestMapping(value="/{id}", method = RequestMethod.PUT)
//    //@PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") long id, @RequestParam(required = false) Optional<Long>  addressId, @RequestParam(required = false) List<Integer> teamsId, @RequestParam(required = false) Optional<Long>  accountId) {
//        student.setId(id);
////        System.out.println(addressId);
//
//        if (accountId.isPresent()) {
//            Account account = new Account();
//            account.setId(accountId.get());
//            account.setAccountName(student.getAccount().getAccountName());
//            student.setAccount(account);
//        }
//
//        if (addressId.isPresent()) {
//            Address address = new Address();
//            address.setId(addressId.get());
//            address.setCity(student.getAddress().getCity());
//            address.setNumber(student.getAddress().getNumber());
//            address.setPostalCode(student.getAddress().getPostalCode());
//            address.setStreet(student.getAddress().getStreet());
//            student.setAddress(address);
//        }
//
//        if (teamsId != null) {
//            //        addressRepository.save(student.getAddress());
//            List<Team> teamlist = new ArrayList<Team>();
//            List<Team> list_before = new ArrayList<>();
//            list_before.addAll(student.getTeamList());
//            System.out.println("list_before");
//
//            int i = 0;
//            while (i < teamsId.size()) { // override ~ update the team name
//                Team team = new Team();
//                team.setId(teamsId.get(i));
//                team.setTeamName(student.getTeamList().get(i).getTeamName());
//                teamlist.add(team);
//                System.out.println(student.getTeamList().get(i).getTeamName());
//
//                int index = -1;
//                for (int j = 0; j < list_before.size(); j++) {
//                    if (list_before.get(j).getTeamName() == student.getTeamList().get(i).getTeamName()) {
//                        index = j; // we stop at the first as we will pass the team with query parameters first in the JSON request
//                        break;
//                    }
//                }
//
//                list_before.remove(index);
//                System.out.println(list_before);
//
//                System.out.println("Team updated...to " + student.getTeamList().get(i));
//                i++;
//            }
//            teamlist.addAll(list_before);
//            student.setTeamList(teamlist);
//        }
//
//        studentRepository.save(student);
//        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
//    }*/
//   @RequestMapping(value="/{id}", method = RequestMethod.PUT)
//   public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") long id) {
//       studentRepository.findById(id);
//       student.setId(id);
//       studentRepository.save(student);
//       return new ResponseEntity<>(HttpStatus.OK);
//   }
//
//
//    @RequestMapping(value="/{id}", method = RequestMethod.PATCH)
//    //@PatchMapping("/{id}")
//    public ResponseEntity<Student> updatePartOfStudent(@RequestBody Map<String, Object> updates, @PathVariable("id") long id) {
//        Student student = studentRepository.findById(id);
//        if (student == null) {
//            System.out.println("Student not found!");
//            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
//        }
//        partialUpdate(student, updates);
//        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
//    }
//
//    private void partialUpdate(Student student, Map<String, Object> updates) {
//        if (updates.containsKey("firstname")) {
//            student.setFirstname((String) updates.get("firstname"));
//        }
//        if (updates.containsKey("lastname")) {
//            student.setLastname((String) updates.get("lastname"));
//        }
//        if (updates.containsKey("email")) {
//            student.setEmail((String) updates.get("email"));
//        }
//        if (updates.containsKey("telephone")) {
//            student.setTelephone((String) updates.get("telephone"));
//        }
//        studentRepository.save(student);
//    }
//
//
//    // 3 others methods
//    // head connect trace options
//
//    // The HEAD method asks for a response identical to that of
//    //a GET request, but without the response body. This is useful for
//    // retrieving meta-information written in response headers, without
//    //having to transport the entire content.
//
//    @RequestMapping(method = RequestMethod.HEAD/* , produces = "application/xml"*/)
//    public ResponseEntity<String> getHeaders() {
//        return new ResponseEntity<>("h", HttpStatus.OK); // WHY THE RESPONSE BODY DOESN T HAVE "h" ???
//    }
//
//    // The OPTIONS method returns the HTTP methods
//    //that the server supports for the specified URL. This can be used to
//    //check the functionality of a web server by requesting '*' instead of
//    //a specific resource.
//    @RequestMapping(method = RequestMethod.OPTIONS/* , produces = "application/xml"*/)
//    public ResponseEntity options(HttpServletResponse response) {
//        response.setHeader("Allow", "HEAD,GET,PUT,OPTIONS, TRACE, PATCH...");
//        return new ResponseEntity("Information are display in the headers, the \"Allow\"", HttpStatus.OK);
//    }
//
//
//    //TRACE – The TRACE method echoes the received request so
//    //that a client can see what (if any) changes or additions have been
//    //made by intermediate servers.
////    @RequestMapping(method = RequestMethod.TRACE/* , produces = "application/xml"*/)
////    public void requestMappingTrace() {
////    }
//
//    @RequestMapping(value="/{id}", method = RequestMethod.GET/* , produces = "application/xml"*/)
//    public ResponseEntity<Student> findOneStudent(@PathVariable("id") long id) {
//        Student student = studentRepository.findById(id);
//        return new ResponseEntity<Student>(student, HttpStatus.OK);
//    }
//
//   /** @RequestMapping(method = RequestMethod.PUT)
//    //@PutMapping("/{id}")
//    public ResponseEntity<List<Student>> updateAllStudent(@RequestBody List<Student> students) {
//        studentRepository.saveAll(students);
//        return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
//    }*/
//    @PutMapping
//    public ResponseEntity<List<Student>> updateAllStudent(@RequestBody List<Student> studentList) {
//        if (studentRepository.findAll() != null){
//            studentRepository.deleteAll();
//        }
//        studentRepository.saveAll( studentList );
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE) // DELETE ALL STUDENTS, delete cascade account but do not delete team and address
//    //@DeleteMapping("/{id}")
//    public ResponseEntity<Student> deleteAllStudents () {
//        studentRepository.deleteAll();
//        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
//    }
}
