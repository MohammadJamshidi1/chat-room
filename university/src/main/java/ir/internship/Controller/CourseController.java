package ir.internship.Controller;

import ir.internship.Request.CourseRequest;
import ir.internship.entity.Course;
import ir.internship.service.CourseServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseServiceImpl courseService;


    @PostMapping
    public ResponseEntity<Course> addCourse(@Valid @RequestBody CourseRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(request));
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> findCourseById(@PathVariable Long courseId){
        return ResponseEntity.ok(courseService.findById(courseId));
    }

    @GetMapping("/favorite-counts")
    public ResponseEntity<List<Map<String, Object>>> getFavoriteCounts() {
        return ResponseEntity.ok(courseService.getFavoriteCounts());
    }
}
