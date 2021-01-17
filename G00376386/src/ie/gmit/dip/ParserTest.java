package ie.gmit.dip;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ParserTest {

	@Test
	void testBasicFunctionality() {
		
		String input = "The brown fox jumps over the fence";
		Parser parser = new Parser();
		List<String> tokens = parser.tokenize(input," ");
		
		// Result is not null
		Assert.assertNotNull(tokens);
		
		// Result returns 7 items
		Assert.assertEquals(7, tokens.size());
		
		
		Assert.assertEquals("The", tokens.get(0));
		
		Assert.assertEquals("brown", tokens.get(1));

		Assert.assertEquals("fox", tokens.get(2));
		
		Assert.assertEquals("jumps", tokens.get(3));

		Assert.assertEquals("over", tokens.get(4));

		Assert.assertEquals("the", tokens.get(5));
		
		Assert.assertEquals("fence", tokens.get(6));

	}

}
