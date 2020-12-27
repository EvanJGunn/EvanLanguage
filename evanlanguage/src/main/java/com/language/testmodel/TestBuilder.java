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
    private static final String MEANING_QUESTION = "What is the meaning of: ";
    private static final String SYMBOLS_QUESTION = "What is the reading of: ";
    
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
    public Test buildTest(TestParameters parameters) {
        // Get a list of words out of the repository based on parameters
        List<Word> myWords = wordRepo.selectBySpecification(parameters.getSource(), parameters.getWordType(), parameters.getLanguage(), parameters.getTestType(), TEST_SIZE);
        
        Test myTest = new Test();
        switch (parameters.getTestType()) {
            case MEANING:
                for (Word w: myWords) {
                    myTest.addQuestion(new Question(MEANING_QUESTION + w.getRomanization(), w.getMeaning(), w));
                }
                break;
            case MAIN_SYMBOLS:
                for (Word w: myWords) {
                    myTest.addQuestion(new Question(SYMBOLS_QUESTION + w.getSymbols().getMain(), w.getSymbols().getAncillary(), w));
                }
                break;
        }
        return myTest;
    }
}
