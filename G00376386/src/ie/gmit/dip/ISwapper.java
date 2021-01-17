package ie.gmit.dip;

/**
 *Interface for swapping synonyms with common words.
 * @author caoimhekilbride
 */

public interface ISwapper {

	void initialize(ITextFile synonyms, ITextFile commonWords);
	
	String replace(String input);
}
