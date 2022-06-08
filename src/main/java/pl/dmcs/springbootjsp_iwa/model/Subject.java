package pl.dmcs.springbootjsp_iwa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "SUBJECT")
public class Subject {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
//    @JsonManagedReference(value = "subject")
    @JsonIgnoreProperties(value = {"subject", "gradeList"})
//    @JsonIgnore
    private List<Grade> gradeList;

    @ManyToMany(mappedBy = "subjectSet", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"subjectSet", "email", "gradeList"})
    private Set<Student> studentSet = new HashSet<>();

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties(value = {"subjects"})
    private Teacher teacher;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Grade> getGradeList() {
        gradeList.stream().filter(grade -> grade.getStudent().getId() == id);
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public List<Grade> getGradesById(long id) {
        gradeList.stream().filter(grade -> grade.getStudent().getId() == id);
        return gradeList;
    }

//    public Set<Student> getStudentSet() {
//        return studentSet;
//    }
//
//    public void setStudentSet(Set<Student> studentSet) {
//        this.studentSet = studentSet;
//    }
}


