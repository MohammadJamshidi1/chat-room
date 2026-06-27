package ir.internship.service;

import ir.internship.Response.RegistrationResponse;
import ir.internship.entity.CourseOffering;
import ir.internship.entity.Registration;
import ir.internship.entity.Student;
import ir.internship.repository.RegistrationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService{
    private final RegistrationRepository registrationRepository;
    private final StudentService studentService;
    private final CourseOfferingService offeringService;

    @Override
    @Transactional
    public RegistrationResponse register(Long studentId, Long courseId) {
        Student student  = studentService.getStudentEntity(studentId);
        CourseOffering offering = offeringService.getOfferingEntity(courseId);

        registrationRepository
                .findByStudent_IdAndCourseOffering_Course_Id(studentId, courseId)
                .ifPresent(r -> { throw new IllegalStateException(
                        "Student " + studentId + " is already registered for course " + courseId); });

        Registration registration = Registration.builder()
                .student(student)
                .courseOffering(offering)
                .build();

        Registration saveRegistration = registrationRepository.save(registration);

        return convertToRegistrationResponse(saveRegistration);
    }

    @Override
    @Transactional
    public void deleteRegistration(Long studentId, Long courseId) {
        Registration reg = registrationRepository
                .findByStudent_IdAndCourseOffering_Course_Id(studentId, courseId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Registration not found for student " + studentId
                                + " and course " + courseId));

        registrationRepository.delete(reg);
    }

    @Override
    @Transactional
    public RegistrationResponse assignScore(Long professorId, Long studentId, Long courseId, Double score) {
        if (score < 0 || score > 20)
            throw new IllegalArgumentException("Score must be between 0 and 20.");

        Registration registration = registrationRepository
                .findByStudentAndProfessorAndCourse(studentId, professorId, courseId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No registration found for this student/professor/course combination."));

        registration.setScore(score);
        Registration savedRegistration = registrationRepository.save(registration);

        recalculateGpa(studentId);

        return convertToRegistrationResponse(savedRegistration);
    }

    private void recalculateGpa(Long studentId) {
        double avg = registrationRepository.findAll().stream()
                .filter(r -> r.getStudent().getId().equals(studentId)
                        && r.getScore() != null)
                .mapToDouble(Registration::getScore)
                .average()
                .orElse(0.0);


        studentService.updateStudentGpa(studentId , avg);
    }

    @Override
    @Transactional(readOnly = true)
    public Double getAverageScoreForCourse(Long courseId) {
        return registrationRepository.findAverageScoreByCourseId(courseId)
                .orElse(0.0);
    }

    private RegistrationResponse convertToRegistrationResponse(Registration registration){
        RegistrationResponse response = new RegistrationResponse();

        response.setRegistrationId(registration.getRegistrationId());
        response.setStudentName(registration.getStudent().getFullName());
        response.setOfferingProfessorName(registration.getCourseOffering().getProfessor().getName());
        response.setOfferingCourseName(registration.getCourseOffering().getCourse().getName());

        return response;
    }
}

