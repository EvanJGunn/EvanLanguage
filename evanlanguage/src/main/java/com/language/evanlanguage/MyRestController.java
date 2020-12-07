package com.language.evanlanguage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.language.entity.Word;
import com.language.service.TestService;
import com.language.service.WordService;
import com.language.testmodel.Question;
import com.language.testmodel.TestType;

/**
 * The Rest controller controls the mappings for requests
 * 
 * @author Evan Gunn
 */
@RestController
public class MyRestController {
    @Autowired
    private WordService wordService;

    @Autowired
    private TestService testService;

    @RequestMapping("/")
    public String welcome() {
        return "Welcome to Evan Language";
    }

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Word> saveWord(@RequestBody Word word) {
        return new ResponseEntity<>(wordService.saveAggregatedWord(word), HttpStatus.CREATED);
    }

    @GetMapping(path = "/words", produces = "application/json")
    public ResponseEntity<List<Word>> getAllWords() {
        return new ResponseEntity<>(wordService.getAllWords(), HttpStatus.OK);
    }

    @GetMapping(path = "/words/{language}", produces = "application/json")
    public ResponseEntity<List<Word>> getWordsByLanguage(@PathVariable(value = "language") String language) {
        return new ResponseEntity<>(wordService.getWordsByLanguage(language), HttpStatus.OK);
    }

    @GetMapping(path = "/test", produces = "application/json")
    public ResponseEntity<List<Question>> getTest() {
        return new ResponseEntity<>(
                testService.createTest(TestType.MAIN_SYMBOLS, null, null, "japanese").getQuestions(), HttpStatus.OK);
    }
}
