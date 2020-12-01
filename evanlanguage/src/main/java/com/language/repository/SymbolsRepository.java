package com.language.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.language.entity.Symbols;

/**
 * CRUD access to the symbols table
 * @author Evan Gunn
 */
@Repository
public interface SymbolsRepository extends CrudRepository<Symbols, Long>{}
