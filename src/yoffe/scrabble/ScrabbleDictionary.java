package yoffe.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {

	HashSet<String> dictionary;
	
	public ScrabbleDictionary(String fileName) throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		dictionary = new HashSet<String>();
		
		while (input.hasNext()) {
			dictionary.add(input.next());
		}
	}

	public boolean contains(String word) {
		return (dictionary.contains(word));
			
	}
	
}
