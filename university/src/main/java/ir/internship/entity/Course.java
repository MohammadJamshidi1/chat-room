package ir.internship.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@Getter @Setter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int capacity;

    public Course(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}
