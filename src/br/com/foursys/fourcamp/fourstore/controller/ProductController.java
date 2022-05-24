package br.com.foursys.fourcamp.fourstore.controller;

import java.util.HashMap;

import br.com.foursys.fourcamp.fourstore.exception.InvalidSellValueException;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.service.StockService;

public class ProductController {
	private StockService stock;

	public ProductController() {
		this.stock = new StockService();
	}

	public boolean validateSku(String sku, int quantity) {

		return false;
	}

	public String insertProduct(String sku, String description, int quantity, double buyPrice, double sellPrice)
			throws InvalidSellValueException {
		if (sku.length() != 13) {
			return " SKU inválida ";
		}
		if (description == null || quantity <= 0 || buyPrice <= 0 || sellPrice <= 0) {
			return " Digite os valores corretos de acordo com cada campo ";
		}
		Product product = new Product(sku, description, buyPrice, sellPrice);
		return stock.createProductStock(product, quantity);
	}

	public String findSku(String sku) throws ProductNotFoundException {
		return stock.findBySku(sku).toString();
	}

	public String listAll() {
		HashMap<Product, Integer> list = stock.listAll();
		String txt = "";
		for (HashMap.Entry<Product, Integer> product : list.entrySet()) {
			txt += product.toString() + "Quantidade: " + list.get(product) + "\n";
		}
		return txt;
	}

	public String delete(String sku) throws ProductNotFoundException {
		stock.deleteBySku(sku);
		return "Produto excluído com sucesso";
	}

	public String update(String sku, Integer quantity) throws ProductNotFoundException {
		Product product = stock.findBySku(sku);
		if (product == null) {
			return " Produto não encontrado!";
		}
		stock.reStock(sku, quantity);
		return " Produto atualizado com sucesso ";
	}

	public String update(String sku, Double buyPrice, Double sellPrice)
			throws ProductNotFoundException, InvalidSellValueException {
		Product product = stock.findBySku(sku);
		if (product == null) {
			return " Produto não encontrado!";
		}
		product.setBuyPrice(buyPrice);
		product.setSellPrice(sellPrice);
		stock.validateProfit(product);
		return "Produto atualizado com sucesso ";
	}

}
