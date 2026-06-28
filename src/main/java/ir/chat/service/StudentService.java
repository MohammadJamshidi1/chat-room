package ir.chat.service;

import ir.chat.Request.StudentRequest;
import ir.chat.Response.StudentResponse;
import ir.chat.entity.Student;

import java.util.List;

public interface StudentService {

    StudentResponse addStudent(StudentRequest request);
    StudentResponse findById(Long id);
    Student getStudentEntity(Long id);
    StudentResponse updateFavoriteCourse(Long studentId, Long courseId);
    StudentResponse updateStudentGpa(Long studentId , double newGpa);
    List<StudentResponse> getStudentsByMinGpa(Double minScore);
}
