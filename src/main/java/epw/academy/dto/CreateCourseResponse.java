package epw.academy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCourseResponse {

    private Long id;
    private String name;
    private String description;
    private Integer durationHours;
    private Long instructorId;
    private String instructorName;
}
