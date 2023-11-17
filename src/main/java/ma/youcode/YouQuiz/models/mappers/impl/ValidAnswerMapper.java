package ma.youcode.YouQuiz.models.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.youcode.YouQuiz.models.dto.ValidAnswerDto;
import ma.youcode.YouQuiz.models.entities.ValidAnswerEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;

@Component
public class ValidAnswerMapper implements Mapper<ValidAnswerEntity, ValidAnswerDto> {
    
    private final ModelMapper modelMapper;

    public ValidAnswerMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ValidAnswerDto mapTo(final ValidAnswerEntity QuestionAnswerEntity) {
        return modelMapper.map(QuestionAnswerEntity, ValidAnswerDto.class);
    }

    @Override
    public ValidAnswerEntity mapFrom(final ValidAnswerDto QuestionAnswerDto) {
        return modelMapper.map(QuestionAnswerDto, ValidAnswerEntity.class);
    }

}
