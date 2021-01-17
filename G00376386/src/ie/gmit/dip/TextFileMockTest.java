package ie.gmit.dip;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TextFileMockTest {

	String line0 = "line1, word1, word2, word3, word4";
	String line1 = "line 2, word 1, word2, word2, word4";
	String line2 = "line 3, word 1, word2, word2, word4";
	String line3 = "line 4, word 1, word2, word2, word4";
	
	@Test
	void testGetLine() {
		List<String> lines = new ArrayList<String>();
		
		lines.add(line0);
		lines.add(line1);
		lines.add(line2);
		
		TextFileMock textFile = new TextFileMock(lines);
		
		String firstLine = textFile.getLine(0);
		String secondLine = textFile.getLine(1);
		String thirdLine = textFile.getLine(2);
		
		Assert.assertEquals(line0, firstLine);
		Assert.assertEquals(line1, secondLine);
		Assert.assertEquals(line2, thirdLine);
	}
	
	@Test
	void testOutOfBoundsNegative() {
		List<String> lines = new ArrayList<String>();
		
		lines.add(line0);
		lines.add(line1);
		lines.add(line2);
		
		TextFileMock textFile = new TextFileMock(lines);
		
		String minusOne = textFile.getLine(-1);
		
		Assert.assertNull(minusOne);
	}
	
	@Test
	void testOutOfBoundsOver() {
		List<String> lines = new ArrayList<String>();
		
		lines.add(line0);
		lines.add(line1);
		lines.add(line2);
		
		TextFileMock textFile = new TextFileMock(lines);
		
		String oneHundred = textFile.getLine(100);
		
		Assert.assertNull(oneHundred);
	}
	
	@Test
	void testAddLine() {
		List<String> lines = new ArrayList<String>();
		
		lines.add(line0);
		lines.add(line1);
		lines.add(line2);
		
		TextFileMock textFile = new TextFileMock(lines);
		
		textFile.addLine(line3);
		
		String fourthLine = textFile.getLine(3);
		Assert.assertEquals(line3, fourthLine);
	}

}
