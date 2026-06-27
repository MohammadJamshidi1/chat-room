package ir.internship.service;

import ir.internship.Request.StudentRequest;
import ir.internship.Response.StudentResponse;
import ir.internship.entity.Student;

import java.util.List;

public interface StudentService {

    StudentResponse addStudent(StudentRequest request);
    StudentResponse findById(Long id);
    Student getStudentEntity(Long id);
    StudentResponse updateFavoriteCourse(Long studentId, Long courseId);
    StudentResponse updateStudentGpa(Long studentId , double newGpa);
    List<StudentResponse> getStudentsByMinGpa(Double minScore);
}
