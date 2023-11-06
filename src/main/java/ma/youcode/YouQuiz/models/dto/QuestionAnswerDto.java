package ma.youcode.YouQuiz.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionAnswerDto {
    
    private Long id;
    private Double correctnessRate;
    private QuestionDto question;
    private AnswerDto answer;

}
