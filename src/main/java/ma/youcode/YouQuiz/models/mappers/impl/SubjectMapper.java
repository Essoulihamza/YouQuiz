package ma.youcode.YouQuiz.models.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ma.youcode.YouQuiz.models.dto.SubjectDto;
import ma.youcode.YouQuiz.models.entities.SubjectEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;

@Component
public class SubjectMapper implements Mapper<SubjectEntity, SubjectDto> {
    
    private final ModelMapper modelMapper;

    public SubjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SubjectDto mapTo(SubjectEntity SubjectEntity) {
        return modelMapper.map(SubjectEntity, SubjectDto.class);
    }

    @Override
    public SubjectEntity mapFrom(SubjectDto SubjectDto) {
        return modelMapper.map(SubjectDto, SubjectEntity.class);
    }
}
