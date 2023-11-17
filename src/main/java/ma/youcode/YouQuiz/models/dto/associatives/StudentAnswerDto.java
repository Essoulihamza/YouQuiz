package ma.youcode.YouQuiz.models.dto.associatives;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.YouQuiz.models.entities.ValidAnswerEntity;
import ma.youcode.YouQuiz.models.entities.QuizAssignmentEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class StudentAnswerDto {
    
    private Double score;

    @NotNull
    private ValidAnswerEntity questionAnswerEntity;

    @NotNull
    private QuizAssignmentEntity quizAssignmentEntity;

}
