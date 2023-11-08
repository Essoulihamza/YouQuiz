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
import ma.youcode.YouQuiz.models.dto.SubjectDto;
import ma.youcode.YouQuiz.services.SubjectService;

@AllArgsConstructor

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    
    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto newSubject) {
        SubjectDto createdSubject = subjectService.save(newSubject);
        return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
    }

    @GetMapping
    public List<SubjectDto> getSubjects() {
        return subjectService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> updateSubject(
            @PathVariable("id") Long id,
            @RequestBody SubjectDto subjectDtoToUpdate) {

        if(!subjectService.isExist(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        var updatedSubject = subjectService.update(subjectDtoToUpdate);
         return new ResponseEntity<>(updatedSubject ,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable("id") Long id) {
        subjectService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllSubjects() {
        subjectService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
