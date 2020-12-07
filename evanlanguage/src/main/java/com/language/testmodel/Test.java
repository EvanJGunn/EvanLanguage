package com.language.testmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * A Test is a list of questions that can be added to.
 * 
 * @author Evan Gunn
 */
public class Test {
    private List<Question> questions;

    public Test() {
        questions = new ArrayList<Question>();
    }

    /**
     * Get the questions in the test.
     * 
     * @return The list of questions for the test.
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Add a question to the list of questions in the test.
     * 
     * @param question The question to be added.
     */
    public void addQuestion(Question question) {
        this.questions.add(question);
    }
}
