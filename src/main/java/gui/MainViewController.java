package gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.controlsales.application.ApplicationControlSales;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{
	
	@FXML
	private MenuItem menuItemRegistrationSale;
	
	@FXML
	private MenuItem historySales;
	
	@FXML
	private MenuItem totalSale;
	
	@FXML
	public void onMenuItemRegistrationSaleAction() {
		loadView("/gui/SalesRegistration.fxml");
	}
	
	@FXML
	public void onMenuItemHistorySalesAction() {
		System.out.println("History Sales");
	}
	
	@FXML
	public void onMenuItemTotalSaleAction() {
		System.out.println("Total Sale");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	private void loadView(String path) {
		try {		
			FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
			VBox newVBox = loader.load();
			
			Scene mainScene = ApplicationControlSales.getMainScene();
			VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVbox.getChildren().get(0);
			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(newVBox.getChildren());
			
		}catch(Exception e) {
			System.out.println("Error "+ e);
		}
	}
	
	

}
