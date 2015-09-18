package yoffe.morsecode;

public class MorseCode {

	public MorseCode() {
	}

	public String encode(String message) {
		StringBuilder builder = new StringBuilder();
		String[] words = message.split(" ");
		for (int i = 0; i < words.length; i++) {
			char[] letters = words[i].toCharArray();
			for (int j = 0; j < letters.length; j++) {
				for (CodeConversion code : CodeConversion.values()) {
					if (letters[j] == code.getCharacterConversion()) {
						builder.append(code.getCodeConversion());
						continue;
					}
				}
				if (j < letters.length - 1) {
					builder.append(" ");
				}
			}
			if (i < words.length - 1) {
				builder.append("   ");
			}
		}
		return builder.toString();

	}

	public String decode(String code) {
		StringBuilder message = new StringBuilder();
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
						message.append(converting.getCharacterConversion());
						continue;
					}
				}
			}
			// add a space between each word but not the last
			if (i != words.length - 1) {

				message.append(" ");
			}
		}

		return message.toString();
	}

	// public String decode() {

	// }
}
