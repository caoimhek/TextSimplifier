package ie.gmit.dip;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SwapperTest {

	@Test
	void testInitialization() {

		IParser parser = new Parser();

		IMapper mapper = new Mapper();

		Swapper swapper = new Swapper(parser, mapper);

		ITextFile synonyms = new TextFileMock(
				Arrays.asList("super,hyper", "flat,apartment,dwelling", "dog,hound,canine"));

		ITextFile commonWords = new TextFileMock(Arrays.asList("super", "flat", "dog"));

		swapper.initialize(synonyms, commonWords);

		Assert.assertEquals("super", mapper.getCommon("super"));
		Assert.assertEquals("super", mapper.getCommon("hyper"));

		Assert.assertEquals("flat", mapper.getCommon("flat"));
		Assert.assertEquals("flat", mapper.getCommon("apartment"));
		Assert.assertEquals("flat", mapper.getCommon("dwelling"));

		Assert.assertEquals("dog", mapper.getCommon("dog"));
		Assert.assertEquals("dog", mapper.getCommon("hound"));
		Assert.assertEquals("dog", mapper.getCommon("canine"));
	}

	@Test
	void testReplace() {

		IParser parser = new Parser();

		IMapper mapper = new Mapper();

		Swapper swapper = new Swapper(parser, mapper);

		ITextFile synonyms = new TextFileMock(
				Arrays.asList("super,hyper", "flat,apartment,dwelling", "dog,hound,canine"));

		ITextFile commonWords = new TextFileMock(Arrays.asList("super", "flat", "dog"));

		String input = "Your flat is hyper ! How is your hound";

		

		String expectedOutput = "Your flat is super ! How is your dog";

		swapper.initialize(synonyms, commonWords);
		String output = swapper.replace(input);

		assertLinesAreEqual(expectedOutput, output);
	}

	void assertLinesAreEqual(String lineA, String lineB) {

		if (lineA.length() != lineB.length()) {
			Assert.fail("Line A has length " + lineA.length() + " line B has length" + lineB.length());
		}

		if (!lineA.equals(lineB)) {
			Assert.fail("Line A is " + lineA + " while line B is " + lineB);
		}
	}

}
