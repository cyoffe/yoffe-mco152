package yoffe.mostAnagrams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostAnagrams {
	public static void main(String args[]) throws IOException {

		final BufferedReader input = new BufferedReader(new FileReader("US.dic"));
		final ArrayList<String> dictionary = new ArrayList<String>();
		final ArrayList<String> sortedDictionary = new ArrayList<String>();

		final MostAnagrams m = new MostAnagrams();

		// load all words of dictionary into memory and sort characters of each
		// word
		String line;
		while ((line = input.readLine()) != null) {
			dictionary.add(line);
		}

		input.close();

		// sort all words of dictionary by characters
		for (final String s : dictionary) {
			sortedDictionary.add(m.sort(s));
		}

		final HashMap<String, Integer> anagramDictionary = new HashMap<String, Integer>();
		for (final String s : sortedDictionary) {
			final Integer value = anagramDictionary.get(s);
			if (value == null) {
				anagramDictionary.put(s, 1);
			} else {
				anagramDictionary.put(s, value + 1);
			}
		}

		int largestAnagramValue = 1;
		String largestAnagram = null;
		for (final Map.Entry<String, Integer> anagram : anagramDictionary.entrySet()) {
			final int value = anagram.getValue();
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
		final char[] letters = word.toLowerCase().toCharArray();
		Arrays.sort(letters);
		return String.valueOf(letters);
	}
}
