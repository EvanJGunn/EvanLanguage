package com.language.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.language.entity.Word;

/**
 * CRUD access to the word table
 * 
 * @author Evan Gunn
 */
@Repository
public interface WordRepository extends CrudRepository<Word, Long> {
}
