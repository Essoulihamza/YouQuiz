package ma.youcode.YouQuiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.YouQuiz.models.embeddables.QuestionAssignmentKey;
import ma.youcode.YouQuiz.models.entities.associatives.QuestionAssignmentEntity;

@Repository
public interface QuestionAssignmentRepository extends JpaRepository<QuestionAssignmentEntity, QuestionAssignmentKey> {}
