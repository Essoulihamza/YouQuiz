package ma.youcode.YouQuiz.services.Impl;

import java.util.List;

import ma.youcode.YouQuiz.models.dto.QuestionAnswerDto;
import ma.youcode.YouQuiz.models.entities.QuestionAnswerEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;
import ma.youcode.YouQuiz.repositories.QuestionAnswerRepository;
import ma.youcode.YouQuiz.services.interfaces.QuestionAnswerService;

public class QuestionAnswerServiceImpl implements QuestionAnswerService {

    private final QuestionAnswerRepository repository;
    private final Mapper<QuestionAnswerEntity, QuestionAnswerDto> mapper;

    public QuestionAnswerServiceImpl(QuestionAnswerRepository repository, Mapper<QuestionAnswerEntity, QuestionAnswerDto> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public QuestionAnswerDto save(QuestionAnswerDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<QuestionAnswerDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public QuestionAnswerDto update(Long identifier, QuestionAnswerDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public QuestionAnswerDto find(Long identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public QuestionAnswerDto partialUpdate(Long identifier, QuestionAnswerDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'partialUpdate'");
    }

    @Override
    public boolean isExist(Long identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExist'");
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }
    
}
