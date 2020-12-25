package com.language.testmodel;

import com.language.entity.Word;

/**
 * A question is a tuple of a String named question, and a String named answer.
 * The word the question is based on is provided to allow additional context
 * to be provided to a user.
 * 
 * @author Evan Gunn
 */
public class Question {
    // The question to be asked
    private String question;

    // The answer to be given
    private String answer;
    
    // The word for context
    private Word word;

    public Question(String question, String answer, Word word) {
        this.question = question;
        this.answer = answer;
        this.word = word;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
    
    public Word getWord() {
        return word;
    }
}
