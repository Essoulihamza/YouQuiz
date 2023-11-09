package ma.youcode.YouQuiz.services.Impl;

import java.util.List;

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
    
    private final QuestionRepository questionRepository;
    private final Mapper<QuestionEntity, QuestionDto> questionMapper;

    @Override
    public QuestionDto save(QuestionDto questionDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    @Override
    public List<QuestionDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }
    @Override
    public QuestionDto update(Long id, QuestionDto questionDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public void delete(Long identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public QuestionDto find(Long identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
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
    @Override
    public QuestionDto partialUpdate(Long identifier, QuestionDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'partialUpdate'");
    }
    

    

}
