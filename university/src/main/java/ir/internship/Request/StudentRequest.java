package ir.internship.Request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    @NotNull(message = "Full name is mandatory")
    @Size(min = 3, max = 50, message = "Full name must be between 3 and 50 characters")
    private String fullName;

    @Positive(message = "Course ID must be a positive number")
    private Long favoriteCourseId;

    @NotNull(message = "Probation status must be specified (true/false)")
    private Boolean isOnProbation;

    @NotNull(message = "GPA is mandatory")
    @DecimalMin(value = "0.0", message = "GPA cannot be less than 0")
    @DecimalMax(value = "20.0", message = "GPA cannot be more than 20")
    private Double gpa;
}
