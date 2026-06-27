package ir.chat.Controller;

import ir.chat.Request.StudentRequest;
import ir.chat.Response.StudentResponse;
import ir.chat.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse addStudent(@Valid @RequestBody StudentRequest request) {
        return studentService.addStudent(request);

    }

    @GetMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse findById(@PathVariable Long studentId) {
        return studentService.findById(studentId);

    }


    @PutMapping("/{studentId}/favorite-course/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse updateFavoriteCourse(@PathVariable Long studentId ,@PathVariable Long courseId) {
        return studentService.updateFavoriteCourse(studentId , courseId);

    }

    @GetMapping("/search/gpa")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> getByMinGpa(@RequestParam Double minScore) {
        return studentService.getStudentsByMinGpa(minScore);
    }

}
