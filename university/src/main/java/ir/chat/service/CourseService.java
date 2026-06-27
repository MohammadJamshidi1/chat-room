package ir.chat.service;

import ir.chat.Request.CourseRequest;
import ir.chat.entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

    Course addCourse(CourseRequest request);
    Course findById(Long id);
    List<Map<String, Object>> getFavoriteCounts();
}
