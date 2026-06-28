package ir.chat.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "professors")
@Getter @Setter
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Professor(String name){
        this.name = name;
    }
}
