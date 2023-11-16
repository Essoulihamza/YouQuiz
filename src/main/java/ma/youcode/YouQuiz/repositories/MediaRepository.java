package ma.youcode.YouQuiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.YouQuiz.models.entities.MediaEntity;

@Repository
public interface MediaRepository extends JpaRepository<MediaEntity, Long> {}
