package ma.youcode.YouQuiz.models.entities;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
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
@Table(name = "students")
public final class StudentEntity extends PersonEntity {
    
    @ColumnDefault("CURRENT_DATE")
    private LocalDate inscreptionDate;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<QuizAssignmentEntity> quizAssignments;
}
