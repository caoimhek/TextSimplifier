package ie.gmit.dip;

import java.util.*;
import java.util.List;

/**
 *A parser that breaks an String input into tokens by using a delimiter.
 *The splitting is done using split from the String class.
 *
 * @author caoimhekilbride
 */

public class Parser implements IParser {

	/**
	 * Creates a list of tokens from the input string and the delimiter.
	 * 
	 * Uses the split function of String.
	 * 
	 * @param input		The input to be tokenized
	 * @param delimiter		The string to be used as a delimiter
	 * @return		The tokens produced by splitting the input string using the delimiter.
	 */
	
	public List<String> tokenize(String input, String delimiter) {
		
		String[] tokens = input.split(delimiter);

		List<String> elements = Arrays.asList(tokens);

		return elements;

	}

}
