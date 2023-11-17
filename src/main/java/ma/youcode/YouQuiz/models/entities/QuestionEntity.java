package ma.youcode.YouQuiz.models.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import ma.youcode.YouQuiz.models.enums.QuestionType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "questions")
public class QuestionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private LevelEntity level;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectEntity subject;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<ValidAnswerEntity> answers; 

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<MediaEntity> media;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<QuestionAssignmentEntity> questionAssignments;

}
