package database;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import entity.Word;

/**
 * @author Evan Gunn
 * 
 * The data access object (dao) interface for words.
 */
@Repository
public interface WordDao {
	/**
	 * @return A list of all the words in the database.
	 */
	public ArrayList<Word> getAllWords();

	/**
	 * Get a random list of words from a specified language,
	 * the number of words returned will be exactly the specified
	 * amount, or zero if no words for the language exist in
	 * the database.
	 * @param language Must specify a language to draw words from.
	 * @param amount Number of words to return.
	 * @return A list of words, or null for zero words found.
	 */
	public ArrayList<Word> getRandomWords(String language, int amount);

	/**
	 * Add a word to the database.
	 */
	public void addWord(Word newWord);

	/**
	 * Remove a word from the database.
	 */
	public void deleteWord(Word deprecatedWord);
}
