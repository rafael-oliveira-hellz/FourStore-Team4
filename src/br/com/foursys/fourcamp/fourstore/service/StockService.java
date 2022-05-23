package br.com.foursys.fourcamp.fourstore.service;

import java.util.HashMap;
import java.util.Map;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;
import br.com.foursys.fourcamp.fourstore.exception.StockInsufficientException;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Transaction;

public class StockService {

	private ProductData productData;

	public StockService(ProductData productData) {
		this.productData = productData;
	}

	public String createProductStock(Product product, Integer quantity) {
		String savedStock = setStock(product, quantity);
		return createMessageResponse(savedStock);
	}

	public HashMap<Product, Integer> listAll() {
		HashMap<Product, Integer> allProductsStocks = productData.findAll();
		return allProductsStocks;
	}

	public String validatePurchase(String sku, Transaction transaction)
			throws StockInsufficientException, ProductNotFoundException {
		return deductFromStock(sku, transaction);
	}

	public String highStockWarning(Product product) {
		Integer quantity = productData.getQuantity(product.getSku());
		if (quantity >= 100) {
			return "Estoque alto: " + quantity + " unidades";
		} else {
			return null;
		}
	}

	public String deductFromStock(String sku, Transaction transaction)
			throws ProductNotFoundException, StockInsufficientException {
		Product product = null;
		try {
			Integer quantity = productData.getQuantity(sku);
			product = productData.findBySku(sku);

			if (product == null) {
				return "Sku não encontrado";
			}
		} catch (Exception e) {
			return "Sku não encontrado";
		}

		checkStock(transaction.getProducts());
		return "a";
	}

	public void reStock(String sku, Integer quantity) {
		Product product = productData.findBySku(sku);
		productData.setQuantity(product, productData.getQuantity(sku) + quantity);
	}

	public void checkStock(HashMap<Product, Integer> products) throws StockInsufficientException {
		products.forEach((i, j) -> {
			String sku = i.getSku();
			Product product = productData.findBySku(sku);
			productData.setQuantity(product, productData.getQuantity(sku) - j);
		});

	}

	private String createMessageResponse(String savedStock) {
		return "Foram adicionadas " + savedStock;
	};

	private String setStock(Product product, Integer quantity) {
		return productData.save(product, quantity);
	}

}
