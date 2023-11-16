package ma.youcode.YouQuiz.models.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.YouQuiz.models.entities.super_classes.PersonEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "trainers")
public final class TrainerEntity extends PersonEntity {
    
    @Column(nullable = false, length = 50)
    private String specialization;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private Set<QuizEntity> quizzes;
}
