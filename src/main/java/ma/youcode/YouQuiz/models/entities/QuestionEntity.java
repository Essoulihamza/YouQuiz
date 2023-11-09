package ma.youcode.YouQuiz.models.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
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

    private String content;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private LevelEntity level;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<QuestionAnswerEntity> questionAnswers; 

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<MediaEntity> media;

}
