package epw.academy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CreateCourseResponse {

    private Long id;
    private String name;
    private String description;
    private Integer durationHours;
}
