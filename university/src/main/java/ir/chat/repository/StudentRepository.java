package ir.chat.repository;

import ir.chat.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student , Long> {

    List<Student> findByGpaGreaterThanEqual(double minGpa);

}
