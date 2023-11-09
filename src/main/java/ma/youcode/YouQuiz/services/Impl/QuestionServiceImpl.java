package ma.youcode.YouQuiz.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.models.dto.QuestionDto;
import ma.youcode.YouQuiz.models.entities.QuestionEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;
import ma.youcode.YouQuiz.repositories.QuestionRepository;
import ma.youcode.YouQuiz.services.QuestionService;

@AllArgsConstructor

@Service
public class QuestionServiceImpl implements QuestionService {
    
    private final QuestionRepository repository;
    private final Mapper<QuestionEntity, QuestionDto> mapper;

    @Override
    public QuestionDto save(QuestionDto questionDto) {
        var questionEntity = mapper.mapFrom(questionDto);
        var savedEntity = repository.save(questionEntity);
        return mapper.mapTo(savedEntity);
    }
    
    @Override
    public List<QuestionDto> getAll() {
        return repository.findAll()
                         .stream()
                         .map(mapper::mapTo)
                         .collect(Collectors.toList());
    }

    @Override
    public QuestionDto update(Long id, QuestionDto questionDto) {
        questionDto.setId(id);
        return save(questionDto);
    }

    @Override
    public void delete(Long identifier) {
        repository.deleteById(identifier);
    }

    @Override
    public QuestionDto find(Long identifier) {
        var optionalQuestion = repository.findById(identifier);
        return optionalQuestion.isPresent() ?
            mapper.mapTo(optionalQuestion.get())
        :
            null; 
    }

    @Override
    public boolean isExist(Long identifier) {
        return repository.existsById(identifier);
    }
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
    @Override
    public QuestionDto partialUpdate(Long identifier, QuestionDto questionDto) {
        questionDto.setId(identifier);
        var questionEntity = mapper.mapFrom(questionDto);
        return repository.findById(identifier).map(founded -> {
            Optional.ofNullable(questionEntity.getContent()).ifPresent(founded::setContent);
            Optional.ofNullable(questionEntity.getLevel()).ifPresent(founded::setLevel);
            Optional.ofNullable(questionEntity.getMedia()).ifPresent(founded::setMedia);
            Optional.ofNullable(questionEntity.getQuestionType()).ifPresent(founded::setQuestionType);
            Optional.ofNullable(questionEntity.getQuestionAnswers()).ifPresent(founded::setQuestionAnswers);
            return mapper.mapTo(repository.save(founded));
        }).orElseThrow(() -> new RuntimeException("question not found"));
    }
    

    

}
