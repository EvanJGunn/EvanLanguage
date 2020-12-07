package com.language.testmodel;

/**
 * The parameters for creating a test. Parameters are put in an object for use
 * in JSON serialization and deserialization.
 * 
 * @author Evan Gunn
 */
public class TestParameters {
    private TestType testType;
    private String source;
    private String wordType;
    private String language;

    public TestParameters(TestType testType, String source, String wordType, String language) {
        this.testType = testType;
        this.source = source;
        this.wordType = wordType;
        this.language = language;
    }

    public TestType getTestType() {
        return testType;
    }

    public void setTestType(TestType testType) {
        this.testType = testType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
