package ir.chat.service;

import ir.chat.Response.CourseOfferingResponse;
import ir.chat.entity.Course;
import ir.chat.entity.CourseOffering;
import ir.chat.entity.Professor;
import ir.chat.repository.CourseOfferingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseOfferingServiceImpl implements CourseOfferingService{

    private final CourseOfferingRepository courseOfferingRepository;
    private final ProfessorService professorService;
    private final CourseService courseService;

    @Override
    @Transactional
    public CourseOfferingResponse createOffering(Long professorId, Long courseId) {
        Professor professor = professorService.findById(professorId);
        Course course = courseService.findById(courseId);

        CourseOffering courseOffering = new CourseOffering(
                professor,
                course
        );

        CourseOffering saveOffering = courseOfferingRepository.save(courseOffering);

        return convertToCourseOfferingResponse(saveOffering);
    }

    @Override
    @Transactional(readOnly = true)
    public CourseOfferingResponse findByCourseId(Long courseId) {
        CourseOffering courseOffering = courseOfferingRepository.findByCourse_Id(courseId)
                .orElseThrow(() -> new EntityNotFoundException("No offering found for course: " + courseId));

        return convertToCourseOfferingResponse(courseOffering);
    }

    @Override
    @Transactional(readOnly = true)
    public CourseOffering getOfferingEntity(Long courseId) {
        return courseOfferingRepository.findByCourse_Id(courseId)
                .orElseThrow(() -> new EntityNotFoundException("No offering found for course: " + courseId));
    }

    @Override
    @Transactional(readOnly = true)
    public CourseOfferingResponse findByProfessorAndCourse(Long professorId, Long courseId) {
        CourseOffering courseOffering = courseOfferingRepository
                .findByProfessor_IdAndCourse_Id(professorId, courseId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No offering found for professor " + professorId
                                + " and course " + courseId));
        return convertToCourseOfferingResponse(courseOffering);
    }


    private CourseOfferingResponse convertToCourseOfferingResponse(CourseOffering courseOffering){
        CourseOfferingResponse response = new CourseOfferingResponse();

        response.setOfferingId(courseOffering.getOfferingId());
        response.setProfessorName(courseOffering.getProfessor().getName());
        response.setCourseName(courseOffering.getCourse().getName());

        return response;
    }
}
