package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PaymentController implements Initializable {
	
	@FXML
	private TextField money;
	
	@FXML
	private TextField cartao;
	
	@FXML
	private TextField troco;
	
	@FXML
	private TextField total;
	
	@FXML
	private Button finalize;
	
	@FXML
	public synchronized void onFinalizeAnction(){
		System.out.println("Pegou");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		total.setText(Double.toString(SalesRegistrationController.getTotalSale()));
	}

}
