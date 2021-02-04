package gui;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.controlsales.model.Client;
import br.com.controlsales.service.ConsumerAPI;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SalesRegistrationController implements Initializable {
	
	//Attributes search client
	@FXML
	private TextField getClientName;	
	@FXML
	private Button btnSearchClient;
	@FXML
	private Label setClientName;
	
	//Attributes search product
	
	

	@FXML
	public void onBtnSearchClientAction() {
		String cpf = getClientName.getText();
		String uri = "http://localhost:5000/search";
		
		HashMap<String, String> values = new HashMap<>();
		values.put("cpf", cpf);
		
		ConsumerAPI consumer = new ConsumerAPI();
		
		String response = consumer.post(values, uri).body();
		ObjectMapper mapper = new ObjectMapper();
		try {
			//12345678901234
			List<Client> client = mapper.readValue(response, new TypeReference<List<Client>>() {});
			System.out.println(client.get(0).getName());
			setClientName.setText(client.get(0).getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
