package ir.chat.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long id;
    private String fullName;
    private String favoriteCourseName;
    private boolean isOnProbation;
    private Double gpa;
}
