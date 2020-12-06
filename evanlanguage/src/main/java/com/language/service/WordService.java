package com.language.service;

import java.util.List;

import javax.transaction.Transactional;

import com.language.entity.Word;

public interface WordService {
    /**
     * @return A list of all words in the database
     */
    public List<Word> getAllWords();

    /**
     * Save an aggregation of word, symbols, and source to the database. Works as a
     * transaction, so failure at any point will result in a roll back. Will set the
     * word parameter of the symbols and source to the word provided.
     * 
     * @param word The word to be inserted.
     */
    @Transactional
    public Word saveAggregatedWord(Word word);

    /**
     * Delete a word, as well as its symbols and source if they exist.
     */
    @Transactional
    public void deleteAggregatedWord(long id);

    /**
     * @return A list of all words in a language
     */
    public List<Word> getWordsByLanguage(String language);

    /**
     * A method for server side debugging
     */
    public void printAll();
}
