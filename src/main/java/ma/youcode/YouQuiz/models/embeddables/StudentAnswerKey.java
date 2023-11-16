package ma.youcode.YouQuiz.models.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class StudentAnswerKey {
    
    @Column(name = "quiz_assignment_id", nullable = false)
    private Long quizAssignment;

    @Column(name = "question_answer_id", nullable = false)
    private Long questionAnswer;

}
