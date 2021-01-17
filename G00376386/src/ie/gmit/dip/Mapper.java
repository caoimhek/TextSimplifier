package ie.gmit.dip;
import java.util.HashMap;
import java.util.List;

/**
 *A mapper that maps synonyms to common words using a hashmap.
 *Each synonym has its own entry and the common word maps to itself.
 *The mapper is case insensitive, i.e. both "Foo" and "foo" map to the same common 
 *word.
 *
 * @author caoimhekilbride
 */

public class Mapper implements IMapper {
	HashMap<String, String> mapper = new HashMap<String, String>();

	
	/**
	 * Associates a list of synonyms with the common word.
	 * 
	 * The complexity is O(n) where n is the number of synonyms.
	 * 
	 * @param synonims		The list of synonyms.
	 * @param commonWord		The common word.
	 */
	public void add(List<String> synonims, String commonWord) {
		
		for (int i = 0; i < synonims.size(); i++) {
			String synonim = synonims.get(i);
			if (!mapper.containsKey(synonim)) {
				mapper.put(synonim, commonWord.trim().toLowerCase());
			}
		}
		
		mapper.put(commonWord, commonWord);
	}

	/**
	 * Returns the common word that is synonym to the input.
	 * If a synonym does not exist, it returns null.
	 * 
	 * The complexity is O(1).
	 * 
	 * 
	 * @param word		The word to be queried for a synonym.
	 */
	public String getCommon(String word) {
		return mapper.get(word.trim().toLowerCase());
	}

}
