package yoffe.morsecode;

import java.util.HashMap;

public class MorseCode {

	private HashMap<Character, String> toMorse;
	private HashMap<String, Character> toEnglish;

	public MorseCode() {
		toMorse = new HashMap<Character, String>();
		for (CodeConversion c : CodeConversion.values()) {
			toMorse.put(c.getCharacterConversion(), c.getCodeConversion());
		}

		toEnglish = new HashMap<String, Character>();
		for (CodeConversion e : CodeConversion.values()) {
			toEnglish.put(e.getCodeConversion(), e.getCharacterConversion());
		}

	}

	public String encode(String message) {
		StringBuilder builder = new StringBuilder();
		String[] words = message.toLowerCase().split(" ");

		for (int i = 0; i < words.length; i++) {
			char[] letters = words[i].toCharArray();
			for (int j = 0; j < letters.length; j++) {
				builder.append(toMorse.get(words[i].charAt(j)));

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
		String[] words = code.toLowerCase().split("   ");

		// will now decode each word
		for (int i = 0; i < words.length; i++) {

			// split word decoding into individual chars
			letters = words[i].split(" ");
			
			// now will decode each char
			for (int j = 0; j < letters.length; j++) {
				message.append(toEnglish.get(letters[j]));
			}
			
			// add a space between each word but not the last
			if (i != words.length - 1) {

				message.append(" ");
			}
		}
		return message.toString();
	}
}
