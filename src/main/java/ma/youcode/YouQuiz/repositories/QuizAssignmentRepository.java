package ma.youcode.YouQuiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.YouQuiz.models.entities.QuizAssignmentEntity;

@Repository
public interface QuizAssignmentRepository extends JpaRepository<QuizAssignmentEntity, Long> {}
