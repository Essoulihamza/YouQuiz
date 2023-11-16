package ma.youcode.YouQuiz.models.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.youcode.YouQuiz.models.dto.QuizDto;
import ma.youcode.YouQuiz.models.entities.QuizEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;

@Component
public class QuizMapper implements Mapper<QuizEntity, QuizDto> {

    private final ModelMapper modelMapper;

    public QuizMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public QuizDto mapTo(QuizEntity entity) {
        return modelMapper.map(entity, QuizDto.class);
    }

    @Override
    public QuizEntity mapFrom(QuizDto dto) {
        return modelMapper.map(dto, QuizEntity.class);
    }

}
