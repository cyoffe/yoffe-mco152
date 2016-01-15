package yoffe.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.DefaultListModel;

import com.google.gson.Gson;

public class SearchThread extends Thread {

	private String searchText;
	private DefaultListModel<String> model;
	private Result[] results;

	public SearchThread(String searchText, DefaultListModel<String> model) {
		this.model = model;
		this.searchText = searchText;
	}

	@Override
	public void run() {
		URL url;
		try {
			url = new URL("http://api.repo.nypl.org/api/v1/items/search?q=" + searchText + "&publicDomainOnly=true");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", "Token token=\"j43zuga55odtz2if");

			BufferedReader reader;
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			Gson gson = new Gson();

			SearchApi response = gson.fromJson(reader, SearchApi.class);

			results = response.getNyplAPI().getResponse().getResult();

			for (Result r : results) {
				if (r.getTitle().contains(searchText)) {
					String t = r.getTitle();
					if (t.length() > 30) {
						model.addElement(t.substring(0, 26) + "...");
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Result[] getResults() {
		return results;
	}

}
