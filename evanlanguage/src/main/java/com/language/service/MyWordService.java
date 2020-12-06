package com.language.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.language.entity.Word;
import com.language.repository.WordRepository;

/**
 * Contains the services provided to the controllers for usage.
 * 
 * @author Evan Gunn
 */
@Service
public class MyWordService implements WordService {
    @Autowired
    WordRepository wordRepo;

    @Override
    @Transactional
    public Word saveAggregatedWord(Word word) {
        return wordRepo.save(word);
    }

    @Override
    public List<Word> getAllWords() {
        List<Word> myWords = new ArrayList<Word>();
        Iterable<Word> wordIterable = wordRepo.findAll();
        for (Word w : wordIterable) {
            myWords.add(w);
        }
        return myWords;
    }

    @Override
    public void deleteAggregatedWord(long id) {
        wordRepo.deleteById(id);
    }

    @Override
    public List<Word> getWordsByLanguage(String language) {
        return wordRepo.selectByLanguage(language);
    }

    @Override
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
