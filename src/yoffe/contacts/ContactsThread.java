package yoffe.contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import javax.swing.DefaultListModel;

import com.google.gson.Gson;

public class ContactsThread extends Thread {
	private DefaultListModel<String> model;
	private Contact[] contacts;

	public ContactsThread(DefaultListModel<String> model) throws IOException {
		this.model = model;
	}

	@Override
	public void run() {
		URL url;
		try {
			url = new URL("http://jsonplaceholder.typicode.com/users");

			HttpURLConnection connection = null;
			connection = (HttpURLConnection) url.openConnection();
			BufferedReader reader;
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			Gson gson = new Gson();
			contacts = gson.fromJson(reader, Contact[].class);
			Arrays.sort(contacts);

			for (Contact c : contacts) {
				model.addElement(c.getName());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public Contact[] getContacts() {
		return contacts;
	}

}
