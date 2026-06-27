package ir.internship.service;

import ir.internship.Request.ProfessorRequest;
import ir.internship.entity.Professor;

public interface ProfessorService {

    Professor addProfessor(ProfessorRequest request);
    Professor findById(Long id);
}
