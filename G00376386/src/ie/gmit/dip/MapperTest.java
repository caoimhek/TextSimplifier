package ie.gmit.dip;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MapperTest {

	@Test
	void testBasicFunctionality() {
		Mapper mapper = new Mapper();
		
		List<String> synonimsSet1 = new LinkedList<String>();
		synonimsSet1.add("word1");
		synonimsSet1.add("word2");
		synonimsSet1.add("word3");
		
		
		
		mapper.add(synonimsSet1, "mycommonword");
		
		String commonWord = mapper.getCommon("word2");
		
		Assert.assertNotNull(commonWord);
		
		
		Assert.assertEquals("mycommonword", commonWord);
	}

}
