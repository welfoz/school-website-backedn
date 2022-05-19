package pl.dmcs.springbootjsp_iwa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.springbootjsp_iwa.model.Subject;
import pl.dmcs.springbootjsp_iwa.model.Subject;
import pl.dmcs.springbootjsp_iwa.repository.SubjectRepository;
import pl.dmcs.springbootjsp_iwa.repository.SubjectRepository;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/subject")
public class SubjectRESTController {


    private SubjectRepository subjectRepository;

    //
//
//
//
    @Autowired
    public SubjectRESTController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @RequestMapping(method = RequestMethod.GET/* , produces = "application/xml"*/)
    public List<Subject> findAllSubjects() { return subjectRepository.findAll(); }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<Subject>> addSubjects(@RequestBody List<Subject> subjectList) {
        subjectRepository.saveAll(subjectList);
        return new ResponseEntity<List<Subject>>(subjectList, HttpStatus.CREATED);
    }
    @RequestMapping(value="/{id}", method = RequestMethod.GET/* , produces = "application/xml"*/)
    public ResponseEntity<Subject> findOneSubject(@PathVariable("id") long id) {
        Subject subject = subjectRepository.findById(id);
        return new ResponseEntity<Subject>(subject, HttpStatus.OK);
    }
}

