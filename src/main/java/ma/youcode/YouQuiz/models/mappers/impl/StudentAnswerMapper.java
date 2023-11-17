package ma.youcode.YouQuiz.models.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.youcode.YouQuiz.models.dto.associatives.StudentAnswerDto;
import ma.youcode.YouQuiz.models.entities.associatives.StudentAnswerEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;

@Component
public class StudentAnswerMapper implements Mapper<StudentAnswerEntity, StudentAnswerDto> {
    
    private final ModelMapper modelMapper;

    public StudentAnswerMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentAnswerDto mapTo(final StudentAnswerEntity studentAnswerEntity) {
        return modelMapper.map(studentAnswerEntity, StudentAnswerDto.class);
    }

    @Override
    public StudentAnswerEntity mapFrom(final StudentAnswerDto studentAnswerDto) {
        return modelMapper.map(studentAnswerDto, StudentAnswerEntity.class);
    }
}
