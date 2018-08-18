package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Board;

public class ControllerExpert implements Initializable {
	
	private Board board;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		board = new Board(1);
	}
	public void generatedBoardBegginer(ActionEvent event) {
			
			try {
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class.getResource("/application/window2.fxml"));
				Parent root = (Parent) loader.load();
				Scene scene = new Scene(root);
				
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.setTitle("Novate");
				window.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	public void generatedBoardIntermediate(ActionEvent event) {
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application/window.fxml"));
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.setTitle("Intermediate");
			window.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void generatedBoardExpert(ActionEvent event) {
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application/window3.fxml"));
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.setTitle("Expert");
			window.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
}
