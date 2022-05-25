package br.com.foursys.fourcamp.fourstore.service;

import java.util.HashMap;
import java.util.List;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.exception.InvalidSellValueException;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;
import br.com.foursys.fourcamp.fourstore.exception.StockInsufficientException;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Stock;
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

	public List<Stock> listAll() {
		List<Stock> allProductsStocks = productData.findAll();
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
		Stock stock = new Stock(product, productData.getQuantity(sku) + quantity);
		productData.setQuantity(stock);
	}

	public void checkStock(HashMap<Product, Integer> products) throws StockInsufficientException {
		products.forEach((requestedProduct, requestedQuantity) -> {
			String sku = requestedProduct.getSku();
			Product product = productData.findBySku(sku);
			Stock stock = new Stock(product, productData.getQuantity(sku) - requestedQuantity);
			productData.setQuantity(stock);
		});

	}

	//Boolean ou Exception?
	public Boolean validateIndividualPurchase(Product product, Integer quantity) {
		List<Stock> products = productData.findAll();
		boolean contains = false;
		int x = 0;
		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i).getProduct();
			if (p.equals(product)) {
				contains = true;
				x = i;
			}
		}
		if (!contains || products.get(x).getQuantity() < quantity) {
			return false;
		} else {
			return true;
		}
	}

	public void validateProfit(Product product) throws InvalidSellValueException {
    	if ((product.getBuyPrice() * 1.25) > product.getSellPrice()) { 
    		throw new InvalidSellValueException();
    	}
    }
	
	private String setProduct(Product product, Integer quantity) {
		Stock stock = new Stock(product, quantity);
        productData.save(stock);
        return quantity + " unidades adicionadas com sucesso!";
    }
	
	public Product findBySku(String sku) throws ProductNotFoundException {
        Product product = verifyIfExists(sku);
        return product;
    }
}
