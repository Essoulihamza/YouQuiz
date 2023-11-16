package ma.youcode.YouQuiz.models.entities.associatives;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import ma.youcode.YouQuiz.models.embeddables.QuestionAssignmentKey;
import ma.youcode.YouQuiz.models.entities.QuestionEntity;
import ma.youcode.YouQuiz.models.entities.QuizEntity;

@Entity
@Table(name = "questions_assignments")
public class QuestionAssignmentEntity {
    
    @EmbeddedId
    private QuestionAssignmentKey id;

    @Column(nullable = false)
    private Integer durationInSeconds;

    @Column(nullable = false)
    private Boolean isStrict;

    @Column(nullable = false)
    private Double points;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("question_id")
    private QuestionEntity question;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("quiz_id")
    private QuizEntity quiz;


}
