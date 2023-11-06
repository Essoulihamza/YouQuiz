package ma.youcode.YouQuiz.models.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.youcode.YouQuiz.models.dto.QuestionDto;
import ma.youcode.YouQuiz.models.entities.QuestionEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;

@Component
public class QuestionMapper implements Mapper<QuestionEntity, QuestionDto> {

    private final ModelMapper modelMapper;

    public QuestionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public QuestionDto mapTo(QuestionEntity QuestionEntity) {
        return modelMapper.map(QuestionEntity, QuestionDto.class);
    }

    @Override
    public QuestionEntity mapFrom(QuestionDto QuestionDto) {
        return modelMapper.map(QuestionDto, QuestionEntity.class);
    }
    
}
