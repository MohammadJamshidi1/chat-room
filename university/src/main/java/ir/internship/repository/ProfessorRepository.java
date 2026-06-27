package ir.internship.repository;

import ir.internship.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor , Long> {
}
