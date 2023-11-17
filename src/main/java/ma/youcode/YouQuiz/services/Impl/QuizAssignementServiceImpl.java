package ma.youcode.YouQuiz.services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.models.dto.QuizAssignmentDto;
import ma.youcode.YouQuiz.models.entities.QuizAssignmentEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;
import ma.youcode.YouQuiz.repositories.QuizAssignmentRepository;
import ma.youcode.YouQuiz.services.interfaces.QuizAssignmentService;

@AllArgsConstructor

@Service
public class QuizAssignementServiceImpl implements QuizAssignmentService {

    private final QuizAssignmentRepository repository;
    private final Mapper<QuizAssignmentEntity, QuizAssignmentDto> mapper;

    @Override
    public QuizAssignmentDto save(QuizAssignmentDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<QuizAssignmentDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public QuizAssignmentDto update(Long identifier, QuizAssignmentDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public QuizAssignmentDto find(Long identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public QuizAssignmentDto partialUpdate(Long identifier, QuizAssignmentDto dto) {
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
