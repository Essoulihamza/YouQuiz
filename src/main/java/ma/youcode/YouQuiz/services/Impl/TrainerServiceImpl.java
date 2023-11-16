package ma.youcode.YouQuiz.services.Impl;

import java.util.List;

import ma.youcode.YouQuiz.models.dto.TrainerDto;
import ma.youcode.YouQuiz.models.entities.TrainerEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;
import ma.youcode.YouQuiz.repositories.TrainerRepositoty;
import ma.youcode.YouQuiz.services.interfaces.TrainerService;

public class TrainerServiceImpl implements TrainerService {
    
    private final TrainerRepositoty repository;
    private final Mapper<TrainerEntity, TrainerDto> mapper;

    public TrainerServiceImpl(TrainerRepositoty repository, Mapper<TrainerEntity, TrainerDto> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TrainerDto save(TrainerDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<TrainerDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public TrainerDto update(Long identifier, TrainerDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public TrainerDto find(Long identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public TrainerDto partialUpdate(Long identifier, TrainerDto dto) {
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
