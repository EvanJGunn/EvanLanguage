package com.language.service;

import java.util.List;

import javax.transaction.Transactional;

import com.language.entity.Word;

/**
 * The interface for a service accessing a Word Repository.
 * 
 * @author Evan Gunn
 */
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
     * Delete an aggregation of word, symbols, and source from the database.
     * 
     * @param id The id of the word to be deleted.
     * @return The id of the deleted word on success, -1 on failure.
     */
    @Transactional
    public long deleteAggregatedWord(long id);

    /**
     * @return A list of all words in a language
     */
    public List<Word> getWordsByLanguage(String language);

    /**
     * A method for server side debugging
     */
    public void printAll();
}
