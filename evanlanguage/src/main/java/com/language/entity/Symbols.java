package com.language.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This class corresponds to the symbols table in the database. The user may
 * choose to include the symbols for a word, or they may not.
 * 
 * @author Evan Gunn
 */
@Entity
@Table(name = "symbols")
public class Symbols {
    // id is a foreign key from the word table
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wid")
    private int id;

    @Column(name = "main")
    private String main;

    // Ancillary is meant for the reading
    // of kanji, it may be left null if
    // the main symbols are katakana or
    // hiragana.
    @Column(name = "ancillary")
    private String ancillary;

    //@OneToOne(mappedBy = "symbols")
    //private Word word;

    public Symbols(String main, String ancillary) {
        this.main = main;
        this.ancillary = ancillary;
    }

    public Symbols() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getAncillary() {
        return ancillary;
    }

    public void setAncillary(String ancillary) {
        this.ancillary = ancillary;
    }
}
