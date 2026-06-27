package ir.chat.repository;

import ir.chat.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration , Long> {

    Optional<Registration> findByStudent_IdAndCourseOffering_Course_Id(Long studentId , Long courseId);

    @Query("""
            SELECT AVG(r.score)
            FROM Registration r
            WHERE r.courseOffering.course.id = :courseId
              AND r.score IS NOT NULL
            """)
    Optional<Double> findAverageScoreByCourseId(@Param("courseId") Long courseId);

    @Query("""
            SELECT r FROM Registration r
            WHERE r.student.id = :studentId
              AND r.courseOffering.professor.id = :professorId
              AND r.courseOffering.course.id = :courseId
            """)
    Optional<Registration> findByStudentAndProfessorAndCourse(
            @Param("studentId") Long studentId,
            @Param("professorId") Long professorId,
            @Param("courseId") Long courseId);

}
