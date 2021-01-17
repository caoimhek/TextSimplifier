package ie.gmit.dip;

import java.util.ArrayList;
import java.util.List;

/**
 *A swapper that uses an IParser and IMapper to 
 *swap input strings and produce outputs.
 *
 *Uses an initialization step where it reads
 *common words and synonyms from ITextFile instances.
 *
 * @author caoimhekilbride
 */

public class Swapper implements ISwapper {

	private IParser parser;
	private IMapper mapper;

	/**
	 * Creates a Swapper that uses an IParses and an IMapper.
	 * @param parser		An implementation of IParser.
	 * @param mapper		An implementation of IMapper.
	 */
	public Swapper(IParser parser, IMapper mapper) {
		this.parser = parser;
		this.mapper = mapper;
	}


	/**
	 * Initializes the Swapper by using a text file for synonyms 
	 * and another for common words.
	 * 
	 * The implementation uses an IMapper to map common words with synonyms
	 * and a parser to break text file lines into words.
	 * 
	 * The complexity is O(n * m) where n and m is the number of words in the
	 * common words and the synonyms files respectively.
	 */
	public void initialize(ITextFile synonyms, ITextFile commonWords) {
		
		List<String> addCommonWords = new ArrayList<String>();
		
		System.out.println("Adding words..");
		
		for (int i = 0; i < commonWords.getNumberOfLines(); i++) {
			String line = commonWords.getLine(i);
			System.out.println(i + " / " + commonWords.getNumberOfLines());
			addCommonWords.add(line);
		}
		
		System.out.println("Finished adding words");
		
		System.out.println("Creating mappings..");
		
		
		List<List<String>> tokensList = new ArrayList<List<String>>();
		
		for (int i = 0; i < synonyms.getNumberOfLines(); i++) {
			String line = synonyms.getLine(i);
			List<String> tokens = parser.tokenize(line, ",");
			tokensList.add(tokens);
		}
		
		for (int i = 0; i < addCommonWords.size(); i++) {
			String word = addCommonWords.get(i);

			System.out.println(i + "/ " + addCommonWords.size());
			for (int j = 0; j < tokensList.size(); j++) {
				List<String> tokens = tokensList.get(j);

			
				if (tokens.contains(word)) {
					mapper.add(tokens, word);
				}
			}
		}
		System.out.println("Finished adding mappings.");
	}

	/**
	 * Replaces the words in the input string with their
	 * simplified synonyms.
	 * 
	 * @param input		The input string to be replaced.
	 * @return		A new string which is the input string with each word replaced with a simplified synonym.
	 */
	public String replace(String input) {
		
		List<String> tokens = parser.tokenize(input, " ");
		String output = new String();
		
		for(int i = 0; i < tokens.size(); i++) {
			String token = tokens.get(i);
			String word = mapper.getCommon(token);
			if (word == null) {
				word = token;
			}
			output += word + " ";
		}
		output = output.trim();
		
		return output;
	}
}
