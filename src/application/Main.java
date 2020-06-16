package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader root=new FXMLLoader();
			root.setLocation(getClass().getResource("sample.fxml")); 

			
			Scene scene = new Scene(root.load(),700,600);
			
			primaryStage.setScene(scene);
	primaryStage.setTitle("My Contacts");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
