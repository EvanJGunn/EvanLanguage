package com.language.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.language.entity.WordSource;

/**
 * CRUD access to the wordsource table
 * @author Evan Gunn
 */
@Repository
public interface SourceRepository extends CrudRepository<WordSource, Long>{}
