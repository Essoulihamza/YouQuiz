package ma.youcode.YouQuiz.models.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.youcode.YouQuiz.models.dto.TrainerDto;
import ma.youcode.YouQuiz.models.entities.TrainerEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;

@Component
public class TrainerMapper implements Mapper<TrainerEntity, TrainerDto> {

    private final ModelMapper modelMapper;

    public TrainerMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    
    @Override
    public TrainerDto mapTo(TrainerEntity entity) {
        return modelMapper.map(entity, TrainerDto.class);
    }

    @Override
    public TrainerEntity mapFrom(TrainerDto dto) {
        return modelMapper.map(dto, TrainerEntity.class);
    }
    
}
