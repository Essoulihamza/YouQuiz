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
import ma.youcode.YouQuiz.services.SubjectService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class SubjectControllerIntegrationTests {
    
    private MockMvc mockMvc;
    private SubjectService subjectService;

    private ObjectMapper objectMapper;

    @Autowired
    public SubjectControllerIntegrationTests(MockMvc mockMvc, SubjectService subjectService) {
        this.mockMvc = mockMvc;
        this.subjectService = subjectService;
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

    @Test
    void updateMethodReturnsHttp404NotFoundWhenNoTheSubjectIsNotExist() throws Exception {

        var subjectDto = TestDataUtil.createTestSubjectDto();
        var subjectJson = objectMapper.writeValueAsString(subjectDto);
        mockMvc.perform(
            MockMvcRequestBuilders.put("/subjects/99")
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(subjectJson)
        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void updateMethodReturnsHttp200OkWhenSubjectIsExist() throws Exception {
        var subjectDto = TestDataUtil.createTestSubjectDtoWithId();
        var savedSubject = subjectService.save(subjectDto);
        var subjectJson = objectMapper.writeValueAsString(subjectDto);
        mockMvc.perform(
            MockMvcRequestBuilders.put("/subjects/" + savedSubject.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(subjectJson)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateMethodisUpdatingTheSubjectAndReturnsIt() throws Exception {
        var subjectDto = TestDataUtil.createTestSubjectDtoWithId();
        var savedSubject = subjectService.save(subjectDto);
        var updatedSubject = TestDataUtil.createTestSubjectEntity();
        updatedSubject.setId(savedSubject.getId());
        updatedSubject.setTitle("title");

        var updatedSubjectJson = objectMapper.writeValueAsString(updatedSubject);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/subjects/" + updatedSubject.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(updatedSubjectJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").value(updatedSubject.getId())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.title").value(updatedSubject.getTitle())
        );
    }

    @Test
    void deleteMethodReturnsHttp204WhenSubjectIsNotExist() throws Exception {

        mockMvc.perform(
            MockMvcRequestBuilders.delete("/subjects/99")
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deleteMethodReturnsHttp204WhenSubjectIsExist() throws Exception {
        var subjectDto = TestDataUtil.createTestSubjectDto();
        var savedSubject = subjectService.save(subjectDto);

        mockMvc.perform(
            MockMvcRequestBuilders.delete("/subjects/" + savedSubject.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deleteAllMethodReturnsHttp204WhenNoSubjectIsExist() throws Exception {

        mockMvc.perform(
            MockMvcRequestBuilders.delete("/subjects")
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deleteAllMethodReturnsHttp204WhenSubjectsIsExist() throws Exception {
        var subjectDto = TestDataUtil.createTestSubjectDto();
        subjectService.save(subjectDto);
        
        mockMvc.perform(
            MockMvcRequestBuilders.delete("/subjects")
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }


    @Test
    void findMethodReturnsHttp400NotFoundWhenTheSubjectIsNotExist() throws Exception {
        
        mockMvc.perform(
            MockMvcRequestBuilders.get("/subjects/99")
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void findMethodReturnsHttp200OkWhenTheSubjectIsExist() throws Exception {
        var subjectDto = TestDataUtil.createTestSubjectDto();
        var savedSubject = subjectService.save(subjectDto);

        mockMvc.perform(
            MockMvcRequestBuilders.get("/subjects/"+ savedSubject.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findMethodReturnsTheFoundedSubject() throws Exception {
        var subjectDto = TestDataUtil.createTestSubjectDto();
        var savedSubject = subjectService.save(subjectDto);
        mockMvc.perform(
            MockMvcRequestBuilders.get("/subjects/"+ savedSubject.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(savedSubject.getId()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(savedSubject.getTitle()));
    }

    @Test
    void partialUpdateMethodReturns404NotFoundWhenTheSubjectIsNotExist() throws Exception {

        var subject = TestDataUtil.createTestSubjectDto();
        var subjectJson = objectMapper.writeValueAsString(subject);
        mockMvc.perform(
            MockMvcRequestBuilders.patch("/subjects/99")
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(subjectJson)
        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void partialUpdateMethodReturns200OkWithTheUpdatedSubjectWhenTheSubjectIsExist() throws Exception {

        var subjectDto = TestDataUtil.createTestSubjectDto();
        var savedSubject = subjectService.save(subjectDto);
        var subjectJson = objectMapper.writeValueAsString(savedSubject);
        mockMvc.perform(
            MockMvcRequestBuilders.patch("/subjects/" + savedSubject.getId())
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(subjectJson)
        ).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(savedSubject.getId()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(savedSubject.getTitle()));
    }
}
