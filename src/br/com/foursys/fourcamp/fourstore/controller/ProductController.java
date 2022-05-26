package br.com.foursys.fourcamp.fourstore.controller;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.exception.InvalidSellValueException;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Stock;
import br.com.foursys.fourcamp.fourstore.service.StockService;

public class ProductController {
	private StockService stock;

	public ProductController() {
		this.stock = new StockService();
	}

	public boolean validatePrePurchase(String sku, int quantity) throws ProductNotFoundException {
		return stock.validateIndividualPurchase(sku, quantity);
		
	}

	public String insertProduct(String sku, String description, int quantity, double buyPrice, double sellPrice)
			throws InvalidSellValueException {
		if (sku.length() != 13) {
			return " SKU inválida ";
		}
		if (description == null || quantity <= 0 || buyPrice <= 0.0 || sellPrice <= 0.0) {
			return " Digite os valores corretos de acordo com cada campo ";
		}
		Product product = new Product(sku, description, buyPrice, sellPrice);
		return stock.createProductStock(product, quantity);
	}

	public String findSku(String sku) throws ProductNotFoundException {
		return stock.verifyIfExists(sku).toString();
	}

	public String listAll() {
		 List<Stock> stocks = stock.listAll();
		String txt = "";
		for (Stock stock : stocks) {
			txt += stock.getProduct().toString() + ". quantidade: " + stock.getQuantity() + "\n";
		}
		return txt;
	}

	public String delete(String sku) throws ProductNotFoundException {
		stock.deleteBySku(sku);
		return "Produto excluído com sucesso";
	}

	public String update(String sku, Integer quantity) throws ProductNotFoundException {
		Product product = stock.verifyIfExists(sku);
		if (product == null) {
			return " Produto não encontrado!";
		} else {
		stock.reStock(sku, quantity);
		return " Produto atualizado com sucesso ";
		}
	}

	public String update(String sku, Double buyPrice, Double sellPrice)
			throws ProductNotFoundException, InvalidSellValueException {
		Product product = stock.verifyIfExists(sku);
		if (product == null) {
			return " Produto não encontrado!";
		} else {
		product.setBuyPrice(buyPrice);
		product.setSellPrice(sellPrice);
		stock.validateProfit(product);
		return "Produto atualizado com sucesso ";
		}
	}

}
