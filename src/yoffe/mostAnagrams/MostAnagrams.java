package yoffe.mostAnagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostAnagrams {
	public static void main(String args[]) throws FileNotFoundException {

		Scanner input = new Scanner(new File("US.dic"));
		ArrayList<String> dictionary = new ArrayList<String>();
		ArrayList<String> sortedDictionary = new ArrayList<String>();

		MostAnagrams m = new MostAnagrams();

		// load all words of dictionary into memory and sort characters of each
		// word
		while (input.hasNext()) {
			dictionary.add(input.next());
		}

		// sort all words of dictionary by characters
		for (String s : dictionary) {
			sortedDictionary.add(m.sort(s));
		}

		HashMap<String, Integer> anagramDictionary = new HashMap<String, Integer>();
		for (String s : sortedDictionary) {
			Integer value = anagramDictionary.get(s);
			if (value == null) {
				anagramDictionary.put(s, 1);
			} else {
				anagramDictionary.put(s, value + 1);
			}
		}

		int largestAnagramValue = 1;
		String largestAnagram = null;
		for (Map.Entry<String, Integer> anagram : anagramDictionary.entrySet()) {
			int value = anagram.getValue();
			if (value > largestAnagramValue) {
				largestAnagramValue = value;
				largestAnagram = anagram.getKey();
			}
		}
		System.out.println(largestAnagramValue);

		// display all the words of largest anagram
		int index = 0;
		while (index < sortedDictionary.size()) {
			if (sortedDictionary.get(index).equals(largestAnagram)) {
				System.out.println(dictionary.get(index));
			}
			index++;
		}
	}

	// method to sort characters of a word
	public String sort(String word) {
		char[] letters = word.toLowerCase().toCharArray();
		Arrays.sort(letters);
		return String.valueOf(letters);
	}
}
