package ma.youcode.YouQuiz.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.models.dto.LevelDto;
import ma.youcode.YouQuiz.models.entities.LevelEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;
import ma.youcode.YouQuiz.repositories.LevelRepository;
import ma.youcode.YouQuiz.services.interfaces.LevelService;

@AllArgsConstructor

@Service
public class LevelServiceImpl implements LevelService {
    
    private final LevelRepository repository;
    private final Mapper<LevelEntity, LevelDto> mapper;

    @Override
    public LevelDto save(final LevelDto levelDto) {
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
    public LevelDto update(final Integer id, final LevelDto levelDto) {
        levelDto.setId(id);
        return save(levelDto);
    }

    @Override
    public void delete(final Integer identifier) {
        repository.deleteById(identifier);
    }

    @Override
    public LevelDto find(final Integer identifier) {
        var optionalEntity = repository.findById(identifier);
        return optionalEntity.isPresent() ?
            mapper.mapTo(optionalEntity.get())
        :
            null;
    }

    @Override
    public boolean isExist(final Integer identifier) {
        return repository.existsById(identifier);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public LevelDto partialUpdate(final Integer identifier, final LevelDto levelDto) {
        levelDto.setId(identifier);
        return repository.findById(identifier).map(foundedLevel -> {
            Optional.ofNullable(levelDto.getName()).ifPresent(foundedLevel::setName);
            Optional.ofNullable(levelDto.getDescription()).ifPresent(foundedLevel::setDescription);
            Optional.ofNullable(levelDto.getMaxPoint()).ifPresent(foundedLevel::setMaxPoint);
            Optional.ofNullable(levelDto.getMinPoint()).ifPresent(foundedLevel::setMinPoint);
            return mapper.mapTo(repository.save(foundedLevel));
        }).orElseThrow(() -> new RuntimeException("level not found"));
    }

}
