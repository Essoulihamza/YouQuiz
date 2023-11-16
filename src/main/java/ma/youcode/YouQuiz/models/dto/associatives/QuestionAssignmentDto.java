package ma.youcode.YouQuiz.models.dto.associatives;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.YouQuiz.models.entities.QuestionEntity;
import ma.youcode.YouQuiz.models.entities.QuizEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class QuestionAssignmentDto {
    
    @Max(value = 28800, message = "Duration must be less than 8 hours.")
    private Integer durationInSeconds;

    @NotNull
    private Boolean isStrict;

    @NotNull
    private Double points;

    @NotNull
    private QuestionEntity question;

    @NotNull
    private QuizEntity quiz;
}
