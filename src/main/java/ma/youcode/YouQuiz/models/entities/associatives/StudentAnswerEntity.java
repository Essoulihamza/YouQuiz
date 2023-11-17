package ma.youcode.YouQuiz.models.entities.associatives;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.YouQuiz.models.embeddables.StudentAnswerKey;
import ma.youcode.YouQuiz.models.entities.ValidAnswerEntity;
import ma.youcode.YouQuiz.models.entities.QuizAssignmentEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "student_answers")
public class StudentAnswerEntity {
    
    @EmbeddedId
    private StudentAnswerKey id;

    @Column(nullable = false)
    private Double score;

    @ManyToOne
    @MapsId("question_answer_id")
    private ValidAnswerEntity questionAnswerEntity;

    @ManyToOne
    @MapsId("quiz_assignment_id")
    private QuizAssignmentEntity quizAssignmentEntity;

}
