package yoffe.scrabble;

import java.io.FileNotFoundException;
import org.junit.Test;
import junit.framework.Assert;

public class ScrabbleDictionaryTest {	
	
	@Test
	public void containsTest() throws FileNotFoundException{
		ScrabbleDictionary dic = new ScrabbleDictionary("US.dic");
		String word = "mother";
		boolean hasWord = dic.contains(word);
		Assert.assertEquals(true, hasWord);
	}
	
	@Test
	public void containsFalseTest() throws FileNotFoundException{
		ScrabbleDictionary dic = new ScrabbleDictionary("US.dic");
		String word = "excpetion";
		boolean hasWord = dic.contains(word);
		Assert.assertEquals(false, hasWord);
	}
	
}
