package ir.internship.service;

import ir.internship.Response.CourseOfferingResponse;
import ir.internship.entity.CourseOffering;

public interface CourseOfferingService {

    CourseOfferingResponse createOffering(Long professorId, Long courseId);
    CourseOfferingResponse findByCourseId(Long courseId);
    CourseOffering getOfferingEntity(Long courseId);
    CourseOfferingResponse findByProfessorAndCourse(Long professorId, Long courseId);
}
