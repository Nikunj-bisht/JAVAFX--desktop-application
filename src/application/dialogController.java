package application;

import datamodel.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class dialogController {
               
	 
	@FXML
	private TextField tf1;
	 
	@FXML
	private TextField tf2;
	 
	 
	@FXML
	private TextField tf3;
	@FXML
	private TextField tf4;
	 
	public Contact addcon() {
		String firstname=tf1.getText();
		String lastname=tf2.getText();
		String phoneno=tf3.getText();
		String notes=tf4.getText();
		
		
		 Contact con=new Contact(firstname,lastname,phoneno,notes);
		
		return con; 
		
	}
	public void editcontact(Contact contact) {
		
		tf1.setText(contact.getFirstname());
		
		tf2.setText(contact.getLastname());
		tf3.setText(contact.getPhoneno());
		tf4.setText(contact.getnotes());

		
	}
	public void updatecontact(Contact selectedcontact) {
		// TODO Auto-generated method stub
		selectedcontact.setfirstname(tf1.getText());
		selectedcontact.setlastname(tf2.getText());
		selectedcontact.setPhoneno(tf3.getText());
		selectedcontact.setNotes(tf4.getText());

	}
	
	 
}
