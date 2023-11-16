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
import ma.youcode.YouQuiz.services.interfaces.QuestionService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class QuestionControllerIntegrationTests {
    
    private final String END_PONT = "/questions";
    private MockMvc mockMvc;
    private QuestionService questionService;
    private ObjectMapper objectMapper;

    @Autowired
    public QuestionControllerIntegrationTests(MockMvc mockMvc, ObjectMapper objectMapper, QuestionService questionService) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
        this.questionService = questionService;
    }

    @Test
    void createMethodSuccessfullyReturns201Created() throws Exception {
        var questionDto = TestDataUtil.getTestQuestionDto();
        var questionDtoJson = objectMapper.writeValueAsString(questionDto);

        mockMvc.perform(
            MockMvcRequestBuilders.post(END_PONT)
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(questionDtoJson))
                                  .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void createMethodSuccessfullyReturnsTheCreatedQuestoni() throws Exception {
        var questionDto = TestDataUtil.getTestQuestionDto();
        var questionDtoJson = objectMapper.writeValueAsString(questionDto);

        mockMvc.perform(
            MockMvcRequestBuilders.post(END_PONT)
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(questionDtoJson))
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
        .andExpect(MockMvcResultMatchers.jsonPath("$.content").value(questionDto.getContent()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.questionType").value(questionDto.getQuestionType().name()));
    }

    @Test
    void getAllMethodReturns200Ok() throws Exception {

        mockMvc.perform(
            MockMvcRequestBuilders.get(END_PONT)
                                  .contentType(MediaType.APPLICATION_JSON))
                                  .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void updateMethodReturnsHttp404NotFoundWhenTheQuestoinIsNotExist() throws Exception {

        var questionDto = TestDataUtil.getTestQuestionDto();
        var questionDtoJson = objectMapper.writeValueAsString(questionDto);
        mockMvc.perform(
            MockMvcRequestBuilders.put(END_PONT + "/99")
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(questionDtoJson)
        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void updateMethodReturnsHttp200OKWhenTheQuestionIsExist() throws Exception {

        var questionDto = TestDataUtil.getTestQuestionDto();
        var questionJson = objectMapper.writeValueAsString(questionDto);
        var savedQuestion = questionService.save(questionDto);
        mockMvc.perform(
            MockMvcRequestBuilders.put(END_PONT + '/' + savedQuestion.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(questionJson)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateMethodReturnsTheUpdatedQuestion() throws Exception {

        var questionDto = TestDataUtil.getTestQuestionDto();
        var questionJson = objectMapper.writeValueAsString(questionDto);
        var savedQuestion = questionService.save(questionDto);
        mockMvc.perform(
            MockMvcRequestBuilders.put(END_PONT + '/' + savedQuestion.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(questionJson))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.content").value(questionDto.getContent()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.questionType").value(questionDto.getQuestionType().name()));
    }

    @Test
    void deleteMethodReturnsHttp204WhenQuestionIsNotExist() throws Exception {

        mockMvc.perform(
            MockMvcRequestBuilders.delete(END_PONT + "/99")
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deleteMethodReturnsHttp204WhenQuestionIsExist() throws Exception {
        var questionDto = TestDataUtil.getTestQuestionDto();
        var savedQuestion = questionService.save(questionDto);

        mockMvc.perform(
            MockMvcRequestBuilders.delete(END_PONT + '/' + savedQuestion.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deleteAllMethodReturnsHttp204WhenNoQuestionIsExist() throws Exception {

        mockMvc.perform(
            MockMvcRequestBuilders.delete(END_PONT)
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deleteAllMethodReturnsHttp204WhenLevelsIsExist() throws Exception {
        var questionDto = TestDataUtil.getTestQuestionDto();
        questionService.save(questionDto);
        
        mockMvc.perform(
            MockMvcRequestBuilders.delete(END_PONT)
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void findMethodReturnsHttp404NotFoundWhenQuestionIsNotExist() throws Exception {

        mockMvc.perform(
            MockMvcRequestBuilders.get(END_PONT + '/' + 99)
                                  .contentType(MediaType.APPLICATION_JSON))
                                  .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void findMethodReturnsHttp200OkWhenQuestionIsExist() throws Exception {

        var questionDto = TestDataUtil.getTestQuestionDto();
        var savedQuestion = questionService.save(questionDto);

        mockMvc.perform(
            MockMvcRequestBuilders.get(END_PONT + '/' + savedQuestion.getId())
                                  .contentType(MediaType.APPLICATION_JSON))
                                  .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findMethodReturnsTheFoundedQuestionWhenExist() throws Exception {

        var questionDto = TestDataUtil.getTestQuestionDto();
        var savedQuestion = questionService.save(questionDto);

        mockMvc.perform(
            MockMvcRequestBuilders.get(END_PONT + '/' + savedQuestion.getId())
                                  .contentType(MediaType.APPLICATION_JSON))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(savedQuestion.getId()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.content").value(questionDto.getContent()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.questionType").value(questionDto.getQuestionType().name()));
    }

    @Test
    void partialUpdateReturns404NotFoundWhenTheQuestionIsNotExist() throws Exception {

        var questionJson = objectMapper.writeValueAsString(TestDataUtil.getTestQuestionDto());
        mockMvc.perform(
            MockMvcRequestBuilders.patch(END_PONT + '/' + 99)
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(questionJson))
                                  .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void partialUpdateMethodReturns200OkWithTheUpdatedLeveltWhenItIsExist() throws Exception {

        var questionDto = TestDataUtil.getTestQuestionDto();
        var savedQuestion = questionService.save(questionDto);
        var questionJson = objectMapper.writeValueAsString(savedQuestion);
        mockMvc.perform(
            MockMvcRequestBuilders.patch(END_PONT + '/' + savedQuestion.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(questionJson))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(savedQuestion.getId()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.content").value(questionDto.getContent()))
                                  .andExpect(MockMvcResultMatchers.jsonPath("$.questionType").value(questionDto.getQuestionType().name()));;
    }
}
