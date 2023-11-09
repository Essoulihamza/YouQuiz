package ma.youcode.YouQuiz.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping
    public List<LevelDto> getAll() {
        return levelService.getAll();
    } 

    @PutMapping("/{id}")
    public ResponseEntity<LevelDto> update(@PathVariable("id") Integer id, @RequestBody LevelDto level) {
        if(!levelService.isExist(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        var updatedLevel = levelService.update(id, level);
        return new ResponseEntity<>(updatedLevel, HttpStatus.OK);  
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        levelService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
    
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        levelService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
