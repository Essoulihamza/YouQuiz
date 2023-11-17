package ma.youcode.YouQuiz.models.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.youcode.YouQuiz.models.dto.associatives.QuestionAssignmentDto;
import ma.youcode.YouQuiz.models.entities.associatives.QuestionAssignmentEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;

@Component
public class QuestionAssignmentMapper implements Mapper<QuestionAssignmentEntity, QuestionAssignmentDto> {

    private final ModelMapper modelMapper;

    public QuestionAssignmentMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public QuestionAssignmentDto mapTo(final QuestionAssignmentEntity questionAssignmentEntity) {
        return modelMapper.map(questionAssignmentEntity, QuestionAssignmentDto.class);
    }

    @Override
    public QuestionAssignmentEntity mapFrom(final QuestionAssignmentDto questionAssignmentDto) {
        return modelMapper.map(questionAssignmentDto, QuestionAssignmentEntity.class);
    }
    
}
