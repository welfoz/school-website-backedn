package pl.dmcs.springbootjsp_iwa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Name has to be filled")
    private String firstname;

    @NotBlank(message = "Name has to be filled")
    private String lastname;

    private String email;

    /*

    firstname" : "rafa";
    "lastname" : "nadal";
    "email" : "rafa@nadal";
    "telephone" : "07";
     */


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}


