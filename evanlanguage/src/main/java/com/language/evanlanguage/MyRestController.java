package com.language.evanlanguage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.language.entity.Word;
import com.language.service.TestService;
import com.language.service.WordService;
import com.language.testmodel.Question;
import com.language.testmodel.TestParameters;

/**
 * The Rest controller controls the mappings for requests
 * 
 * @author Evan Gunn
 */
@RestController
@CrossOrigin
public class MyRestController {
    @Autowired
    private WordService wordService;

    @Autowired
    private TestService testService;

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Word> saveWord(@RequestBody Word word) {
        return new ResponseEntity<>(wordService.saveAggregatedWord(word), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete", consumes = "application/json")
    public ResponseEntity<Long> deleteWord(@RequestBody Word word) {
        return new ResponseEntity<>(wordService.deleteAggregatedWord(word.getId()), HttpStatus.CREATED);
    }

    @GetMapping(path = "/words", produces = "application/json")
    public ResponseEntity<List<Word>> getAllWords() {
        return new ResponseEntity<>(wordService.getAllWords(), HttpStatus.OK);
    }

    @GetMapping(path = "/words/{language}", produces = "application/json")
    public ResponseEntity<List<Word>> getWordsByLanguage(@PathVariable(value = "language") String language) {
        return new ResponseEntity<>(wordService.getWordsByLanguage(language), HttpStatus.OK);
    }

    @PostMapping(path = "/test", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<Question>> getTest(@RequestBody TestParameters parameters) {
        return new ResponseEntity<>(testService.createTest(parameters).getQuestions(), HttpStatus.OK);
    }
}
