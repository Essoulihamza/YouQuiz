package ma.youcode.YouQuiz.models.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class QuestionAssignmentKey {
    
    @Column(name = "question_id", nullable = false)
    private long question;

    @Column(name = "quiz_id", nullable = false)
    private long quiz;

}
