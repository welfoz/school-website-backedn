package pl.dmcs.springbootjsp_iwa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="student")
public class Teacher {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Name has to be filled")
    private String firstname;

    @NotBlank(message = "Name has to be filled")
    private String lastname;


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
}


