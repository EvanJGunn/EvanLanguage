package com.language.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This class corresponds to the word table in the database. Each word has a
 * unique Id, and a unique combination of romanization and meaning.
 * 
 * @author Evan Gunn
 */
@Entity
@Table(name = "word")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wid")
    private int id;

    @Column(name = "wlanguage")
    private String language;

    @Column(name = "meaning")
    private String meaning;

    @Column(name = "romanization")
    private String romanization;

    @Column(name = "wtype")
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "symbolsid")
    private Symbols symbols;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sourceid")
    private WordSource wordSource;

    public Word(String language, String meaning, String romanization, String type) {
        this.language = language;
        this.meaning = meaning;
        this.romanization = romanization;
        this.type = type;
    }

    public Word() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getRomanization() {
        return romanization;
    }

    public void setRomanization(String romanization) {
        this.romanization = romanization;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public Symbols getSymbols() {
        return symbols;
    }

    public void setSymbols(Symbols symbols) {
        this.symbols = symbols;
    }

    public WordSource getWordSource() {
        return wordSource;
    }

    public void setWordSource(WordSource wordSource) {
        this.wordSource = wordSource;
    }
}
