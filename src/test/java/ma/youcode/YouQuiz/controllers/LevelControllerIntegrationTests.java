package ma.youcode.YouQuiz.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import ma.youcode.YouQuiz.TestDataUtil;
import ma.youcode.YouQuiz.services.LevelService;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class LevelControllerIntegrationTests {
    
    private final String END_PONT = "/levels";
    private MockMvc mockMvc;
    private LevelService levelService;

    private ObjectMapper objectMapper;

    @Autowired
    public LevelControllerIntegrationTests(MockMvc mockMvc, LevelService levelService) {
        this.mockMvc = mockMvc;
        this.levelService = levelService;
        objectMapper = new ObjectMapper();
    }

    @Test
    void createMethodSuccessfullyReturns201Created() throws Exception {
        var levelDto = TestDataUtil.getTestLevelDto();
        var levelDtoJson = objectMapper.writeValueAsString(levelDto);

        mockMvc.perform(
            MockMvcRequestBuilders.post(END_PONT)
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(levelDtoJson))
                                  .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void createMethodSuccessfullyReturnsTheCreatedLevel() throws Exception {
        var levelDto = TestDataUtil.getTestLevelDto();
        var levelDtoJson = objectMapper.writeValueAsString(levelDto);

        mockMvc.perform(
            MockMvcRequestBuilders.post(END_PONT)
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(levelDtoJson)
        )
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(levelDto.getName()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(levelDto.getDescription()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.maxPoint").value(levelDto.getMaxPoint()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.minPoint").value(levelDto.getMinPoint()));
    }

    @Test
    void getAllMethodReturns200Ok() throws Exception {

        mockMvc.perform(
            MockMvcRequestBuilders.get(END_PONT)
                                  .contentType(MediaType.APPLICATION_JSON))
                                  .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateMethodReturnsHttp404NotFoundWhenTheLevelIsNotExist() throws Exception {

        var levelDto = TestDataUtil.getTestLevelDto();
        var levelJson = objectMapper.writeValueAsString(levelDto);
        mockMvc.perform(
            MockMvcRequestBuilders.put(END_PONT + "/99")
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(levelJson)
        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void updateMethodReturnsHttp200OKWhenTheLevelIsExist() throws Exception {

        var levelDto = TestDataUtil.getTestLevelDto();
        var levelJson = objectMapper.writeValueAsString(levelDto);
        var savedLevel = levelService.save(levelDto);
        mockMvc.perform(
            MockMvcRequestBuilders.put(END_PONT + '/' + savedLevel.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(levelJson)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateMethodReturnsTheUpdatedLevel() throws Exception {

        var levelDto = TestDataUtil.getTestLevelDto();
        var levelJson = objectMapper.writeValueAsString(levelDto);
        var savedLevel = levelService.save(levelDto);
        mockMvc.perform(
            MockMvcRequestBuilders.put(END_PONT + '/' + savedLevel.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(levelJson))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(savedLevel.getId()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(savedLevel.getName()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(savedLevel.getDescription()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.maxPoint").value(savedLevel.getMaxPoint()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.minPoint").value(savedLevel.getMinPoint()));
    }

    @Test
    void deleteMethodReturnsHttp204WhenLevelIsNotExist() throws Exception {

        mockMvc.perform(
            MockMvcRequestBuilders.delete(END_PONT + "/99")
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deleteMethodReturnsHttp204WhenLevelIsExist() throws Exception {
        var levelDto = TestDataUtil.getTestLevelDto();
        var savedLevel = levelService.save(levelDto);

        mockMvc.perform(
            MockMvcRequestBuilders.delete(END_PONT + '/' + savedLevel.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deleteAllMethodReturnsHttp204WhenNoLevelIsExist() throws Exception {

        mockMvc.perform(
            MockMvcRequestBuilders.delete(END_PONT)
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deleteAllMethodReturnsHttp204WhenLevelsIsExist() throws Exception {
        var levelDto = TestDataUtil.getTestLevelDto();
        levelService.save(levelDto);
        
        mockMvc.perform(
            MockMvcRequestBuilders.delete(END_PONT)
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void findMethodReturnsHttp404NotFoundWhenLevelIsNotExist() throws Exception {

        mockMvc.perform(
            MockMvcRequestBuilders.get(END_PONT + '/' + 99)
                                  .contentType(MediaType.APPLICATION_JSON))
                                  .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void findMethodReturnsHttp200OkWhenLevelIsExist() throws Exception {

        var levelDto = TestDataUtil.getTestLevelDto();
        var savedLevel = levelService.save(levelDto);

        mockMvc.perform(
            MockMvcRequestBuilders.get(END_PONT + '/' + savedLevel.getId())
                                  .contentType(MediaType.APPLICATION_JSON))
                                  .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findMethodReturnsTheFoundedLevelWhenExist() throws Exception {

        var levelDto = TestDataUtil.getTestLevelDto();
        var savedLevel = levelService.save(levelDto);

        mockMvc.perform(
            MockMvcRequestBuilders.get(END_PONT + '/' + savedLevel.getId())
                                  .contentType(MediaType.APPLICATION_JSON))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(savedLevel.getId()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(savedLevel.getName()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(savedLevel.getDescription()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.maxPoint").value(savedLevel.getMaxPoint()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.minPoint").value(savedLevel.getMinPoint()));
    }

    @Test
    void partialUpdateReturns404NotFoundWhenTheLevelIsNotExist() throws Exception {

        var levelJson = objectMapper.writeValueAsString(TestDataUtil.getTestLevelDto());
        mockMvc.perform(
            MockMvcRequestBuilders.patch(END_PONT + '/' + 99)
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(levelJson))
                                  .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void partialUpdateMethodReturns200OkWithTheUpdatedLeveltWhenItIsExist() throws Exception {

        var levelDto = TestDataUtil.getTestLevelDto();
        var savedLevel = levelService.save(levelDto);
        var levelJson = objectMapper.writeValueAsString(savedLevel);
        mockMvc.perform(
            MockMvcRequestBuilders.patch(END_PONT + '/' + savedLevel.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(levelJson))
                                  .andExpect(MockMvcResultMatchers.status().isOk())
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(savedLevel.getId()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(savedLevel.getName()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(savedLevel.getDescription()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.maxPoint").value(savedLevel.getMaxPoint()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.minPoint").value(savedLevel.getMinPoint()));
    }
}
