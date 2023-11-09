package ma.youcode.YouQuiz.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.models.dto.QuestionDto;
import ma.youcode.YouQuiz.services.QuestionService;

@AllArgsConstructor

@RestController
@RequestMapping("/questions")
public class QuestionController {
    
    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionDto> create(@RequestBody QuestionDto question) {
        var savedQuestion = questionService.save(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    @GetMapping
    public List<QuestionDto> getAll() {
        return questionService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionDto> update(@PathVariable("id") Long id, @RequestBody QuestionDto question) {
        if(!questionService.isExist(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        var updatedQuestion = questionService.update(id, question);
        return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);  
    }
    
}
