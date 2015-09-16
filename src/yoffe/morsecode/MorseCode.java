package yoffe.morsecode;

public class MorseCode {

	public MorseCode() {
	}

	public String encode(String message) {
		String morse = "";
		String[] words = message.split(" ");
		for (int i = 0; i < words.length; i++) {
			char[] letters = words[i].toCharArray();
			for (int j = 0; j < letters.length; j++) {
				for (CodeConversion code : CodeConversion.values()) {
					if (letters[j] == code.getCharacterConversion()) {
						morse += code.getCodeConversion();
						continue;
					}
				}
				if (j < letters.length - 1) {
					morse += " ";
				}
			}
			if (i < words.length - 1) {
				morse += "   ";
			}
		}
		return morse;

	}

	public String decode(String code) {
		String message = "";
		String[] letters;

		// split code into words of english language
		String[] words = code.split("   ");

		// will now decode each word
		for (int i = 0; i < words.length; i++) {

			// split word decoding into individual chars
			letters = words[i].split(" ");
			// now will decode each char
			for (int j = 0; j < letters.length; j++) {
				for (CodeConversion converting : CodeConversion.values()) {
					if (letters[j].equals(converting.getCodeConversion())) {
						message += converting.getCharacterConversion();
						continue;
					}
				}
			}
			// add a space between each word but not the last
			if (i != words.length - 1) {

				message += " ";
			}
		}

		return message;
	}

	// public String decode() {

	// }
}
