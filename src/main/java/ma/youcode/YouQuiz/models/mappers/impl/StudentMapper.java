package ma.youcode.YouQuiz.models.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.youcode.YouQuiz.models.dto.StudentDto;
import ma.youcode.YouQuiz.models.entities.StudentEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;

@Component
public class StudentMapper implements Mapper<StudentEntity, StudentDto> {
    
    private final ModelMapper modelMapper;

    public StudentMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDto mapTo(StudentEntity entity) {
        return modelMapper.map(entity, StudentDto.class);
    }

    @Override
    public StudentEntity mapFrom(StudentDto dto) {
        return modelMapper.map(dto, StudentEntity.class);
    }
}
