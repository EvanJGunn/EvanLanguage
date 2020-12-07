package com.language.service;

import com.language.testmodel.Test;
import com.language.testmodel.TestParameters;

/**
 * The service for Accessing test logic and creation.
 * 
 * @author Evan Gunn
 */
public interface TestService {
    public Test createTest(TestParameters parameters);
}
