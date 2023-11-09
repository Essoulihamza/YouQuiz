package ma.youcode.YouQuiz.services.Impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ma.youcode.YouQuiz.TestDataUtil;
import ma.youcode.YouQuiz.models.dto.QuestionDto;
import ma.youcode.YouQuiz.models.entities.QuestionEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;
import ma.youcode.YouQuiz.repositories.QuestionRepository;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceImplTests {
    
    @Mock private Mapper<QuestionEntity, QuestionDto> mapper;
    @Mock private QuestionRepository repository;

    @InjectMocks
    private QuestionServiceImpl underTest;

    @Test
    void saveMethodReturnsTheSavedEntity() {
        var questionDto = TestDataUtil.getTestQuestionDto();
        var questionEntity = TestDataUtil.getTestQuestionEntity();
        
        when(mapper.mapFrom(questionDto)).thenReturn(questionEntity);
        when(repository.save(questionEntity)).thenReturn(questionEntity);
        when(mapper.mapTo(questionEntity)).thenReturn(questionDto);

        var result = underTest.save(questionDto);

        assertThat(result).isEqualTo(questionDto);

        verify(mapper).mapFrom(questionDto);
        verify(repository).save(questionEntity);
        verify(mapper).mapTo(questionEntity);
    }

    @Test
    void getAllMethodReturnsLevelsList() {
        
        var questionDto = TestDataUtil.getTestQuestionDto();
        var questionEntity = TestDataUtil.getTestQuestionEntity();
        var questionDtoList = new ArrayList<QuestionDto>();
        var questionEntityList = new ArrayList<QuestionEntity>();
        questionDtoList.add(questionDto);
        questionDtoList.add(questionDto);
        questionEntityList.add(questionEntity);
        questionEntityList.add(questionEntity);

        when(repository.findAll()).thenReturn(questionEntityList);
        when(mapper.mapTo(questionEntity)).thenReturn(questionDto);

        var result = underTest.getAll();

        assertThat(result).isEqualTo(questionDtoList);

        verify(repository).findAll();
        verify(mapper, times(questionEntityList.size())).mapTo(any(QuestionEntity.class));
    }

}
