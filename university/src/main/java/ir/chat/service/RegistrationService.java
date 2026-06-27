package ir.chat.service;

import ir.chat.Response.RegistrationResponse;

public interface RegistrationService {

    RegistrationResponse register(Long studentId, Long courseId);
    void deleteRegistration(Long studentId, Long courseId);
    RegistrationResponse assignScore(Long professorId, Long studentId, Long courseId, Double score);
    Double getAverageScoreForCourse(Long courseId);

}
