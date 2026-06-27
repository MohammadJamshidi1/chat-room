package ir.chat.service;

import ir.chat.Request.ProfessorRequest;
import ir.chat.entity.Professor;

public interface ProfessorService {

    Professor addProfessor(ProfessorRequest request);
    Professor findById(Long id);
}
