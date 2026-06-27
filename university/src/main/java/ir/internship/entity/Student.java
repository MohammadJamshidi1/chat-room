package ir.internship.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter @Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "favorite_course_id")
    private Course favoriteCourse;

    @Column(nullable = false)
    private boolean isOnProbation;

    @Column(nullable = false)
    private Double gpa;

    public Student(String fullName , Course favoriteCourse , boolean isOnProbation , double gpa) {
        this.fullName = fullName;
        this.favoriteCourse = favoriteCourse;
        this.isOnProbation = isOnProbation;
        this.gpa = gpa;
    }

}
