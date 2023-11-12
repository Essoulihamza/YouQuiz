package ma.youcode.YouQuiz.models.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.youcode.YouQuiz.models.dto.LevelDto;
import ma.youcode.YouQuiz.models.entities.LevelEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;

@Component
public class LevelMapper implements Mapper<LevelEntity, LevelDto> {

    private final ModelMapper modelMapper;

    public LevelMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LevelDto mapTo(final LevelEntity LevelEntity) {
        return modelMapper.map(LevelEntity, LevelDto.class);
    }

    @Override
    public LevelEntity mapFrom(final LevelDto LevelDto) {
        return modelMapper.map(LevelDto, LevelEntity.class);
    }
    
}
