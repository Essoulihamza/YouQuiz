package ma.youcode.YouQuiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.YouQuiz.models.entities.ValidAnswerEntity;

@Repository
public interface QuestionAnswerRepository extends JpaRepository<ValidAnswerEntity, Long> {}
