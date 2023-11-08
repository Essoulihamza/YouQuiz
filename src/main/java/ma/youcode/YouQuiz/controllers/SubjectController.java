package ma.youcode.YouQuiz.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.models.dto.SubjectDto;
import ma.youcode.YouQuiz.services.SubjectService;

@AllArgsConstructor

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    
    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto newSubject) {
        SubjectDto createdSubject = subjectService.create(newSubject);
        return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
    }

    @GetMapping
    public List<SubjectDto> getSubjects() {
        return subjectService.read();
    }
}
