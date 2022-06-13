package pl.dmcs.springbootjsp_iwa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.springbootjsp_iwa.model.*;
import pl.dmcs.springbootjsp_iwa.model.Subject;
import pl.dmcs.springbootjsp_iwa.repository.GradeRepository;
import pl.dmcs.springbootjsp_iwa.repository.StudentRepository;
import pl.dmcs.springbootjsp_iwa.repository.SubjectRepository;
import pl.dmcs.springbootjsp_iwa.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/subject")
public class SubjectRESTController {


    private SubjectRepository subjectRepository;
    private StudentRepository studentRepository;
    private GradeRepository gradeRepository;

    //
//
//
//
    @Autowired
    public SubjectRESTController(SubjectRepository subjectRepository, StudentRepository studentRepository, GradeRepository gradeRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;
    }

    @RequestMapping(method = RequestMethod.GET/* , produces = "application/xml"*/)
    public List<Subject> findAllSubjects() {

        List<Subject> subjects = subjectRepository.findAll();
//        ArrayList<studentWithGoodGrades> newSub = new ArrayList<studentWithGoodGrades>();
//        ArrayList<Grade> allGrades = new ArrayList<Grade>();
//        subjects.forEach(subject -> {
//            subject.getStudentSet().forEach(student -> {
//                List<Grade> grades = gradeRepository.findALlByStudentAndSubject(student, subject);
//                System.out.println(grades);
////                tudent.setGradeList(grades);
//                allGrades.addAll(grades);
//            });
//        });
//        System.out.println(allGrades);
//        subjects.stream().forEach(subject -> {
//            newSub
//            subject.getStudentSet().stream().forEach(student -> {
//                List<Grade> grades = allGrades.stream().filter(grade -> grade.getSubject().getId() == subject.getId()).collect(Collectors.toList());
//                student.setGradeList(grades);
//            });
//        });
////        subjects.forEach(subject -> {
////            subject.getStudentSet().stream().forEach(student -> {
////                List<Grade> grades = student.getGradeList().stream().filter(grade -> grade.getSubject().getId() == subject.getId()).collect(Collectors.toList());
////                student.setGradeList(grades);
////
//////                student.setLastname();
////            });
////        });
////
////        subjects.forEach(sub -> {
////            System.out.println(sub.getId());
////            sub.getStudentSet().forEach(stu -> {
////                System.out.println(stu.getId());
////                stu.getGradeList().forEach(grade -> System.out.println(grade));
////            });
////        });
        return subjects;
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<List<Subject>> addSubjects(@RequestBody List<Subject> subjectList) {
//        subjectRepository.saveAll(subjectList);
//        return new ResponseEntity<List<Subject>>(subjectList, HttpStatus.CREATED);
//    }
//    @RequestMapping(value="/{id}", method = RequestMethod.GET/* , produces = "application/xml"*/)
//    public ResponseEntity<List<Student>> findOneSubject(@PathVariable("id") long id) {
//        Subject subject = subjectRepository.findById(id);
//        List<Student> studentList = studentRepository.findAllBySubjectSet(subject);
//        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
//    }

//    @RequestMapping(value="/{id}", method = RequestMethod.GET/* , produces = "application/xml"*/)
//    public ResponseEntity<List<Subject>> findOneSubject(@PathVariable("id") long id) {
//        List<Subject> subjects = subjectRepository.fab(id);
////        List<Student> studentList = studentRepository.findAllBySubjectSet(subject);
//        return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
//    }
}

