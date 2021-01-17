package ie.gmit.dip;

import java.util.ArrayList;
import java.util.List;

/**
 *A virtual text file where the contents are injected
 *as a list of lines.
 *
 * A mock implementation for unit testing classes that depend on ITextFile.
 *
 * @author caoimhekilbride
 */
public class TextFileMock implements ITextFile {

	private List<String> lines;

	/**
	 * Creates a virtual text file whose contents are 
	 * initialized from a List of Strings.
	 * @param lines		The lines of the file to be initialized from.
	 */
	public TextFileMock(List<String> lines) {
		this.lines = lines;
	}

	/**
	 * Creates an empty virtual text file.
	 */
	public TextFileMock() {
		this.lines = new ArrayList<String>();
	}

	/**
	 * Returns the line at the specified index.
	 */
	public String getLine(int index) {

		if (index >= lines.size() || index < 0) {

			return null;
		}

		return lines.get(index);

	}

	/**
	 * Appends a line to the virtual text file.
	 */
	@Override
	public void addLine(String line) {

		lines.add(line);
	}

	/**
	 * Returns the number of lines in the virtual text file.
	 */
	@Override
	public int getNumberOfLines() {
		return lines.size();
	}
}