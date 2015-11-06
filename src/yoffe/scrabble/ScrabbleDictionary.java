package yoffe.scrabble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ScrabbleDictionary {

	HashSet<String> dictionary;

	public static ScrabbleDictionary singleton;

	private ScrabbleDictionary(String fileName) throws IOException {
		final BufferedReader input = new BufferedReader(new FileReader(fileName));
		dictionary = new HashSet<String>();

		String line;
		while ((line = input.readLine()) != null) {
			dictionary.add(line);
		}

		input.close();
	}

	public boolean contains(String word) {
		return (dictionary.contains(word));

	}

	public static ScrabbleDictionary getInstance(String filename) throws IOException {
		if (singleton == null) {
			singleton = new ScrabbleDictionary(filename);
		}
		return singleton;
	}

}
