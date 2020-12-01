package com.language.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.language.entity.Symbols;
import com.language.entity.Word;
import com.language.entity.WordSource;
import com.language.repository.SourceRepository;
import com.language.repository.SymbolsRepository;
import com.language.repository.WordRepository;

/**
 * Contains the services provided to
 * the controllers for usage.
 * @author Evan Gunn
 */
@Service
public class WordService {
    @Autowired
    WordRepository wordRepo;
    @Autowired
    SourceRepository sourceRepo;
    @Autowired
    SymbolsRepository symbolsRepo;
    
    /**
     * Save an aggregation of word, symbols, and source
     * to the database. May work as a transaction, further
     * investigation into transactional and failure
     * cases required to ensure correctness of database.
     * Will set the word parameter of the symbols and source
     * to the word provided.
     * @param word The word to be inserted.
     * @param symbols The symbols to be inserted.
     * @param wordSource The source to be inserted.
     */
    @Transactional
    public void saveAggregatedWord(Word word, Symbols symbols, WordSource wordSource) {
        if (word == null) return;
        
        // Insert the word into the repository
        wordRepo.save(word);
        
        // Insert the symbols if they exist
        if (symbols!=null) {
            symbols.setWord(word);
            symbolsRepo.save(symbols);
        }
        
        // Insert the source if it exists
        if (wordSource!=null) {
            wordSource.setWord(word);
           sourceRepo.save(wordSource);
        }
    }
}
