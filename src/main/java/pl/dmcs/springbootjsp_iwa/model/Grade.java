package pl.dmcs.springbootjsp_iwa.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Grade {

    @OneToOne
    private Student student;

    @OneToOne
    private Subject subject;

    private Number mark;

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

    public Number getMark() {
        return mark;
    }

    public void setMark(Number mark) {
        this.mark = mark;
    }
}


