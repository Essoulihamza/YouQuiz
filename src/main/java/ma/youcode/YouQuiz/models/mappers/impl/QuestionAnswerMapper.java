package ma.youcode.YouQuiz.models.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.youcode.YouQuiz.models.dto.QuestionAnswerDto;
import ma.youcode.YouQuiz.models.entities.QuestionAnswerEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;

@Component
public class QuestionAnswerMapper implements Mapper<QuestionAnswerEntity, QuestionAnswerDto> {
    
    private final ModelMapper modelMapper;

    public QuestionAnswerMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public QuestionAnswerDto mapTo(final QuestionAnswerEntity QuestionAnswerEntity) {
        return modelMapper.map(QuestionAnswerEntity, QuestionAnswerDto.class);
    }

    @Override
    public QuestionAnswerEntity mapFrom(final QuestionAnswerDto QuestionAnswerDto) {
        return modelMapper.map(QuestionAnswerDto, QuestionAnswerEntity.class);
    }

}
