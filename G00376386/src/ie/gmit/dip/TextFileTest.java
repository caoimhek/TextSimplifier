package ie.gmit.dip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TextFileTest {

	String line0 = "This is line 0";
	String line1 = "This is line 1";
	String line2 = "This is line2";

	@Test
	void testLoadingFile() {
		

		String path = "test.txt";
		File file = new File(path);
		FileWriter writer = null;

		List<String> lines = new ArrayList<String>(
				Arrays.asList(line0, line1, line2)
				);
		
		try {

			writer = new FileWriter(file);

			for(int i = 0; i < lines.size(); i++) {
				writer.write(lines.get(i)+ "\n");
			}
			
			writer.close();
			
			ITextFile textFile = new TextFile(path);
			assertFileHasLines(textFile, lines);

		} catch (FileNotFoundException e) {
			Assert.fail(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			Assert.fail(e.getMessage());
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		} finally {

			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			file.delete();
		}
	}
	
	void assertFileHasLines(ITextFile file, List<String> lines) {
		Assert.assertEquals(lines.size(), file.getNumberOfLines());
		
		for(int i = 0; i < file.getNumberOfLines(); i++) {
			String line = file.getLine(i);
			if (!line.equals(lines.get(i))) {
				Assert.fail("Expected line '" + lines.get(i)+"' vs actual '"+line+"'");
			}
		}
	}

}
