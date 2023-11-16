package ma.youcode.YouQuiz.models.dto;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @NotEmpty(message = "Answer content is required")
    @Size(max = 255, message = "Answer content must be less than 255 character.")
    private String content;

    @NotEmpty(message = "Can't add an answer without assign it to a question.")
    private Set<QuestionAnswerDto> questionAnswers;

}
