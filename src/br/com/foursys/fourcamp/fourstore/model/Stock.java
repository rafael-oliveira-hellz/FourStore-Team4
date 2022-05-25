package br.com.foursys.fourcamp.fourstore.model;

public class Stock {
	
	private Product product;
	private Integer quantity;
	
	public Stock(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	
}

