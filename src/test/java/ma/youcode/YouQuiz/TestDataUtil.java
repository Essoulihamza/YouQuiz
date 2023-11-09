package ma.youcode.YouQuiz;

import ma.youcode.YouQuiz.models.dto.SubjectDto;
import ma.youcode.YouQuiz.models.entities.SubjectEntity;

public final class TestDataUtil {
    
    private TestDataUtil(){}

    public static SubjectDto createTestSubjectDto() {
        return SubjectDto.builder()
                        .title("subject title")
                        .build();
    }

    public static SubjectDto createTestSubjectDtoWithId() {
        return SubjectDto.builder()
                        .id(1L)
                        .title("this is title")
                        .build();                    
    }

    public static SubjectDto createTestSubjectDtoWithParentSubject() {
        return SubjectDto.builder()
                         .id(2L)
                         .title("this is title")
                         .parentSubject(createTestSubjectDto())
                         .build();
    }

    public static SubjectEntity createTestSubjectEntity() {
        return SubjectEntity.builder()
                            .title("this is title")
                            .build();
    }

    public static SubjectEntity createTestSubjectEntityWithId() {
        return SubjectEntity.builder()
                            .id(1L)
                            .title("this is title")
                            .build();
    }


}
