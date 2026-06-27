package ir.chat.service;

import ir.chat.Request.StudentRequest;
import ir.chat.Response.StudentResponse;
import ir.chat.entity.Course;
import ir.chat.entity.Student;
import ir.chat.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final CourseService courseService;

    @Override
    @Transactional
    public StudentResponse addStudent(StudentRequest request) {
        Course favoriteCourse = courseService.findById(request.getFavoriteCourseId());

        Student student = new Student(
                request.getFullName(),
                favoriteCourse,
                request.getIsOnProbation(),
                request.getGpa()
        );
        Student saveStudent = studentRepository.save(student);

        return convertToStudentResponse(saveStudent);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentResponse findById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found: " + id));

        return convertToStudentResponse(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Student getStudentEntity(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found: " + id));
    }

    @Override
    @Transactional
    public StudentResponse updateFavoriteCourse(Long studentId, Long courseId) {
        Student student = getStudentEntity(studentId);
        Course newFaveCourse = courseService.findById(courseId);

        student.setFavoriteCourse(newFaveCourse);
        Student saveStudent = studentRepository.save(student);
        return convertToStudentResponse(saveStudent);

    }
    @Override
    @Transactional(readOnly = true)
    public List<StudentResponse> getStudentsByMinGpa(Double minScore) {
        return studentRepository.findByGpaGreaterThanEqual(minScore).stream()
                .map(this::convertToStudentResponse)
                .toList();
    }

    @Transactional
    public StudentResponse updateStudentGpa(Long studentId , double newGpa) {
        Student student = getStudentEntity(studentId);
        student.setGpa(newGpa);
        student.setOnProbation(newGpa < 10.0);

        Student saveStudent = studentRepository.save(student);

        return convertToStudentResponse(saveStudent);
    }

    private StudentResponse convertToStudentResponse(Student student) {
        StudentResponse response = new StudentResponse();

        response.setId(student.getId());
        response.setFullName(student.getFullName());
        response.setFavoriteCourseName(student.getFavoriteCourse().getName());
        response.setOnProbation(student.isOnProbation());
        response.setGpa(student.getGpa());

        return response;

    }
}
