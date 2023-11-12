package ma.youcode.YouQuiz.models.dto;

import java.util.Set;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LevelDto {
    
    private Integer id;

    @NotEmpty(message = "Level name is required.")
    @Size(max = 50, message = "Level name must be less than 50 character.")
    private String name;

    @NotEmpty(message = "Level description is required.")
    @Size(max = 255, message = "Level description must be less than 255 character.")
    private String description;

    @NotNull(message = "Level min point can't be null.")
    @Min(value = 0, message = "Level max point can't be less than 0.")
    private Double maxPoint;
    
    @NotNull(message = "Level max point can't be null")
    @Min(value = 0, message = "Level min point can't be less than 0.")
    private Double minPoint; 

    private Set<QuestionDto> questions;
}
