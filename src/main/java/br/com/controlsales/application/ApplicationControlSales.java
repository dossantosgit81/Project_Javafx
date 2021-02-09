package br.com.controlsales.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class ApplicationControlSales extends Application {

	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
		ScrollPane scrollPane = loader.load();
		
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
			
		mainScene = new Scene(scrollPane);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Tela principal");
		primaryStage.setHeight(700);
		primaryStage.show();
		
		}catch(Exception e) {
		 e.printStackTrace();
		}
		
	}

	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
