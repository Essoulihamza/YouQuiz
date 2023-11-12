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
public class SubjectDto {
    
    private Long id;
    private String title;
    private SubjectDto parentSubject;
    private Set<SubjectDto> childrenSubjects;
    private Set<QuestionDto> questions;
}
