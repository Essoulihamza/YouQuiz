package ma.youcode.YouQuiz.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.exceptions.ResourceNotFoundException;
import ma.youcode.YouQuiz.models.dto.QuestionDto;
import ma.youcode.YouQuiz.models.entities.QuestionEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;
import ma.youcode.YouQuiz.repositories.LevelRepository;
import ma.youcode.YouQuiz.repositories.QuestionRepository;
import ma.youcode.YouQuiz.repositories.SubjectRepository;
import ma.youcode.YouQuiz.services.QuestionService;

@AllArgsConstructor

@Service
public class QuestionServiceImpl implements QuestionService {
    
    private final QuestionRepository questionRepository;
    private final LevelRepository levelRepository;
    private final SubjectRepository subjectRepository;
    private final Mapper<QuestionEntity, QuestionDto> mapper;

    @Override
    public QuestionDto save(final QuestionDto questionDto) throws RuntimeException {
        checkResourcesExistency(questionDto);
        var questionEntity = mapper.mapFrom(questionDto);
        var savedEntity = questionRepository.save(questionEntity);
        return mapper.mapTo(savedEntity);
    }
    
    @Override
    public List<QuestionDto> getAll() {
        return questionRepository.findAll()
                         .stream()
                         .map(mapper::mapTo)
                         .collect(Collectors.toList());
    }

    @Override
    public QuestionDto update(final Long id, final QuestionDto questionDto) {
        checkResourcesExistency(questionDto);
        questionDto.setId(id);
        return save(questionDto);
    }

    @Override
    public void delete(final Long identifier) {
        questionRepository.deleteById(identifier);
    }

    @Override
    public QuestionDto find(final Long identifier) {
        var optionalQuestion = questionRepository.findById(identifier);
        return optionalQuestion.isPresent() ?
            mapper.mapTo(optionalQuestion.get())
        :
            null; 
    }

    @Override
    public boolean isExist(final Long identifier) {
        return questionRepository.existsById(identifier);
    }

    @Override
    public void deleteAll() {
        questionRepository.deleteAll();
    }

    @Override
    public QuestionDto partialUpdate(final Long identifier, final QuestionDto questionDto) {
        checkResourcesExistency(questionDto);
        questionDto.setId(identifier);
        var questionEntity = mapper.mapFrom(questionDto);
        return questionRepository.findById(identifier).map(founded -> {
            Optional.ofNullable(questionEntity.getContent()).ifPresent(founded::setContent);
            Optional.ofNullable(questionEntity.getLevel()).ifPresent(founded::setLevel);
            Optional.ofNullable(questionEntity.getMedia()).ifPresent(founded::setMedia);
            Optional.ofNullable(questionEntity.getQuestionType()).ifPresent(founded::setQuestionType);
            Optional.ofNullable(questionEntity.getQuestionAnswers()).ifPresent(founded::setQuestionAnswers);
            return mapper.mapTo(questionRepository.save(founded));
        }).orElseThrow(() -> new RuntimeException("question not found"));
    }


    private void checkResourcesExistency(final QuestionDto questionDto) {
        if(questionDto.getLevel().getId() != null)
            levelRepository.findById(
                questionDto.getLevel()
                            .getId())
                            .orElseThrow(() -> new ResourceNotFoundException("level not found"));
        if(questionDto.getSubject().getId() != null)
            subjectRepository.findById(
                questionDto.getSubject()
                           .getId())
                           .orElseThrow(() -> new ResourceNotFoundException("subject not found"));
    }
    

    

}
