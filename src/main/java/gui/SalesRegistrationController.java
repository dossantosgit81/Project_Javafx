package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.controlsales.model.Client;
import br.com.controlsales.model.ProdCart;
import br.com.controlsales.model.Product;
import br.com.controlsales.service.ConsumerAPI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
	private TextField getProductData;
	@FXML
	private Button searchProductData;
	
	//Attributes datas products
	@FXML
	private TextField getProductCode;
	@FXML
	private TextField getProductPrice;
	@FXML
	private TextField getProductDescription;
	@FXML
	private TextField getProductQtd;
	@FXML
	private Button addProductCart;
	@FXML
	private Button goPayment;
	
	//Attributes for table
	@FXML
	private TableView<ProdCart> tableViewProducts;
	@FXML
	private TableColumn<ProdCart, Integer> tableColumnId;
	@FXML
	private TableColumn<ProdCart, Double> tableColumnPrice;
	@FXML
	private TableColumn<ProdCart, String> tableColumnDescription;
	@FXML
	private TableColumn<ProdCart, Integer> tableColumnqtd;
	@FXML
	private TableColumn<ProdCart, Double> tableColumnSubtotal;
	private ObservableList<ProdCart> obsProd;
	private static ProdCart pc;
	private static Double totalSale = 0.0;

	
	private static List<ProdCart> cart = new ArrayList<>();

	public static ProdCart getPc() {
		return pc;
	}

	public static void setPc(ProdCart pc) {
		SalesRegistrationController.pc = pc;
	}
	
	public static List<ProdCart> getCart() {
		return cart;
	}

	public static void setCart(List<ProdCart> cart) {
		SalesRegistrationController.cart = cart;
	}

	private static Integer idClient;

	public static Integer getIdClient() {
		return idClient;
	}

	public static void setIdClient(Integer idClient) {
		SalesRegistrationController.idClient = idClient;
	}

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
			idClient = client.get(0).getId();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@FXML
	public void onSearchProductDataAction() {
		String productId = getProductData.getText();
		
		HashMap<String, String> values = new HashMap<>();
		values.put("id", productId);
		
		ConsumerAPI api = new ConsumerAPI();
		ObjectMapper mapper = new ObjectMapper();
		String response = api.post(values, "http://localhost:5000/find").body();
		try {
			List<Product> product = mapper.readValue(response, new TypeReference<>() {});
			Product prod = product.get(0);
			getProductCode.setText(prod.getId().toString());
			getProductPrice.setText(String.valueOf(prod.getPrice()));
			getProductDescription.setText(prod.getDescription());
		}catch(Exception e) {
			System.out.println("Error "+ e);
		}
	}
	
	public void setProdCart(ProdCart prodCart) {
		this.pc = prodCart;
	}
	
	@FXML
	public void onAddProductCartAction() {
			tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
			tableColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
			tableColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
			tableColumnqtd.setCellValueFactory(new PropertyValueFactory<>("qtd"));
			tableColumnSubtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
			
			setProdCart(new ProdCart());
			pc.setId(Integer.parseInt(getProductCode.getText()));
			pc.setPrice(Double.parseDouble(getProductPrice.getText()));
			pc.setDescription(getProductDescription.getText());
			pc.setQtd(Integer.parseInt(getProductQtd.getText()));
			pc.setSubtotal(pc.getQtd() * pc.getPrice());
			
			cart.add(pc);
			System.out.println(cart);
			obsProd = FXCollections.observableArrayList(cart);
			tableViewProducts.setItems(obsProd);
			double total = 0.0;
			for (ProdCart itemCart : cart) {
				total += itemCart.getSubtotal();
			}
			totalSale = total;
			System.out.println(totalSale);
			
			getProductData.clear();
			getProductQtd.clear();		
	}
	
	public static Double getTotalSale() {
		return totalSale;
	}

	@FXML
	public void onGoPaymentAction() {
		MainViewController lv = new MainViewController();
		lv.loadView("/gui/Payment.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
