package ir.chat.repository;

import ir.chat.entity.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseOfferingRepository extends JpaRepository<CourseOffering , Long> {
    Optional<CourseOffering> findByCourse_Id(Long courseId);

    Optional<CourseOffering> findByProfessor_IdAndCourse_Id(Long professorId, Long courseId);
}
