package yoffe.nypl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class NYPLGui extends JFrame {

	private JList list;
	private JTextField searchText;
	private JButton searchButton;
	private SearchThread searchThread;
	private JPanel imagePanel;
	private ImagesThread imagesThread;
	private int index;
	private int num;

	public NYPLGui() {
		setTitle("NYPL");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultListModel<String> model = new DefaultListModel<String>();
		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new BorderLayout());
		searchText = new JTextField();
		searchButton = new JButton("SEARCH");
		searchPanel.add(searchText, BorderLayout.CENTER);
		searchPanel.add(searchButton, BorderLayout.EAST);

		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				searchThread = new SearchThread(searchText.getText(), model);
				searchThread.start();

			}
		});
		container.add(searchPanel, BorderLayout.NORTH);

		imagePanel = new JPanel();
		imagePanel.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel(new FlowLayout());

		JButton previous = new JButton("PREVIOUS");
		previous.setEnabled(false);
		JButton next = new JButton("NEXT");
		next.setEnabled(false);
		JLabel numImages = new JLabel();
		buttonPanel.add(previous);
		buttonPanel.add(numImages);
		buttonPanel.add(next);

		JScrollPane scroll = new JScrollPane();
		scroll.add(imagePanel);
		imagePanel.add(buttonPanel, BorderLayout.NORTH);
		container.add(imagePanel, BorderLayout.CENTER);

		list = new JList(model);
		container.add(list, BorderLayout.WEST);

		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent evt) {
				JList<String> lst = (JList<String>) evt.getSource();

				index = list.locationToIndex(evt.getPoint());
				imagesThread = new ImagesThread(index, searchThread.getResults(), imagePanel);
				imagesThread.start();
				num = imagesThread.getResponse().getCapture().length;

			}

		});

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				num = imagesThread.getResponse().getCapture().length;
				if (num == 1) {
					next.setEnabled(true);
				} else if (num > 1) {
					if (index != (num - 1)) {
						next.setEnabled(true);
					} else if ((index != 0) || (index != 1)) {
						previous.setEnabled(true);
					}

				}

			}
		});

		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});

	}

	public static void main(String[] args) {
		NYPLGui gui = new NYPLGui();
		gui.setVisible(true);
	}
}
