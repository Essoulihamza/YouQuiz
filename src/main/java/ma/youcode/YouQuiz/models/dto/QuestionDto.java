package ma.youcode.YouQuiz.models.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.YouQuiz.models.enums.QuestionType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDto {
    
    private Long id;
    private String content;
    private QuestionType questionType;
    private LevelDto level;
    private Set<QuestionAnswerDto> questionAnswers; 
    private Set<MediaDto> media;
    
}
