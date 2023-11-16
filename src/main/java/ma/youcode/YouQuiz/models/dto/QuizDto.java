package ma.youcode.YouQuiz.models.dto;

import java.time.LocalTime;
import java.util.Set;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class QuizDto {
    
    private Long id;
    
    @Max(value = 480, message = "Quiz duration must be less than 8 hours.")
    private Integer durationInMinutes;

    @NotNull(message = "Pass score is required.")
    private Double passScore;

    @NotNull(message = "Max chances is required.")
    private Integer maxChances;

    @NotNull(message = "Can see result is required.")
    private Boolean canSeeResult;

    @NotNull(message = "Can see answers is required.")
    private Boolean canSeeAnswers;

    private LocalTime created_at;

    @NotNull(message = "Quiz trainer is required.")
    private TrainerDto trainer;

    private Set<QuizAssignmentDto> quizAssignments;

}
