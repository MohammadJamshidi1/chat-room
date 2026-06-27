package ir.internship.service;

import ir.internship.Request.CourseRequest;
import ir.internship.entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

    Course addCourse(CourseRequest request);
    Course findById(Long id);
    List<Map<String, Object>> getFavoriteCounts();
}
