package pl.dmcs.springbootjsp_iwa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.bytebuddy.implementation.bind.annotation.DefaultMethod;
import org.hibernate.dialect.Sybase11Dialect;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue
    private long id;


    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
//    @JsonIgnore
    @JsonIgnoreProperties(value = {"student"})
    private List<Grade> gradeList;


    // Set to avoid duplicates
    @ManyToMany
    @JsonIgnoreProperties(value = {"studentSet", "gradeList"})
    @JoinTable(name = "students_courses",
            joinColumns = { @JoinColumn(name = "student_id")},
            inverseJoinColumns = { @JoinColumn(name = "subject_id") }
    )
    private Set<Subject> subjectSet = new HashSet<>();

//    @NotBlank(message = "Name has to be filled")
    private String firstname;

//    @NotBlank(message = "Name has to be filled")
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

    public Set<Subject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    public void clearSubjectSet() {
        this.subjectSet.clear();
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public void addSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet.addAll(subjectSet);
    }
}
