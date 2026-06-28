package ir.chat.Controller;

import ir.chat.Response.CourseOfferingResponse;
import ir.chat.service.CourseOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/offerings")
@RequiredArgsConstructor
public class CourseOfferingController {

    private final CourseOfferingService offeringService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseOfferingResponse createOffering(
            @RequestParam Long professorId,
            @RequestParam Long courseId) {

        return offeringService.createOffering(professorId, courseId);
    }

    @GetMapping("/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public CourseOfferingResponse findByCourseId(@PathVariable Long courseId) {
        return offeringService.findByCourseId(courseId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CourseOfferingResponse findByProfessorAndCourse(
            @RequestParam Long professorId,
            @RequestParam Long courseId) {

        return offeringService.findByProfessorAndCourse(professorId, courseId);
    }
}

