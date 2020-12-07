package com.language.testmodel;

import org.springframework.beans.factory.annotation.Autowired;

import com.language.service.WordService;

/**
 * The TestBuilder class builds a test based off of the parameters passed to it.
 * 
 * @author Evan Gunn
 */
public class TestBuilder {
    @Autowired
    WordService wordService;

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
    public Test buildTest(TestType testType, String wordSource, String wordType, String language) {
        Test myTest = new Test();
        myTest.addQuestion(new Question("What is 2 + 2?", "4"));
        return myTest;
    }
}
