package yoffe.scrabble;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void containsFalseTest() throws IOException {
		final ScrabbleDictionary dic = new ScrabbleDictionary("US.dic");
		final String word = "excpetion";
		final boolean hasWord = dic.contains(word);
		Assert.assertFalse(hasWord);
	}

	@Test
	public void containsTest() throws IOException {
		final ScrabbleDictionary dic = new ScrabbleDictionary("US.dic");
		final String word = "mother";
		final boolean hasWord = dic.contains(word);
		Assert.assertTrue(hasWord);
	}

}
