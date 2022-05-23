package br.com.foursys.fourcamp.fourstore.model;

import java.util.HashMap;

public class Transaction {
	private static Integer superId = 0;
	private Integer id;
	private HashMap<Product, Integer> products;
	private Costumer constumer;
	private Double totalPrice;
	
	public Transaction(Costumer constumer) {
		superId++;
		this.id = superId;
		this.constumer = constumer;
		this.totalPrice = 0.0;
		products = new HashMap<Product, Integer>();
	}

	public Costumer getConstumer() {
		return constumer;
	}
	
	public Integer getId() {
		return id;
	}
	
	public HashMap<Product, Integer> getProducts() {
		return products;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getTotalPrice() {		
		products.forEach((key, value) -> {
			totalPrice += key.getSellPrice() * value;			
		});
		return totalPrice;
	}

	public void addProducts(Product product, Integer quantityProduct) {
		this.products.put(product, quantityProduct);
	}

	@Override
	public String toString() {
		return "Transaction [products=" + products.toString() + ", constumer=" + constumer + ", totalPrice="
				+ totalPrice + "]";
	}
	
}
