package application;

import java.io.IOException;
import java.util.Optional;

import datamodel.Allcontacts;
import datamodel.Contact;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class Controller {
	
	@FXML
	
	private BorderPane borderpane;
		
	@FXML
	
	private TableView<Contact> tabledetail;
	private Allcontacts data;

	
	public void initialize() {
		data=new Allcontacts();
		data.loadContacts();
		tabledetail.setItems(data.getcontacts());
		System.out.println(data.getcontacts());

	}
	
@FXML
public void addcontact() throws IOException {
	Dialog<ButtonType> dialog=new Dialog<>();	
	dialog.setTitle("Add new Contact");
	dialog.initOwner(borderpane.getScene().getWindow());

	FXMLLoader fxmlloader=new FXMLLoader();
	
	fxmlloader.setLocation(getClass().getResource("dialog.fxml"));
	
	dialog.getDialogPane().setContent(fxmlloader.load());    
dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
	Optional<ButtonType> opt=dialog.showAndWait();
	if(opt.isPresent() && opt.get()==ButtonType.OK) {
		
		
		dialogController dialogdata=fxmlloader.getController();
		
		Contact contact=dialogdata.addcon();
		data.addContact(contact);
		
		data.saveContacts();
		//todo.getItems().setAll(todosaved.getInstance().getitems());

	}
	else {
		
	}
	
}

@FXML
public void editcontact() throws IOException {
	
	Contact selectedcontact=tabledetail.getSelectionModel().getSelectedItem();
	
	if(selectedcontact==null) {
		
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Select to Edit");
		alert.setHeaderText("Select one first");
		alert.showAndWait();
		
		
	}
	else {
		
		Dialog<ButtonType> dialog=new Dialog<>();	
		dialog.setTitle("Edit contact");
		dialog.initOwner(borderpane.getScene().getWindow());
		
		
		FXMLLoader fxmlloader=new FXMLLoader();
		
		fxmlloader.setLocation(getClass().getResource("dialog.fxml"));
		
		dialog.getDialogPane().setContent(fxmlloader.load());    
	
		dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

	dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
	dialogController dialogdata=fxmlloader.getController();
	
//	Contact contact=dialogdata.addcon();
	
	dialogdata.editcontact(selectedcontact);
	
	
	
//	data.addContact(contact);
	
	
		Optional<ButtonType> opt=dialog.showAndWait();
		if(opt.isPresent() && opt.get()==ButtonType.OK) {
			
			dialogdata.updatecontact(selectedcontact);
			data.saveContacts();
			
			
//data.loadContacts();
		
		
	}
		else {
			
		}

}

}
@FXML
public void deletecontact() {
	Contact selectedcontact=tabledetail.getSelectionModel().getSelectedItem();
if(selectedcontact==null) {
		
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Select to Edit");
		alert.setHeaderText("Select one first");
		alert.showAndWait();

}
else {
	
	Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
	alert.setTitle("delete");
	alert.setHeaderText("delete this");
	alert.setContentText("Are you sure you want to delete this");
//alert.showAndWait();
	
	
	Optional<ButtonType> opt=alert.showAndWait();
	if(opt.isPresent() && opt.get()==ButtonType.OK) {
		
		//dialogdata.updatecontact(selectedcontact);
		data.removecontact(selectedcontact);
		data.saveContacts();
		
		
//data.loadContacts();
	
	
}
	else {
		
	}
	
	
	
	
}
}
}
