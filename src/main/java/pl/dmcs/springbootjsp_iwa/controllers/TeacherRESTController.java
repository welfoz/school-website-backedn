package pl.dmcs.springbootjsp_iwa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.springbootjsp_iwa.model.Grade;
import pl.dmcs.springbootjsp_iwa.model.Student;
import pl.dmcs.springbootjsp_iwa.model.Subject;
import pl.dmcs.springbootjsp_iwa.repository.GradeRepository;
import pl.dmcs.springbootjsp_iwa.repository.StudentRepository;
import pl.dmcs.springbootjsp_iwa.repository.SubjectRepository;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/teacher")
public class TeacherRESTController {


    private SubjectRepository subjectRepository;
    private StudentRepository studentRepository;
    private GradeRepository gradeRepository;

    //
//
//
//
    @Autowired
    public TeacherRESTController(SubjectRepository subjectRepository, GradeRepository gradeRepository, StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
    }

//    @RequestMapping(value="grade", method = RequestMethod.GET/* , produces = "application/xml"*/)
//    public List<Student> findAllGrades() { return studentRepository.findAll(); }

    @RequestMapping(value="grade", method = RequestMethod.POST)
    public ResponseEntity<List<Grade>> addGrades(@RequestBody List<Grade> gradeList) {
        gradeRepository.saveAll(gradeList);
        return new ResponseEntity<List<Grade>>(gradeList, HttpStatus.CREATED);
    }
//    @RequestMapping(value="/{id}", method = RequestMethod.GET/* , produces = "application/xml"*/)
//    public ResponseEntity<Grade> findOneGrade(@PathVariable("id") long id) {
//        Grade grade = gradeRepository.findById(id);
//        return new ResponseEntity<Grade>(grade, HttpStatus.OK);
//    }
}

