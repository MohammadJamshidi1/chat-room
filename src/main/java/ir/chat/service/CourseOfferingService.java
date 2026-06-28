package ir.chat.service;

import ir.chat.Response.CourseOfferingResponse;
import ir.chat.entity.CourseOffering;

public interface CourseOfferingService {

    CourseOfferingResponse createOffering(Long professorId, Long courseId);
    CourseOfferingResponse findByCourseId(Long courseId);
    CourseOffering getOfferingEntity(Long courseId);
    CourseOfferingResponse findByProfessorAndCourse(Long professorId, Long courseId);
}
