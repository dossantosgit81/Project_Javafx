package br.com.controlsales.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class ApplicationControlSales extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
		ScrollPane scrollPane = loader.load();
		
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
		
		Scene mainScene = new Scene(scrollPane);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Tela principal");
		primaryStage.show();
		
		}catch(Exception e) {
		 e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}