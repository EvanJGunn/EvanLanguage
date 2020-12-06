package com.language.evanlanguage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.language.entity.Word;
import com.language.service.WordService;

/**
 * The Rest controller controls the mappings for requests
 * 
 * @author Evan Gunn
 */
@RestController
public class MyRestController {
    @Autowired
    private WordService wService;
    
    @RequestMapping("/")
    public String welcome() {
        return "Welcome to Evan Language";
    }
    
    @GetMapping(path = "/words", produces = "application/json")
    public ResponseEntity<List<Word>> getAllWords() {
        return new ResponseEntity<>(wService.getAllWords(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/words/{language}", produces = "application/json")
    public ResponseEntity<List<Word>> getWordsByLanguage(@PathVariable(value = "language") String language) {
        return new ResponseEntity<>(wService.getWordsByLanguage(language), HttpStatus.OK);
    }
}
