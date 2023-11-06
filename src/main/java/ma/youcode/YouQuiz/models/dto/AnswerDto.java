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
public class AnswerDto {
    
    private Long id;
    private String content;
    private Set<QuestionAnswerDto> questionAnswers;
}
