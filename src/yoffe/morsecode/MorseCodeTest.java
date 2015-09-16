package yoffe.morsecode;

import org.junit.Test;

import junit.framework.Assert;

public class MorseCodeTest {
	
	@Test
	public void encodeTest(){
		MorseCode code = new MorseCode();
		String message = "sept 16";
		String convertedCode = code.encode(message);
		
		Assert.assertEquals("... . .--. -   .---- -....", convertedCode);
	}
	
	@Test
	public void decodeTest(){
		MorseCode code = new MorseCode();
		String codedMessage = "... . .--. -   .---- -....";
		String englishConverted = code.decode(codedMessage).toLowerCase();
		
		Assert.assertEquals("sept 16", englishConverted);
	}
	
	
	
}
