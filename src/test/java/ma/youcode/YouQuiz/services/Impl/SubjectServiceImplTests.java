package ma.youcode.YouQuiz.services.Impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ma.youcode.YouQuiz.TestDataUtil;
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
        var result = underTest.create(subjectDto);

        // Assert
        assertThat(result).isEqualTo(subjectDtoWithId);

        // ---Verify
        verify(subjectMapperMock).mapFrom(subjectDto);
        verify(subjectRepositoryMock).save(subjectEntity);
        verify(subjectMapperMock).mapTo(subjectEntityWithId);
    }


}
