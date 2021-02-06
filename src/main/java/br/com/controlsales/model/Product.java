package br.com.controlsales.model;

public class Product {
	
	private Integer id;
	private String description;
	private double price;
	private Integer quantity_stock;
	private Integer for_id;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getQuantity_stock() {
		return quantity_stock;
	}
	public void setQuantity_stock(Integer quantity_stock) {
		this.quantity_stock = quantity_stock;
	}
	public Integer getFor_id() {
		return for_id;
	}
	public void setFor_id(Integer for_id) {
		this.for_id = for_id;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", price=" + price + ", quantity_stock="
				+ quantity_stock + ", for_id=" + for_id + "]";
	}
	
	


}
