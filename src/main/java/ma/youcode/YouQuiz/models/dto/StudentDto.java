package ma.youcode.YouQuiz.models.dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.YouQuiz.models.dto.super_classes.PersonDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class StudentDto extends PersonDto {

    private LocalDate inscreptionDate;
    private Set<QuizAssignmentDto> quizAssignments;
}
