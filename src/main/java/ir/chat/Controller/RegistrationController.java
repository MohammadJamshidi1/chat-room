package ir.chat.Controller;


import ir.chat.Response.RegistrationResponse;
import ir.chat.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegistrationResponse register(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {
        return registrationService.register(studentId, courseId);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteRegistration(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {
        registrationService.deleteRegistration(studentId, courseId);
    }

    @PutMapping("/score")
    public RegistrationResponse assignScore(
            @RequestParam Long professorId,
            @RequestParam Long studentId,
            @RequestParam Long courseId,
            @RequestParam Double score) {
        return registrationService.assignScore(professorId, studentId, courseId, score);
    }

}
