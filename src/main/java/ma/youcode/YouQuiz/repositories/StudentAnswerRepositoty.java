package ma.youcode.YouQuiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.YouQuiz.models.embeddables.StudentAnswerKey;
import ma.youcode.YouQuiz.models.entities.associatives.StudentAnswerEntity;

@Repository
public interface StudentAnswerRepositoty extends JpaRepository<StudentAnswerEntity, StudentAnswerKey> {}
