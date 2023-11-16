package ma.youcode.YouQuiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.YouQuiz.models.entities.QuizEntity;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Long> {}
