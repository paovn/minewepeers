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
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Board;

public class ControllerWindow implements Initializable{
	
	private Board board;
	
	private GridPane gridNovate;
	
	private Button buttonx;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		board =new Board(0);
		
		//gridNovate.getColumnIndex(buttonx);
		//gridNovate.getRowIndex(buttonx);
		//buttonx.setId("col"+ "fil");
	//	gridNovate = (GridPane) board.generateBoard();
		//(buttonx) buttonx.setOnAction(this.touch);
		
	}
	public void generatedBoardBeginner(ActionEvent event) {
		
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
	
	public void clueButtonPressed(ActionEvent event) {
		
		int i = 0;
		int j = 0;
		for(Node node:gridNovate.getChildren()) {
			i = gridNovate.getRowIndex(buttonx);
			j = gridNovate.getColumnIndex(buttonx);
			//if("".equals(btn.getText())) {
				
			//	if(i>8 || j>8) {
					
					break;
			//	}if(gridNovate.putMark(i-1,j-1)>0) {
					
					
				//}
			//}
		}
	}
	
	public void solutionButtonPressed(ActionEvent event) {
		//gridNovate.setBoard(board.getBoard());
		
		
	}
	
	public void metodoMostrarCasilla(ActionEvent event) {
		
		Object obj = event.getSource();
		if(obj instanceof Button) {
			
			buttonx = (Button)obj;
			System.out.println("Orale wey");
		}
		
		String a = buttonx.getId();
		
		String[] b = a.split("p");
		for(int i = 1;i<b.length ;i++) {
			System.out.println(b[i]);
			
		}
	}
	

}
