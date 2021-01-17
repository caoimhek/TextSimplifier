package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *A text file representation where the contents of the file 
 *come from an existing file in the file system.
 *
 * The path of that file is provided in the constructor.
 *
 * @author caoimhekilbride
 */

public class TextFile implements ITextFile {
	
	HashMap<Integer, String> eachLine = new HashMap<Integer, String>();

	/**
	 * Initializes the TextFile with the contents of a file 
	 * in the file system. 
	 * @param path		The path of the file in the file system.
	 * @throws IOException when the file specified at path cannot be accessed.
	 */
	public TextFile(String path) throws IOException {


		File file = new File(path);

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));

			String line = null;
			int counter = 0;
			while ((line = reader.readLine()) != null) {

				eachLine.put(counter++, line);

			}

		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	/**
	 * Returns the line at the specified index.
	 * 
	 * The complexity is O(1).
	 * 
	 * @param index		The line index.
	 */
	@Override
	public String getLine(int index) { 
		return eachLine.get(index);

	}

	/**
	 * Appends a line to the virtual text file.
	 * 
	 * The complexity is O(1).
	 */
	@Override
	public void addLine(String line) {
		eachLine.put(eachLine.size(), line);
	}

	/**
	 * Returns the number of lines of the virtual text file.
	 */
	@Override
	public int getNumberOfLines() {
		return eachLine.size();
		
	}

}
