package ir.chat.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "registrations" ,
        uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "offering_id"}))
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RegistrationId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "offering_id", nullable = false)
    private CourseOffering courseOffering;

    private Double score;
}
