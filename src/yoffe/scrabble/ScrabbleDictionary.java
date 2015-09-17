package yoffe.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleDictionary {
	private ArrayList<String> dictionary;

	public ScrabbleDictionary(String fileName) throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		dictionary = new ArrayList<String>();
		while (input.hasNext()) {
			String word = input.next();
			dictionary.add(word);
		}
	}

	public boolean contains(String word) {
		if (dictionary.contains(word)) {
			return true;
		} else {
			return false;
		}
	}
	
}
