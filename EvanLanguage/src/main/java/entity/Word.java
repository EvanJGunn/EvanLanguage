package entity;

/**
 * Word represents data for a word that is stored locally on the client side.
 * This can include a word that will be inserted, a word that will be updated with new information,
 * or a word that will be deleted.
 * A word therefore may not contain the same data as an equivalent word that is contained in the database.
 * @author Evan Gunn
 *
 */
public class Word {
	private String romanization, language, meaning, wtype, main, ancillary, sname;
    private int wid = -1;
}
