package br.com.foursys.fourcamp.fourstore.service;

import java.util.HashMap;
import java.util.Map;

import br.com.foursys.fourcamp.fourstore.data.StockDataInterface;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;
import br.com.foursys.fourcamp.fourstore.exception.StockInsufficientException;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Transaction;

public class StockService {
	
	private StockDataInterface stockDataInterface;

    public StockService(StockDataInterface stockDataInterface) {
        this.stockDataInterface = stockDataInterface;
    }
    
    public String createProductStock(Product product, Integer quantity) {
        String savedStock = getStock(product, quantity);
        return createMessageResponse(savedStock);
    }
    
    public HashMap<Product, Integer> listAll() {
        HashMap<Product, Integer> allProductsStocks = stockDataInterface.findAll();
        return allProductsStocks;
    }
    
	public void validatePurchase (HashMap<Product, Integer> stock, Transaction transaction) throws StockInsufficientException, 
		ProductNotFoundException {
		deductFromStock(stock, transaction);    	
	} 
	
	public String lowStockWarning (Map.Entry<Product, Integer> products) {
		if (stockDataInterface.findByProduct(products.getKey()).getValue() < 50) {
			return "Estoque baixo, favor repor imediatamente!";
		} else {
			return null;
		}
	}
			
	public String highStockWarning (Map.Entry<Product, Integer> products) {
		Integer quantity = stockDataInterface.findByProduct(products.getKey()).getValue();
		if (quantity >= 100) {
			return "Estoque alto: " + quantity + " unidades";
		} else {
			return null;
		}
	}
		
	public void deductFromStock(HashMap<Product, Integer> stock, Transaction transaction) throws ProductNotFoundException, 
		StockInsufficientException {
		for (Map.Entry<Product, Integer> products : transaction.getProducts().entrySet()) {
			if (!stock.containsKey(products.getKey())) {
	    		throw new ProductNotFoundException(products.getKey().getSku());
	    	} else  {
	    		checkStock(stock, products);
	    	}
		}
	}
	
	public String reStock(HashMap<Product, Integer> stock, Map.Entry<Product, Integer> products)  {
		if (stock.containsKey(products.getKey())) {
			stock.put(products.getKey(), stock.get(products.getKey()) + products.getValue());
			highStockWarning(products);
			return "Estoque de " + products.getKey() + " abastecido!";
		} else {
			return "Estoque de " + products.getKey() + " criado!";
		}
	} 

	public void checkStock(HashMap<Product, Integer> stock, Map.Entry<Product, Integer> products) throws StockInsufficientException {
		if (stockDataInterface.findByProduct(products.getKey()).getValue() < products.getValue()) {
			throw new StockInsufficientException();
		} else {
			stock.put(products.getKey(), stock.get(products.getKey()) - products.getValue());
			lowStockWarning(products);
		}
	} 
	
	private String createMessageResponse(String savedStock) {
		return "Foram adicionadas " + savedStock;
	};
	
	private String getStock(Product product, Integer quantity) {
        return stockDataInterface.save(product, quantity);
    }
	
	
	}

