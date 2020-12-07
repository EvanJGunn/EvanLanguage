package com.language.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.language.testmodel.Test;
import com.language.testmodel.TestBuilder;
import com.language.testmodel.TestType;

/**
 * An implementation of the TestService interface.
 * 
 * @author Evan Gunn
 */
@Service
public class MyTestService implements TestService {
    @Autowired
    private TestBuilder testBuilder;

    @Override
    public Test createTest(TestType testType, String wordSource, String wordType, String language) {
        return testBuilder.buildTest(testType, wordSource, wordType, language);
    }
}
