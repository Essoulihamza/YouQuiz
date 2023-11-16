package ma.youcode.YouQuiz.models.entities;

import java.time.LocalTime;
import java.util.Set;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.YouQuiz.models.entities.associatives.QuestionAssignmentEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "quizzes")
public class QuizEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer durationInMinutes;

    @Column(nullable = false)
    private Double passScore;

    private Integer maxChances;

    @Column(nullable = false)
    private boolean canSeeResult;

    @Column(nullable = false)
    private boolean canSeeAnswers;

    @ColumnDefault("CURRENT_TIME")
    private LocalTime created_at;

    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = false)
    private TrainerEntity trainer;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private Set<QuestionAssignmentEntity> questionAssignments;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private Set<QuizAssignmentEntity> quizAssignments;


}
