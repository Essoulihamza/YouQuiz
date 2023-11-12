package ma.youcode.YouQuiz.models.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.youcode.YouQuiz.models.dto.MediaDto;
import ma.youcode.YouQuiz.models.entities.MediaEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;

@Component
public class MediaMapper implements Mapper<MediaEntity, MediaDto> {
    
    private final ModelMapper modelMapper;

    public MediaMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MediaDto mapTo(final MediaEntity MediaEntity) {
        return modelMapper.map(MediaEntity, MediaDto.class);
    }

    @Override
    public MediaEntity mapFrom(final MediaDto MediaDto) {
        return modelMapper.map(MediaDto, MediaEntity.class);
    }
}
