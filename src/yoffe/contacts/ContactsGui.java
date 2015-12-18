package yoffe.contacts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import yoffe.weather16day.ContactInfo;

public class ContactsGui extends JFrame {
	private JList list;
	Contact[] contacts;
	private ContactsThread thread;

	public ContactsGui() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("CONTACT LIST");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		DefaultListModel<String> model = new DefaultListModel<String>();

		try {
			thread = new ContactsThread(model, contacts);
			thread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		list = new JList(model);

		list.addMouseListener(new MouseAdapter() {

			private Contact[] contact = contacts;

			@Override
			public void mouseClicked(MouseEvent evt) {
				JList<String> lst = (JList<String>) evt.getSource();
				if (evt.getClickCount() == 2) {

					// Double-click detected
					int index = list.locationToIndex(evt.getPoint());
					ContactInfo contactWindow = new ContactInfo(list, index, contact);

				}
			}
		});
		add(list);
	}

	public static void main(String[] args) {
		ContactsGui gui = new ContactsGui();
		gui.setVisible(true);
	}

}
