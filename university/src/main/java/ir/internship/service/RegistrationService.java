package ir.internship.service;

import ir.internship.Response.RegistrationResponse;

public interface RegistrationService {

    RegistrationResponse register(Long studentId, Long courseId);
    void deleteRegistration(Long studentId, Long courseId);
    RegistrationResponse assignScore(Long professorId, Long studentId, Long courseId, Double score);
    Double getAverageScoreForCourse(Long courseId);

}
