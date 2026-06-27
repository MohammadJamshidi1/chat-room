package ir.internship.service;

import ir.internship.Request.CourseRequest;
import ir.internship.entity.Course;
import ir.internship.repository.CourseRepository;
import ir.internship.repository.RegistrationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;


    @Override
    @Transactional
    public Course addCourse(CourseRequest request) {

        Course course = new Course(
                request.getName(),
                request.getCapacity()
        );

        return courseRepository.save(course);
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getFavoriteCounts() {
        return courseRepository.findFavoriteCourseCountGrouped()
                .stream()
                .map(row -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("courseName", row[0]);
                    map.put("studentCount", row[1]);
                    return map;
                })
                .toList();
    }

}
