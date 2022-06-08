package pl.dmcs.springbootjsp_iwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.dmcs.springbootjsp_iwa.model.Student;
import pl.dmcs.springbootjsp_iwa.model.Subject;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findById(long id);

    @Query(
            value = "SELECT s FROM Subject s JOIN s.gradeList g WHERE g.subject.id = :id" // SELECT e FROM Employee e JOIN e.address a WHERE a.city = :city
)
    List<Subject> fab(@Param("id") long id);
}


