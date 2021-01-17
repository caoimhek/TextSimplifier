package ie.gmit.dip;

import java.util.List;


/**
 * Interface for mapping common words to their synonyms.
 * @author caoimhekilbride
 */

public interface IMapper {

	public void add(List<String> synonims, String commonWord);

	public String getCommon(String word);
}
