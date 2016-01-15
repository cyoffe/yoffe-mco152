package yoffe.nypl;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.gson.Gson;

public class ImagesThread extends Thread {

	private int index;
	private Result[] results;

	private ImageAPI response;
	private JPanel imagePanel;

	public ImagesThread(int index, Result[] results, JPanel imagePanel) {
		this.index = index;
		this.results = results;
		this.imagePanel = imagePanel;

	}

	@Override
	public void run() {

		URL url;
		try {
			url = results[index].getApiItemURL();

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", "Token token=\"j43zuga55odtz2if");

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			Gson gson = new Gson();

			response = gson.fromJson(reader, ImageAPI.class);

			response.getNyplAPI().getResponse().getCapture();

			BufferedImage image = ImageIO.read(new URL(response.getNyplAPI().getResponse().getCapture()[0]
					.getImageLinks().getImageLink()[3]));
			imagePanel.add(new JLabel(new ImageIcon(image)), BorderLayout.CENTER);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ImageResponse getResponse() {
		return response.getNyplAPI().getResponse();
	}

}
