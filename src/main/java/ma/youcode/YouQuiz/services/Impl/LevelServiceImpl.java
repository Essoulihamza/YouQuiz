package ma.youcode.YouQuiz.services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.models.dto.LevelDto;
import ma.youcode.YouQuiz.models.entities.LevelEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;
import ma.youcode.YouQuiz.repositories.LevelRepository;
import ma.youcode.YouQuiz.services.LevelService;

@AllArgsConstructor

@Service
public class LevelServiceImpl implements LevelService {
    
    private final LevelRepository repository;
    private final Mapper<LevelEntity, LevelDto> mapper;

    @Override
    public LevelDto save(LevelDto levelDto) {
        var newLevelEntity = mapper.mapFrom(levelDto);
        var createdLeveltDto = mapper.mapTo(repository.save(newLevelEntity));
        return createdLeveltDto;
    }
    
    @Override
    public List<LevelDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }
    @Override
    public LevelDto update(Integer id, LevelDto levelDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public void delete(Integer identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public LevelDto find(Integer identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }
    @Override
    public boolean isExist(Integer identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExist'");
    }
    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }
    @Override
    public LevelDto partialUpdate(Integer identifier, LevelDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'partialUpdate'");
    }

}
