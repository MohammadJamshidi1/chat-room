package ir.chat.service;

import ir.chat.Request.ProfessorRequest;
import ir.chat.entity.Professor;
import ir.chat.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService{

    private final ProfessorRepository professorRepository;


    @Override
    @Transactional
    public Professor addProfessor(ProfessorRequest request) {
        Professor professor = new Professor(request.getName());
        return professorRepository.save(professor);
    }

    @Override
    @Transactional(readOnly = true)
    public Professor findById(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor not found: " + id));
    }
}
