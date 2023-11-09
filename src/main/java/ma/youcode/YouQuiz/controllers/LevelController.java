package ma.youcode.YouQuiz.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.models.dto.LevelDto;
import ma.youcode.YouQuiz.services.LevelService;

@AllArgsConstructor

@RestController
@RequestMapping("/levels")
public class LevelController {
    
    private final LevelService levelService;

    @PostMapping
    public ResponseEntity<LevelDto> save(@RequestBody LevelDto level) {
        var savedLevel = levelService.save(level);
        return new ResponseEntity<>(savedLevel, HttpStatus.CREATED);
    } 
    
    
}
