package pl.dmcs.springbootjsp_iwa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Grade {

    //    @JsonBackReference(value="student")
    @ManyToOne
    @JoinColumn(name="student_id")
    @JsonIgnoreProperties(value = {"subjectSet", "gradeList", "firstname", "lastname", "email"})
    private Student student;

//    @JsonBackReference(value="gradeList")
    @ManyToOne
    @JsonIgnoreProperties(value = {"gradeList", "studentSet", "teacher", "name", "description"})
    @JoinColumn(name="subject_id")
    private Subject subject;


    private String mark;

    @Id
    @GeneratedValue
    private long id;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}


