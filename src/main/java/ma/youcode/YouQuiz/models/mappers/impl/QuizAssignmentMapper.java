package ma.youcode.YouQuiz.models.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.youcode.YouQuiz.models.dto.QuizAssignmentDto;
import ma.youcode.YouQuiz.models.entities.QuizAssignmentEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;

@Component
public class QuizAssignmentMapper implements Mapper<QuizAssignmentEntity, QuizAssignmentDto> {
    
    private final ModelMapper modelMapper;

    public QuizAssignmentMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public QuizAssignmentDto mapTo(final QuizAssignmentEntity quizAssignmentEntity) {
        return modelMapper.map(quizAssignmentEntity, QuizAssignmentDto.class);
    }

    @Override
    public QuizAssignmentEntity mapFrom(final QuizAssignmentDto quizAssignmentDto) {
        return modelMapper.map(quizAssignmentDto, QuizAssignmentEntity.class);
    }
}
