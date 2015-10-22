package yoffe.math;

import java.util.HashSet;

public class ShowDuplicates {
	public static void main(String args[]) {
		
		String[] array = new String[] { "A", "B", "B", "C", "C" };
		

		HashSet<String> set = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
		
		for (String s : array) {
			if (set.contains(s) && !set2.contains(s)) {
				System.out.println(s);
				set2.add(s);
			}	
			set.add(s);
		}
		
		
		
		
		

	}
}
