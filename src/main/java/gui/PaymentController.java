package gui;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.controlsales.model.LastSaleId;
import br.com.controlsales.model.ProdCart;
import br.com.controlsales.model.QuantityStock;
import br.com.controlsales.service.ConsumerAPI;
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
		Double m = Double.valueOf(money.getText());
		Double c = Double.valueOf(cartao.getText());
		Double t = (m + c) - Double.valueOf(total.getText());
		troco.setText(Double.toString(t));
		
		HashMap<String, String> values = new HashMap<>();
		values.put("client", Integer.toString(SalesRegistrationController.getIdClient()));
		values.put("total_sale", total.getText());
		values.put("obs", "Fixo para testar");
		ConsumerAPI api = new ConsumerAPI();
		api.post(values, "http://localhost:5000/sales");
		ObjectMapper mapper = new ObjectMapper();
		try {
			LastSaleId searchLastId = mapper.readValue(api.get("http://localhost:5000/lastid"), LastSaleId.class);
			Integer lastIdSale = searchLastId.getIdSale();
			for(ProdCart pc : SalesRegistrationController.getCart()) {
				pc.getId();
				String json = api.get("http://localhost:5000/stock/"+pc.getId());
				Integer qtd_stock = Integer.parseInt(json);
				System.out.println(qtd_stock);
				// mapper.readValue(json, QuantityStock.class);
				// System.out.println(new QuantityStock());
			}
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		total.setText(Double.toString(SalesRegistrationController.getTotalSale()));
		money.setText("0.0");
		cartao.setText("0.0");
	}

}
