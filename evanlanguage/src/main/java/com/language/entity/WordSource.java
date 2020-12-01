package com.language.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * This class corresponds to
 * the wordsource table in
 * the database. The user may
 * choose to include a source
 * for their word, or they
 * may choose not to.
 * @author Evan Gunn
 */
@Entity
@Table(name = "wordsource", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"wid","sname"})
})
public class WordSource {
    // id is a foreign key from the word table
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wid")
    private int id;
    
    @Column(name = "sname", length = 45, nullable = false)
    private String source;

    // All wordsource table entries must have
    // one word they are associated with.
    @OneToOne
    private Word word;
    
    public WordSource(String source) {
        this.source = source;
    }
    
    public WordSource() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
