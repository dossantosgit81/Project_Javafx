package br.com.controlsales.model;

public class Product {
	
	private int id;
	
	private String descricao;
	
	private double preco;
	
	private int quantidade;
	
	private String fornecedor;
	
	private int id_fornecedor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(int id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", descricao=" + descricao + ", preco=" + preco + ", quantidade=" + quantidade
				+ ", fornecedor=" + fornecedor + ", id_fornecedor=" + id_fornecedor + "]";
	}
	
	
	
	

}
