package ma.youcode.YouQuiz.models.dto;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.YouQuiz.models.dto.super_classes.PersonDto;
import ma.youcode.YouQuiz.models.entities.QuizEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TrainerDto extends PersonDto {
    
    @NotEmpty(message = "Specialization is required.")
    @Size(max = 50, message = "Specialization must be less than 50 character.")
    private String specialization;

    private Set<QuizEntity> quizzes;
}
