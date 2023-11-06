package ma.youcode.YouQuiz.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.services.SubjectService;

@AllArgsConstructor

@RestController
public class SubjectController {
    
    private final SubjectService subjectService;

}
