package ma.youcode.YouQuiz.models.dto;

import java.util.Set;

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
    private String name;
    private String description;
    private Double maxPoint;
    private Double minPoint; 

    private Set<QuestionDto> questions;
}
