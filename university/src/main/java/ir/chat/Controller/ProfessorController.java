package ir.chat.Controller;

import ir.chat.Request.ProfessorRequest;
import ir.chat.entity.Professor;
import ir.chat.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professors")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Professor> addProfessor(@Valid @RequestBody ProfessorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.addProfessor(request));
    }

    @GetMapping("/{professorId}")
    public ResponseEntity<Professor> findById(@PathVariable Long professorId) {
        return ResponseEntity.ok(professorService.findById(professorId));
    }
}
