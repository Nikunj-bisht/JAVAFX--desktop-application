package datamodel;

import javafx.beans.property.SimpleStringProperty;

public class Contact {

	
	private SimpleStringProperty firstname=new SimpleStringProperty("");
	private SimpleStringProperty lastname=new SimpleStringProperty("");
	private SimpleStringProperty phoneno=new SimpleStringProperty("");
	private SimpleStringProperty notes=new SimpleStringProperty("");
	
	public Contact() {
		
	}
	
	public Contact(String firstname,String lastname,String phoneno,String notes) {
		
		this.firstname.set(firstname);
		this.lastname.set(lastname);
		this.phoneno.set(phoneno);
		this.notes.set(notes);
		
	}

	public SimpleStringProperty getFirstnameproperty() {
		return firstname;
	}
	public String getFirstname() {
		return firstname.get();
	}
	
	public void setfirstname(String firstname) {
		this.firstname.set(firstname);
	}


	public SimpleStringProperty getLastnameproperty() { //last name
		return lastname;
	}
	public String getLastname() {
		return this.lastname.get();
	}
	public void setlastname(String name) {
		this.lastname.set(name);
	}
   // last name end

	public SimpleStringProperty getPhonenoproperty() {
		return phoneno;                             // phone no
 	}
	public String getPhoneno() {
		return phoneno.get();
	}
	public void setPhoneno(String phoneno) {
		this.phoneno.set(phoneno);
	}

	public SimpleStringProperty getNotesproperty() {
		return notes;                                           // notes
	}
	public String getnotes() {
		return this.notes.get();
	}
	
	
	public void setNotes(String notes) {
		this.notes.set(notes);
	}
	
	@Override
	public String toString() {
		return "firstname "+this.firstname+" lastname "+this.lastname+" phoneno "+this.phoneno+" notes "+this.notes;
	}
	
	
	
	
	
	
	 
	   
	 
}
