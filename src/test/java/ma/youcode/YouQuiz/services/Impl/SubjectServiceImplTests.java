package ma.youcode.YouQuiz.services.Impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ma.youcode.YouQuiz.TestDataUtil;
import ma.youcode.YouQuiz.models.dto.SubjectDto;
import ma.youcode.YouQuiz.models.entities.SubjectEntity;
import ma.youcode.YouQuiz.models.mappers.impl.SubjectMapper;
import ma.youcode.YouQuiz.repositories.SubjectRepository;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceImplTests {

    @Mock
    private SubjectRepository subjectRepositoryMock;

    @Mock
    private SubjectMapper subjectMapperMock;

    @InjectMocks
    private SubjectServiceImpl underTest;

    @Test
    void createSubjectReturnsTheCreatedSubjectDto() {
        
        // Arrange 
        // ---Dummy
        var subjectDto = TestDataUtil.createTestSubjectDto();
        var subjectEntity = TestDataUtil.createTestSubjectEntity();
        var subjectDtoWithId = TestDataUtil.createTestSubjectDtoWithId();
        var subjectEntityWithId = TestDataUtil.createTestSubjectEntityWithId();
        // ---Stub
        when(subjectMapperMock.mapFrom(subjectDto)).thenReturn(subjectEntity);
        when(subjectRepositoryMock.save(subjectEntity)).thenReturn(subjectEntityWithId);
        when(subjectMapperMock.mapTo(subjectEntityWithId)).thenReturn(subjectDtoWithId);

        // act 
        var result = underTest.save(subjectDto);

        // Assert
        assertThat(result).isEqualTo(subjectDtoWithId);

        // ---Verify
        verify(subjectMapperMock).mapFrom(subjectDto);
        verify(subjectRepositoryMock).save(subjectEntity);
        verify(subjectMapperMock).mapTo(subjectEntityWithId);
    }

    @Test
    void readMethodReturnsTheSubjectsList() {
        
        // Arrange 
        // ---Dummy
        var subjectDtoWithId = TestDataUtil.createTestSubjectDtoWithId();
        var subjectEntityWithId = TestDataUtil.createTestSubjectEntityWithId();
        var subjectEntityList = new ArrayList<SubjectEntity>();
        subjectEntityList.add(subjectEntityWithId);
        subjectEntityList.add(subjectEntityWithId);
        var subjectDtoList = new ArrayList<SubjectDto>();
        subjectDtoList.add(subjectDtoWithId);
        subjectDtoList.add(subjectDtoWithId);

        // ---Stub
        when(subjectRepositoryMock.findAll()).thenReturn(subjectEntityList);
        when(subjectMapperMock.mapTo(any(SubjectEntity.class))).thenReturn(subjectDtoWithId);

        // act 
        List<SubjectDto> result = underTest.getAll();

        // Assert
        assertThat(result).isEqualTo(subjectDtoList);

        // ---Verify
        verify(subjectRepositoryMock).findAll();
        verify(subjectMapperMock, times(2)).mapTo(any(SubjectEntity.class));

    }

    @Test
    void updateMethodReturnsTheUpdatedSubject() {

        // Arrange
        // ---Dummy
        var subjectDtoWithId = TestDataUtil.createTestSubjectDtoWithId();
        var subjectEntityWithId = TestDataUtil.createTestSubjectEntityWithId();
        // ---Stub
        when(subjectMapperMock.mapFrom(subjectDtoWithId)).thenReturn(subjectEntityWithId);
        when(subjectRepositoryMock.save(subjectEntityWithId)).thenReturn(subjectEntityWithId);
        when(subjectMapperMock.mapTo(subjectEntityWithId)).thenReturn(subjectDtoWithId);
        
        // Act
        var result = underTest.update(subjectDtoWithId.getId() ,subjectDtoWithId);

        // Assert
        assertThat(result).isEqualTo(subjectDtoWithId);

        // ---Verify
        verify(subjectMapperMock).mapFrom(subjectDtoWithId);
        verify(subjectRepositoryMock).save(subjectEntityWithId);
        verify(subjectMapperMock).mapTo(subjectEntityWithId);

    }


    @Test
    void findMethodReturnsNullWhenTheSubjectIsNotExist() {

        // Arrange
        // ---stub
        when(subjectRepositoryMock.findById(99L)).thenReturn(Optional.empty());

        // Act
        var result = underTest.find(99L);
        // Assert
        assertThat(result).isNull();

        // ---verify
        verify(subjectRepositoryMock).findById(99L);
    }

    @Test
    void findMethodReturnsTheFoundedSubjectDto() {

        // Arrange
        // ---dummy
        var subjectEntity = TestDataUtil.createTestSubjectEntityWithId();
        var subjectDto = TestDataUtil.createTestSubjectDtoWithId();
        // ---stub
        when(subjectRepositoryMock.findById(1L)).thenReturn(Optional.of(subjectEntity));
        when(subjectMapperMock.mapTo(subjectEntity)).thenReturn(subjectDto);

        // Act
        var result = underTest.find(1L);

        // Assert
        assertThat(result).isEqualTo(subjectDto);

        // ---verify
        verify(subjectMapperMock).mapTo(subjectEntity);
    }

    @Test
    void partialUpdateMethodReturnsTheUpdatedSubject() {
        // Arrange
        // ---dummy
        var subjectDtoWithId = TestDataUtil.createTestSubjectDtoWithId();
        var subjectEntityWithId = TestDataUtil.createTestSubjectEntityWithId();

        // ---Stub
        when(subjectMapperMock.mapFrom(subjectDtoWithId)).thenReturn(subjectEntityWithId);
        when(subjectRepositoryMock.findById(1L)).thenReturn(Optional.of(subjectEntityWithId));
        when(subjectRepositoryMock.save(subjectEntityWithId)).thenReturn(subjectEntityWithId);
        when(subjectMapperMock.mapTo(subjectEntityWithId)).thenReturn(subjectDtoWithId);

        // Act
        var result = underTest.partialUpdate(1L, subjectDtoWithId);

        // Assert
        assertThat(result).isEqualTo(subjectDtoWithId);

        // ---verify
        verify(subjectMapperMock).mapFrom(subjectDtoWithId);
        verify(subjectRepositoryMock).findById(1L);
        verify(subjectRepositoryMock).save(subjectEntityWithId);
        verify(subjectMapperMock).mapTo(subjectEntityWithId);
    }


}
