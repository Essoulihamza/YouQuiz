package ma.youcode.YouQuiz.services.Impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ma.youcode.YouQuiz.TestDataUtil;
import ma.youcode.YouQuiz.models.dto.LevelDto;
import ma.youcode.YouQuiz.models.entities.LevelEntity;
import ma.youcode.YouQuiz.models.mappers.Mapper;
import ma.youcode.YouQuiz.repositories.LevelRepository;

@ExtendWith(MockitoExtension.class)
public class LevelServiceImplTests {
    
    @Mock private Mapper<LevelEntity, LevelDto> mapper;

    @Mock private LevelRepository repository;

    @InjectMocks
    private LevelServiceImpl underTest;

    @Test
    void saveMethodReturnsTheSavedEntity() {
        var levelDto = TestDataUtil.getTestLevelDto();
        var levelEntity = TestDataUtil.getTestLevelEntity();
        
        when(mapper.mapFrom(levelDto)).thenReturn(levelEntity);
        when(repository.save(levelEntity)).thenReturn(levelEntity);
        when(mapper.mapTo(levelEntity)).thenReturn(levelDto);

        var result = underTest.save(levelDto);

        assertThat(result).isEqualTo(levelDto);

        verify(mapper).mapFrom(levelDto);
        verify(repository).save(levelEntity);
        verify(mapper).mapTo(levelEntity);
    }

    @Test
    void getAllMethodReturnsLevelsList() {
        
        var levelDto = TestDataUtil.getTestLevelDto();
        var levelEntity = TestDataUtil.getTestLevelEntity();
        var levelDtoList = new ArrayList<LevelDto>();
        var levelEntityList = new ArrayList<LevelEntity>();
        levelDtoList.add(levelDto);
        levelDtoList.add(levelDto);
        levelEntityList.add(levelEntity);
        levelEntityList.add(levelEntity);

        when(repository.findAll()).thenReturn(levelEntityList);
        when(mapper.mapTo(levelEntity)).thenReturn(levelDto);

        var result = underTest.getAll();

        assertThat(result).isEqualTo(levelDtoList);

        verify(repository).findAll();
        verify(mapper, times(levelEntityList.size())).mapTo(any(LevelEntity.class));
    }

    @Test
    void updateMethodReturnsTheUpdatedLevel() {
        this.saveMethodReturnsTheSavedEntity();
    }

    @Test
    void findMethodReturnsNullWhenLevelIsNotExist() {
        
        when(repository.findById(99)).thenReturn(Optional.empty());

        var result = underTest.find(99);

        assertThat(result).isNull();

        verify(repository).findById(99);
    }

    @Test 
    void findMethodReturnsTheFoundedLevelWhenItIsExist() {

        var levelDto = TestDataUtil.getTestLevelDto();
        var levelEntity = TestDataUtil.getTestLevelEntity();
        levelDto.setId(1);
        levelEntity.setId(1);

        when(repository.findById(levelDto.getId())).thenReturn(Optional.of(levelEntity));
        when(mapper.mapTo(levelEntity)).thenReturn(levelDto);

        var result = underTest.find(1);

        assertThat(result).isEqualTo(levelDto);

        verify(repository).findById(1);
        verify(mapper).mapTo(levelEntity);
    }

    @Test
    void partialUpdateMethodReturnsTheUpdatedLevel() {
        var levelDto = TestDataUtil.getTestLevelDto();
        var levelEntity = TestDataUtil.getTestLevelEntity();
        levelDto.setId(1);
        levelEntity.setId(1);

        when(repository.findById(1)).thenReturn(Optional.of(levelEntity));
        when(repository.save(levelEntity)).thenReturn(levelEntity);
        when(mapper.mapTo(levelEntity)).thenReturn(levelDto);

        var result = underTest.partialUpdate(1, levelDto);

        assertThat(result).isEqualTo(levelDto);

        verify(repository).findById(1);
        verify(repository).save(levelEntity);
        verify(mapper).mapTo(levelEntity);
    }
}
