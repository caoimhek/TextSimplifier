package ie.gmit.dip;

import java.util.List;

/**
 * 
 * Interface for a string parser.
 * 
 * @author caoimhekilbride
 *
 */
public interface IParser{
	
	public List<String> tokenize(String input, String delimiter);
}
