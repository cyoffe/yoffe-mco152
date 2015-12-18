package yoffe.weather16day;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import yoffe.contacts.Contact;

public class ContactInfo extends JFrame {

	private JList list;
	private int index;
	private JLabel name, email, street, city, zip, phone;
	private Contact[] contacts;

	public ContactInfo(JList list, int index, Contact[] contacts) {
		this.list = list;
		this.index = index;
		this.contacts = contacts;

		setLayout(new BorderLayout());
		setSize(300, 300);
		setVisible(true);
		setTitle("CONTACT INFORMATION");
		setVisible(true);

		Contact contact = contacts[index];
		JPanel info = new JPanel();
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		name = new JLabel("NAME: " + contact.getName());
		email = new JLabel("EMAIL: " + contact.getEmail());
		street = new JLabel("STREET: " + contact.getAddress().getStreet());
		city = new JLabel("CITY: " + contact.getAddress().getCity());
		zip = new JLabel("ZIPCODE: " + contact.getAddress().getZipcode());
		phone = new JLabel("PHONE: " + contact.getPhone());
		info.add(name);
		info.add(email);
		info.add(street);
		info.add(city);
		info.add(zip);
		info.add(phone);
		add(info, BorderLayout.CENTER);
	}

}
