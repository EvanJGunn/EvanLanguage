package com.language.entity;

import javax.persistence.*;

/**
 * This class corresponds to
 * the word table in the database.
 * Each word has a unique Id, and
 * a unique combination of romanization
 * and meaning. This allows for 
 * @author Evan Gunn
 */
@Entity
@Table(name = "word", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"meaning","romanization"})
})
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="wid")
    private int id;
    
    @Column(name = "wlanguage", nullable = false, length = 20)
    private String language;
    
    @Column(name = "meaning", nullable = false, length = 40)
    private String meaning;
    
    @Column(name = "romanization", nullable = false, length = 45)
    private String romanization;
    
    @Column(name = "wtype", nullable = false, length = 20)
    private String type;
    
    public Word(String language, String meaning, String romanization, String type) {
        this.language = language;
        this.meaning = meaning;
        this.romanization = romanization;
        this.type = type;
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
}
