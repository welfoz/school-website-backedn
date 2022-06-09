package pl.dmcs.springbootjsp_iwa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.springbootjsp_iwa.model.Grade;
import pl.dmcs.springbootjsp_iwa.model.Student;
import pl.dmcs.springbootjsp_iwa.model.Subject;
import pl.dmcs.springbootjsp_iwa.model.Teacher;
import pl.dmcs.springbootjsp_iwa.repository.GradeRepository;
import pl.dmcs.springbootjsp_iwa.repository.StudentRepository;
import pl.dmcs.springbootjsp_iwa.repository.SubjectRepository;
import pl.dmcs.springbootjsp_iwa.repository.TeacherRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/teachers")
public class TeacherRESTController {


    private SubjectRepository subjectRepository;
    private StudentRepository studentRepository;
    private GradeRepository gradeRepository;
    private TeacherRepository teacherRepository;

    //
//
//
//
    @Autowired
    public TeacherRESTController(SubjectRepository subjectRepository, GradeRepository gradeRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.subjectRepository = subjectRepository;
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @RequestMapping(method = RequestMethod.GET/* , produces = "application/xml"*/)
    public List<Teacher> findAllTeachers() { return teacherRepository.findAll(); }

    @RequestMapping(value="grade", method = RequestMethod.POST)
    public ResponseEntity<List<Grade>> addGrades(@RequestBody List<Grade> gradeList) {
        gradeList.stream().forEach(grade -> {
            Student student = studentRepository.findById(grade.getStudent().getId());
            Subject subject = subjectRepository.findById(grade.getSubject().getId());
            grade.setStudent(student);
            grade.setSubject(subject);
        });
        System.out.println("ici");
        gradeRepository.saveAll(gradeList);
        return new ResponseEntity<List<Grade>>(gradeList, HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<Teacher>> postTeacher(@RequestBody List<Teacher> teachers) {
        teachers.forEach(te -> {
            if (te.getSubjects() != null) {
                te.getSubjects().forEach(sub -> {
                    Subject subject = subjectRepository.findById(sub.getId());
                    subject.setTeacher(te);
                });
            }
        });
        teacherRepository.saveAll(teachers);
        return new ResponseEntity<List<Teacher>>(teachers, HttpStatus.CREATED);
    }
    @RequestMapping(value="/{id}", method = RequestMethod.GET/* , produces = "application/xml"*/)
    public ResponseEntity<Teacher> findOneTeacher(@PathVariable("id") long id) {
        Teacher teacher = teacherRepository.findById(id);
        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
    }

    // teacher can post a new subject
    @RequestMapping(value="subject", method = RequestMethod.POST)
    public ResponseEntity<Subject> postTeacher(@RequestBody Subject subject) {
        subjectRepository.save(subject);
        return new ResponseEntity<Subject>(subject, HttpStatus.CREATED);
    }

    @RequestMapping(value="subject/register/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Teacher> registerNewSubjects(@RequestBody Teacher body, @PathVariable("id") long id) {
        Teacher teacher = teacherRepository.findById(id);
        System.out.println(teacher);
//        teacher.setSubjects(body.getSubjects());
        System.out.println(body.getSubjects());
        body.getSubjects().forEach(el -> {
            System.out.println(el.getId());
            Subject subject = subjectRepository.findById(el.getId());
            subject.setTeacher(teacher);
            subjectRepository.save(subject);
        });
//        teacherRepository.save(teacher);
        return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="subject/unregister/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Teacher> unregisterSubjects(@RequestBody Teacher body, @PathVariable("id") long id) {
        Teacher teacher = teacherRepository.findById(id);
//        Set<Subject> subjectSet = teacher.getSubjects();
//        Set<Subject> toRemove = new HashSet<>();
//        System.out.println(subjectSet);
//        body.getSubjects().forEach(bodySet -> {
//            subjectSet.forEach(el -> {
//                System.out.println(bodySet.getId());
//                System.out.println(el.getId());
//                if (bodySet.getId() == el.getId()) {
//                    toRemove.add(el);
//                }
//            });
//        });
//        subjectSet.removeAll(toRemove);
        body.getSubjects().forEach(bodySet -> {
            Subject subject = subjectRepository.findById(bodySet.getId());
            subject.setTeacher(null);
            subjectRepository.save(subject);

        });
        teacherRepository.save(teacher);
        return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT);
    }
}

