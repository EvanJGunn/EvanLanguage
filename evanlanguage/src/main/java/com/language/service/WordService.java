package com.language.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.language.entity.Symbols;
import com.language.entity.Word;
import com.language.entity.WordSource;
import com.language.repository.WordRepository;

/**
 * Contains the services provided to the controllers for usage.
 * 
 * @author Evan Gunn
 */
@Service
public class WordService {
    @Autowired
    WordRepository wordRepo;

    /**
     * Save an aggregation of word, symbols, and source to the database. Works as a
     * transaction, so failure at any point will result in a roll back. Will set the
     * word parameter of the symbols and source to the word provided.
     * 
     * @param word       The word to be inserted.
     * @param symbols    The symbols to be inserted.
     * @param wordSource The source to be inserted.
     */
    @Transactional
    public void saveAggregatedWord(Word word, Symbols symbols, WordSource wordSource) {
        if (word == null)
            return;

        if (symbols != null)
            symbols.setWord(word);
        if (wordSource != null)
            wordSource.setWord(word);

        word.setSymbols(symbols);
        word.setWordSource(wordSource);

        // Insert the word, source and symbols into the repository
        wordRepo.save(word);
    }

    // For testing purposes
    public void printAll() {
        for (Word w : wordRepo.findAll()) {
            System.out.println(w.getRomanization());
            if (w.getSymbols() != null)
                System.out.println(w.getSymbols().getMain());
            if (w.getWordSource() != null)
                System.out.println(w.getWordSource().getSource());
        }
    }
}
