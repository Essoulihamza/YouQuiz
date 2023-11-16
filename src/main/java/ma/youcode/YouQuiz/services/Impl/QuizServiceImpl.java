package ma.youcode.YouQuiz.services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.youcode.YouQuiz.models.dto.QuizDto;
import ma.youcode.YouQuiz.models.entities.QuizEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;
import ma.youcode.YouQuiz.repositories.QuizRepository;
import ma.youcode.YouQuiz.services.interfaces.QuizService;

@Service
public class QuizServiceImpl implements QuizService  {

    private final QuizRepository repository;
    private final Mapper<QuizEntity, QuizDto> mapper;

    public QuizServiceImpl(QuizRepository repository, Mapper<QuizEntity, QuizDto> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public QuizDto save(QuizDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<QuizDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public QuizDto update(Long identifier, QuizDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public QuizDto find(Long identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public QuizDto partialUpdate(Long identifier, QuizDto dto) {
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
