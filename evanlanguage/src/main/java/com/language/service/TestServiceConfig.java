package com.language.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.language.testmodel.TestBuilder;

/**
 * The configuration for TestServices.
 * 
 * @author Evan Gunn
 */
@Configuration
public class TestServiceConfig {
    @Bean
    public TestBuilder getTestBuilder() {
        return new TestBuilder();
    }
}
