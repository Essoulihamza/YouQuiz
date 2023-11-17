package ma.youcode.YouQuiz.services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.models.dto.associatives.StudentAnswerDto;
import ma.youcode.YouQuiz.models.embeddables.StudentAnswerKey;
import ma.youcode.YouQuiz.models.entities.associatives.StudentAnswerEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;
import ma.youcode.YouQuiz.repositories.StudentAnswerRepositoty;
import ma.youcode.YouQuiz.services.interfaces.StudentAnswerService;

@AllArgsConstructor

@Service
public class StudentAnswerServiceImpl implements StudentAnswerService {

    private final StudentAnswerRepositoty repositoty;
    private final Mapper<StudentAnswerEntity, StudentAnswerDto> mapper;

    @Override
    public StudentAnswerDto save(StudentAnswerDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<StudentAnswerDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public StudentAnswerDto update(StudentAnswerKey identifier, StudentAnswerDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(StudentAnswerKey identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public StudentAnswerDto find(StudentAnswerKey identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public StudentAnswerDto partialUpdate(StudentAnswerKey identifier, StudentAnswerDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'partialUpdate'");
    }

    @Override
    public boolean isExist(StudentAnswerKey identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExist'");
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }
    
}
