package com.language.service;

import com.language.testmodel.Test;
import com.language.testmodel.TestType;

/**
 * The service for Accessing test logic and creation.
 * 
 * @author Evan Gunn
 */
public interface TestService {
    public Test createTest(TestType testType, String wordSource, String wordType, String language);
}
