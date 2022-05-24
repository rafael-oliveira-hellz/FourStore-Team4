package br.com.foursys.fourcamp.fourstore.service;

import java.util.HashMap;
import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.exception.InvalidSellValueException;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;
import br.com.foursys.fourcamp.fourstore.exception.StockInsufficientException;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Transaction;

public class StockService {

	private ProductData productData;

	public StockService() {
		this.productData = new ProductData();
	}

	public String createProductStock(Product product, Integer quantity) throws InvalidSellValueException {
		validateProfit(product);
        String savedProduct = setProduct(product, quantity);
        return "Adicionadas " + savedProduct;
	}

	public HashMap<Product, Integer> listAll() {
		HashMap<Product, Integer> allProductsStocks = productData.findAll();
		return allProductsStocks;
	}

	public boolean validatePurchase(Transaction transaction)
			throws StockInsufficientException, ProductNotFoundException {
		return deductFromStock(transaction);
	}

	public String highStockWarning(Product product) {
		Integer quantity = productData.getQuantity(product.getSku());
		if (quantity >= 100) {
			return "Estoque alto: " + quantity + " unidades";
		} else {
			return null;
		}
	}
	
	public void deleteBySku(String sku) throws ProductNotFoundException {
        verifyIfExists(sku);
        productData.deleteBySku(sku);
    }
	
	private Product verifyIfExists(String sku) throws ProductNotFoundException {
    	if (productData.findBySku(sku).equals(null)) {
    		throw new ProductNotFoundException(sku);
    	} else {
    		return productData.findBySku(sku);
    	}
    }

	public boolean deductFromStock(Transaction transaction)
			throws ProductNotFoundException, StockInsufficientException {		
		checkStock(transaction.getProducts());
		return true;
	}

	public void reStock(String sku, Integer quantity) {
		Product product = productData.findBySku(sku);
		productData.setQuantity(product, productData.getQuantity(sku) + quantity);
	}

	public void checkStock(HashMap<Product, Integer> products) throws StockInsufficientException {
		products.forEach((requestedProduct, requestedQuantity) -> {
			String sku = requestedProduct.getSku();
			Product product = productData.findBySku(sku);
			productData.setQuantity(product, productData.getQuantity(sku) - requestedQuantity);
		});

	}

	private void validateProfit(Product product) throws InvalidSellValueException {
    	if ((product.getBuyPrice() * 1.25) > product.getSellPrice()) { 
    		throw new InvalidSellValueException();
    	}
    }
	
	private String setProduct(Product product, Integer quantity) {
        return productData.save(product, quantity);
    }
	
	public Product findBySku(String sku) throws ProductNotFoundException {
        Product product = verifyIfExists(sku);
        return product;
    }
}
