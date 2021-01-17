package ie.gmit.dip;

/**
 * Interface for accessing text files.
 * @author caoimhekilbride
 */

public interface ITextFile {
	
	String getLine(int index);
	
	void addLine(String line);
	
	int getNumberOfLines();
}
