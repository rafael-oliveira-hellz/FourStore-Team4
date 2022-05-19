package br.com.foursys.fourcamp.fourstore.model;

import java.util.ArrayList;

public class Transaction {
	private ArrayList<Integer> quantityProduct;
	private ArrayList<Product> products;
	private Costumer constumer;
	private Double totalPrice;
	
	public Transaction(Costumer constumer) {
		this.constumer = constumer;
		this.totalPrice = 0.0;
		quantityProduct = new ArrayList<Integer>();
		products = new ArrayList<Product>();
	}

	public Costumer getConstumer() {
		return constumer;
	}

	public Double getTotalPrice() {
		int qtt = 0;
		double price = 0.0;
		
		for(int i = 0; i < quantityProduct.size(); i++) {
			qtt = quantityProduct.get(i);
			price = products.get(i).getSellPrice();
			totalPrice +=price * qtt;
		}
		return totalPrice;
	}

	public void addProducts(Product product, Integer quantityProduct) {
		this.products.add(product);
		this.quantityProduct.add(quantityProduct);
	}

	@Override
	public String toString() {
		return "Transaction [quantityProduct=" + quantityProduct + ", products=" + products + ", constumer=" + constumer + ", totalPrice="
				+ totalPrice + "]";
	}
	
}
