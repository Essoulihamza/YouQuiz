package ma.youcode.YouQuiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import ma.youcode.YouQuiz.services.Service;

@Component
public abstract class Controller<Dto, Identifier> {
    
    private Service<Dto, Identifier> service;

    @Autowired
    public void setService(Service<Dto, Identifier> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Dto> save(@Valid @RequestBody Dto dto) {
        var savedDto = service.save(dto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    } 
    
    @GetMapping
    public List<Dto> getAll() {
        return service.getAll();
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Dto> find(@PathVariable("id") Identifier id) {
        var foundedDto = service.find(id);
        if (foundedDto == null) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(foundedDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dto> update(@PathVariable("id") Identifier id, @Valid @RequestBody Dto dto) {
        if(!service.isExist(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        var updatedDto = service.update(id, dto);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);  
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Identifier id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
    
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Dto> partialUpdate(@PathVariable("id") Identifier id, @Valid @RequestBody Dto dto) {
        if(!service.isExist(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        var updatedDto = service.partialUpdate(id, dto);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }

}
