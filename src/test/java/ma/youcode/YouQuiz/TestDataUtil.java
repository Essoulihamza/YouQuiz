package ma.youcode.YouQuiz;

import ma.youcode.YouQuiz.models.dto.LevelDto;
import ma.youcode.YouQuiz.models.dto.QuestionDto;
import ma.youcode.YouQuiz.models.dto.SubjectDto;
import ma.youcode.YouQuiz.models.entities.LevelEntity;
import ma.youcode.YouQuiz.models.entities.QuestionEntity;
import ma.youcode.YouQuiz.models.entities.SubjectEntity;
import ma.youcode.YouQuiz.models.enums.QuestionType;

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

    public static LevelEntity getTestLevelEntity() {
        return LevelEntity.builder()
                          .id(1)
                          .name("level")
                          .description("description")
                          .maxPoint(10D)
                          .minPoint(2D)
                          .build();
    }

    public static LevelDto getTestLevelDto() {
        return LevelDto.builder()
                          .id(1)
                          .name("level")
                          .description("description")
                          .maxPoint(10D)
                          .minPoint(2D)
                          .build();
    }

    public static QuestionDto getTestQuestionDto() {
        return QuestionDto.builder()
                          .content("question ?")
                          .questionType(QuestionType.MULTIPLE_ANSWER)
                          .build();
    }

    public static QuestionEntity getTestQuestionEntity() {
        return QuestionEntity.builder()
                             .content("question ?")
                             .questionType(QuestionType.MULTIPLE_ANSWER)
                             .build();
    }

}
