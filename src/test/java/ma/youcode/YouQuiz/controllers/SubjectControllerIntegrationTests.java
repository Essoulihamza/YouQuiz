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

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class SubjectControllerIntegrationTests {
    
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Autowired
    public SubjectControllerIntegrationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
        objectMapper = new ObjectMapper();
    }

    @Test
    void createSubjectSuccessfullyReturnsHttp201Created() throws Exception {
        var subjectDto = TestDataUtil.createTestSubjectDto();
        var subjectJson = objectMapper.writeValueAsString(subjectDto);

        mockMvc.perform(
            MockMvcRequestBuilders.post("/subjects")
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(subjectJson)
        ).andExpect(
            MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    void createSubjectSuccessfullyReturnsTheCreatedSubject() throws Exception {
        var subjectDto = TestDataUtil.createTestSubjectDto();
        var subjectJson = objectMapper.writeValueAsString(subjectDto);

        mockMvc.perform(
            MockMvcRequestBuilders.post("/subjects")
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(subjectJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.title").value(subjectDto.getTitle())
        );
    }

    @Test
    void getAllMethodReturnsHttp200Ok() throws Exception {
        
        mockMvc.perform(
            MockMvcRequestBuilders.get("/subjects")
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
            MockMvcResultMatchers.status().isOk()
        );
    }
}
