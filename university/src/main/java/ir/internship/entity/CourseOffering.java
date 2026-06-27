package ir.internship.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "course_offering" ,
        uniqueConstraints = @UniqueConstraint(columnNames = {"professor_id", "course_id"}))
@Getter @Setter
@NoArgsConstructor
public class CourseOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offeringId;

    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "professor_id" , nullable = false)
    private Professor professor;

    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "course_id" , nullable = false)
    private Course course;

    public CourseOffering(Professor professor , Course course){
        this.professor = professor;
        this.course = course;
    }
}
