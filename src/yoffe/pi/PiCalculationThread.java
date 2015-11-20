package yoffe.pi;

import javax.swing.JLabel;

public class PiCalculationThread extends Thread {

	private JLabel label;

	public PiCalculationThread(JLabel label) {
		this.label = label;
	}

	@Override
	public void run() {

		CalculatePi calc = new CalculatePi();
		double pi = calc.calculatePi(10000000000L);
		label.setText(String.valueOf(pi));

	}
}
