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
import ma.youcode.YouQuiz.services.QuestionService;

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
    void createMethodSuccessfullyReturnsTheCreatedLevel() throws Exception {
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



}
