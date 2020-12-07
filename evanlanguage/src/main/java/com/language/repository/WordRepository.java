package com.language.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.language.entity.Word;

/**
 * CRUD access to the word table
 * 
 * @author Evan Gunn
 */
@Repository
public interface WordRepository extends CrudRepository<Word, Long> {

    /**
     * Look into pagination: https://www.baeldung.com/spring-data-jpa-query
     * 
     * Get a list of all words with the specified language.
     * 
     * @param language The language you want words from.
     * @return A list of words from the language.
     */
    @Query("SELECT w FROM Word w WHERE w.language = :language")
    public List<Word> selectByLanguage(@Param("language") String language);
}
