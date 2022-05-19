package pl.dmcs.springbootjsp_iwa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Grade {

    @ManyToOne
    @JsonIgnore
    private Student student;

    @OneToOne
    private Subject subject;

    public void setMark(double mark) {
        this.mark = mark;
    }

    private double mark;

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

    public double getMark() {
        return mark;
    }

}


