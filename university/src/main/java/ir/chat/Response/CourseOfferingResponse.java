package ir.chat.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseOfferingResponse {

    private Long offeringId;

    private String professorName;

    private String courseName;
}
