package ma.youcode.YouQuiz.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.services.LevelService;

@AllArgsConstructor

@RestController
public class LevelController {
    
    private final LevelService levelService;
    
}
