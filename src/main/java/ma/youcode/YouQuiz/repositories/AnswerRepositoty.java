package ma.youcode.YouQuiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.YouQuiz.models.entities.AnswerEntity;

@Repository
public interface AnswerRepositoty extends JpaRepository<AnswerEntity, Long> {
    
}
