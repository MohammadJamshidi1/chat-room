package ir.chat.repository;

import ir.chat.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course , Long> {


    @Query("""
            SELECT c.name , COUNT(s) FROM Student s
            JOIN s.favoriteCourse c
            GROUP BY c.id , c.name

            """)
    List<Object[]> findFavoriteCourseCountGrouped();
}
