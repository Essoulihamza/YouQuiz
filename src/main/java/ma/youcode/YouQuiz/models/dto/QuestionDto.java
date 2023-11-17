package ma.youcode.YouQuiz.models.dto;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @NotEmpty(message = "Question content is required.")
    @Size(min = 3, max = 255, message = "Question answer should be between 3 and 255 character.")
    private String content;

    @NotEmpty(message = "Question type is required.")
    private QuestionType questionType;

    @NotEmpty(message = "Question level is required.")
    private LevelDto level;

    @NotEmpty(message = "Question subject is required.")
    private SubjectDto subject;

    @NotEmpty(message = "Question answers is required.")
    private Set<ValidAnswerDto> answers;
    
    private Set<MediaDto> media;
    
}
