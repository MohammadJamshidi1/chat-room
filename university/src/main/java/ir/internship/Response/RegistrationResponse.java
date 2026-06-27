package ir.internship.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationResponse {

    private Long registrationId;

    private String studentName;

    private String offeringProfessorName;

    private String offeringCourseName;
}
