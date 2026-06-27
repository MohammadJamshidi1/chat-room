package ir.internship.Request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    @NotEmpty(message = "name is mandatory")
    @Size(min = 3 , max = 20 , message = "name must be at least 3 character")
    private String name;

    @Min(15)
    @Max(50)
    private int capacity;
}
