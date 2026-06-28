package ir.chat.repository;

import ir.chat.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor , Long> {
}
