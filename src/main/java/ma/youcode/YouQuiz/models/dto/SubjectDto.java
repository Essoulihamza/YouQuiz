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
public class SubjectDto {
    
    private Long id;

    @NotEmpty(message = "Subject title is required.")
    @Size(max = 50, message = "Subject title must be less than 50 character.")
    private String title;

    private SubjectDto parentSubject;
    private Set<SubjectDto> childrenSubjects;
    private Set<QuestionDto> questions;
}
