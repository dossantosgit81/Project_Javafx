package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable{
	
	@FXML
	private MenuItem menuItemRegistrationSale;
	
	@FXML
	private MenuItem historySales;
	
	@FXML
	private MenuItem totalSale;
	
	@FXML
	public void onMenuItemRegistrationSaleAction() {
		System.out.println("Registration");
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
	
	

}
