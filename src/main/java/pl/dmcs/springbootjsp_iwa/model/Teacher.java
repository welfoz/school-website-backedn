package pl.dmcs.springbootjsp_iwa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Name has to be filled")
    private String firstname;

    @NotBlank(message = "Name has to be filled")
    private String lastname;

    @OneToMany
    private List<Subject> subjectList;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}


