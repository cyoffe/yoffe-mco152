package yoffe.nypl;

import javax.swing.JPanel;

public class IThread extends Thread {

	private JPanel imagePanel;

	public IThread(JPanel imagePanel) {
		this.imagePanel = imagePanel;
	}

	@Override
	public void run() {

	}
}
