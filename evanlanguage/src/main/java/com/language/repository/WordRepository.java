package com.language.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.language.entity.Symbols;
import com.language.entity.Word;
import com.language.entity.WordSource;
import com.language.testmodel.TestType;

/**
 * CRUD access to the word table
 * 
 * @author Evan Gunn
 */
@Repository
public interface WordRepository extends CrudRepository<Word, Long>, JpaSpecificationExecutor<Word>{

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
    
    /**
     * https://javadeveloperzone.com/spring/spring-jpa-dynamic-query-example/
     * 
     * Create a custom query using given parameters.
     * 
     * @param source The source to match, may be null.
     * @param wordType The type of word to match, may be null.
     * @param language The language to match, may also be null.
     * @param limit The number of words to return.
     * @return A randomized list, of size = limit, 
     */
    public default List<Word> selectBySpecification(String source, String wordType, String language, TestType testType, int limit) {
        if (limit < 0) {
            System.out.println("LOGGING: WordRepository, SelectBySpecification, Limit parameter under 0");
        }
        
        List<Word> myWords = findAll(new Specification<Word>() {
            private static final long serialVersionUID = -3590112995598216922L;

            @Override
            public Predicate toPredicate(Root<Word> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                
                // Add predicates for the given parameters
                if (source != null) {
                    Path<WordSource> mySource = root.<WordSource>get("wordSource");
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(mySource.get("source"), source)));
                }
                if (wordType != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("type"), wordType)));
                }
                if (language != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("language"), language)));
                }
                
                // Add predicates based on parameters
                switch (testType) {
                    case MAIN_SYMBOLS:
                        // Check that there is an entry in the source table for both main and ancillary symbols,
                        // which are necessary for a main_symbols test.
                        Path<Symbols> mySymbols = root.<Symbols>get("symbols");
                        predicates.add(criteriaBuilder.and(criteriaBuilder.isNotNull(mySymbols.get("main"))));
                        predicates.add(criteriaBuilder.and(criteriaBuilder.isNotNull(mySymbols.get("ancillary"))));
                        break;
                    case MEANING:
                        break;
                }
                
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        
        Collections.shuffle(myWords);
        return myWords.subList(0, Math.min(myWords.size(),limit));
    }
}
