package epw.academy.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCourseRequest {

    @NotBlank
    @Size(max = 120)
    private String name;

    @Size(max = 255)
    private String description;

    @NotNull
    @Min(1)
    private Integer durationHours;

    @NotNull
    private Long instructorId;
}
