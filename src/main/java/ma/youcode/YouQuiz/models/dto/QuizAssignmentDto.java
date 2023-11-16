package ma.youcode.YouQuiz.models.dto;

import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.YouQuiz.models.enums.TestResult;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class QuizAssignmentDto {
    
    private Long id;

    @NotNull
    private LocalTime startDate;

    @NotNull
    private LocalTime endDate;

    private String remark;

    @NotNull
    private Integer chance;

    
    private Double score;
    private TestResult result;

    @NotNull
    private QuizDto quiz;

    @NotNull
    private StudentDto student;

    
}
