package yoffe.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import com.google.gson.Gson;

public class TopTenLocations {

	public static void main(String[] args) throws IOException {

		final BufferedReader in = new BufferedReader(new FileReader("./ufo_awesome.json"));

		final Gson gson = new Gson(); // construct gson class

		final UFOSighting list[] = gson.fromJson(in, UFOSighting[].class);
		in.close();

		final HashMap<String, Integer> locations = new HashMap<String, Integer>();

		for (final UFOSighting sighting : list) {
			final Integer value = locations.get(sighting.getLocation());
			if (value == null) {
				locations.put(sighting.getLocation(), 1);
			} else {
				locations.put(sighting.getLocation(), value + 1);
			}

		}

		final ArrayList<String> loc = new ArrayList<String>(locations.keySet());
		Collections.sort(loc, new Comparator<String>() {
			@Override
			public int compare(String m, String n) {
				return locations.get(m).compareTo(locations.get(n));
			}
		});

		Collections.reverse(loc);
		for (int i = 0; i < 10; i++) {
			System.out.println((i + 1) + ". " + loc.get(i) + " - " + locations.get(loc.get(i)));
		}
	}
}
