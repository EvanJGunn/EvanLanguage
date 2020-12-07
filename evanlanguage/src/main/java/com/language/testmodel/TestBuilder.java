package com.language.testmodel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.language.entity.Word;
import com.language.repository.WordRepository;

/**
 * The TestBuilder class builds a test based off of the parameters passed to it.
 * 
 * @author Evan Gunn
 */
@Component
public class TestBuilder {
    private static final int TEST_SIZE = 10;
    
    @Autowired
    WordRepository wordRepo;

    public TestBuilder() {
    }

    /**
     * Build a test based off of given parameters.
     * 
     * @param testType   The type of test to be created.
     * @param wordSource The source to be used in queries, can be null.
     * @param wordType   The Type of word to be used in queries, can be null.
     * @param language   The language to be used in queries, can be null.
     * @return New test built according to parameters.
     */
    public Test buildTest(TestType testType, String source, String wordType, String language) {
        // Get a list of words out of the repository based on parameters
        List<Word> myWords = wordRepo.selectBySpecification(source, wordType, language, TEST_SIZE);
        
        Test myTest = new Test();
        switch (testType) {
            case MEANING:
                for (Word w: myWords) {
                    myTest.addQuestion(new Question("What is the meaning of: " + w.getRomanization(), w.getMeaning()));
                }
                break;
            case MAIN_SYMBOLS:
                for (Word w: myWords) {
                    myTest.addQuestion(new Question("What is the reading of: " + w.getSymbols().getMain(), w.getSymbols().getAncillary()));
                }
                break;
        }
        return myTest;
    }
}
