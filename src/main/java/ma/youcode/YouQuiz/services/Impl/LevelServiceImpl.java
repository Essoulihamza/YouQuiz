package ma.youcode.YouQuiz.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

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
        return repository.findAll()
                         .stream()
                         .map(mapper::mapTo)
                         .collect(Collectors.toList());
    }

    @Override
    public LevelDto update(Integer id, LevelDto levelDto) {
        levelDto.setId(id);
        return save(levelDto);
    }

    @Override
    public void delete(Integer identifier) {
        repository.deleteById(identifier);
    }

    @Override
    public LevelDto find(Integer identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public boolean isExist(Integer identifier) {
        return repository.existsById(identifier);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
    
    @Override
    public LevelDto partialUpdate(Integer identifier, LevelDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'partialUpdate'");
    }

}
