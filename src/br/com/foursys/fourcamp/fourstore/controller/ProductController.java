package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.service.StockService;

public class ProductController {
	private StockService stock;

	public ProductController() {
		this.stock = new StockService();
	}
	
	public boolean validateSku(String sku, int quantity) {
		
		
		return false;
	}
}
