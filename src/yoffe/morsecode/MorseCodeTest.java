package yoffe.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void decodeTest() {
		final MorseCode code = new MorseCode();
		final String codedMessage = "... . .--. -   .---- -....";
		final String englishConverted = code.decode(codedMessage).toLowerCase();

		Assert.assertEquals("sept 16", englishConverted);
	}

	@Test
	public void encodeTest() {
		final MorseCode code = new MorseCode();
		final String message = "sept 16";
		final String convertedCode = code.encode(message);

		Assert.assertEquals("... . .--. -   .---- -....", convertedCode);
	}

}
