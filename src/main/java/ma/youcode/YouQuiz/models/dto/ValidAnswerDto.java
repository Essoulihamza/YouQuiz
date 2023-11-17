package ma.youcode.YouQuiz.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidAnswerDto {
    
    private Long id;

    @NotNull(message = "Answer correctness rate is required.")
    @Min(value = 0, message = "Answer correctness rate can't be less than zero.")
    private Double correctnessRate;

    @NotNull(message = "Question can't be null.")
    private QuestionDto question;

    @NotNull(message = "Answer can't be null.")
    private AnswerDto answer;

}
