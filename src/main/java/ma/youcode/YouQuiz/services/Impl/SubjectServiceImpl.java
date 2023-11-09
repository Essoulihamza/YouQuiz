package ma.youcode.YouQuiz.services.Impl;

import java.util.List;
import java.util.Optional;
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
    public SubjectDto update(Long id, SubjectDto subjectDtoToUpdate) {
        subjectDtoToUpdate.setId(id);
        return save(subjectDtoToUpdate);
    }

    @Override
    public void delete(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }

    @Override
    public SubjectDto find(Long subjectId) {
        var optionalSubject = subjectRepository.findById(subjectId);
        return optionalSubject.isPresent() ?
            subjectMapper.mapTo(optionalSubject.get())
        :
            null;
    }

    @Override
    public boolean isExist(Long subjectId) {
        return subjectRepository.existsById(subjectId);        
    }

    @Override
    public void deleteAll() {
        subjectRepository.deleteAll();
    }

    @Override
    public SubjectDto partialUpdate(Long id, SubjectDto subjectDto) {
        subjectDto.setId(id);
        var subjectEntity = subjectMapper.mapFrom(subjectDto);
        return subjectRepository.findById(id).map(foundedSubject -> {
            Optional.ofNullable(subjectEntity.getTitle()).ifPresent(foundedSubject::setTitle);
            Optional.ofNullable(subjectEntity.getParentSubject()).ifPresent(foundedSubject::setParentSubject);
            Optional.ofNullable(subjectEntity.getChildrenSubjects()).ifPresent(foundedSubject::setChildrenSubjects);
            return subjectMapper.mapTo(subjectRepository.save(foundedSubject));
        }).orElseThrow(() -> new RuntimeException("subject is not found"));
    }

}
