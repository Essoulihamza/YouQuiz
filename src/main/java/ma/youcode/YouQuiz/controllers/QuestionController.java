package ma.youcode.YouQuiz.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.services.QuestionService;

@AllArgsConstructor

@RestController
public class QuestionController {
    
    private final QuestionService questionService;
    
}
