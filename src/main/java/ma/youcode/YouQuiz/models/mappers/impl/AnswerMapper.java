package ma.youcode.YouQuiz.models.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.youcode.YouQuiz.models.dto.AnswerDto;
import ma.youcode.YouQuiz.models.entities.AnswerEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;

@Component
public class AnswerMapper implements Mapper<AnswerEntity, AnswerDto> {

    private final ModelMapper modelMapper;

    public AnswerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AnswerDto mapTo(AnswerEntity answerEntity) {
        return modelMapper.map(answerEntity, AnswerDto.class);
    }

    @Override
    public AnswerEntity mapFrom(AnswerDto answerDto) {
        return modelMapper.map(answerDto, AnswerEntity.class);
    }
    
}
