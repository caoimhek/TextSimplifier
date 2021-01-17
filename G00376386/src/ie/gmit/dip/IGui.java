package ie.gmit.dip;

/**
 * Interface abstracting a user interface that can 
 * read from a user and write back to them.
 *
 * @author caoimhekilbride
 * 
 * 
 */

public interface IGui {

	String readInput();

	void writeOutput(String str);

	void endLine();

	void setInputColor(EConsoleColour color);

	void setOutputColor(EConsoleColour color);

}
