package ma.youcode.YouQuiz.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.models.dto.SubjectDto;
import ma.youcode.YouQuiz.models.entities.SubjectEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;
import ma.youcode.YouQuiz.repositories.SubjectRepository;
import ma.youcode.YouQuiz.services.SubjectService;

@AllArgsConstructor

@Service
public class SubjectServiceImpl implements SubjectService  {

    private final SubjectRepository subjectRepository;
    private final Mapper<SubjectEntity, SubjectDto> subjectMapper;

    

    @Override
    public SubjectDto save(SubjectDto subjectDto) {
        var newSubjectEntity = subjectMapper.mapFrom(subjectDto);
        var createdSubjectDto = subjectMapper.mapTo(subjectRepository.save(newSubjectEntity));
        return createdSubjectDto;
    }

    @Override
    public List<SubjectDto> getAll() {
        var subjects = subjectRepository.findAll();
        return subjects.stream().map(subjectMapper::mapTo).collect(Collectors.toList());
    }

    @Override
    public SubjectDto update(SubjectDto subjectDtoToUpdate) {
        return save(subjectDtoToUpdate);
    }

    @Override
    public void delete(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }

    @Override
    public SubjectDto find(Long subjectId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public boolean isExist(Long subjectId) {
        return subjectRepository.existsById(subjectId);        
    }

    @Override
    public void deleteAll() {
        subjectRepository.deleteAll();
    }

}
