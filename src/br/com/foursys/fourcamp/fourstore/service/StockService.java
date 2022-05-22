package br.com.foursys.fourcamp.fourstore.service;

import java.util.HashMap;
import java.util.List;

import br.com.foursys.fourcamp.fourstore.data.StockDataInterface;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;
import br.com.foursys.fourcamp.fourstore.exception.StockInsufficientException;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Stock;
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
    
    /*
	public void validatePurchase (HashMap<Product, Integer> stock, Transaction transaction) throws StockInsufficientException {
		if (quantity of any products of transaction > quantity of same product in stock ) {
    		throw new StockInsufficientException();
    	} else {
    		//for each product
    		deductFromStock(product, stock, quantidadeVendida);
    		lowStockWarning(product, stock);
    		highStockWarning(product, stock);
    	}
	} 
	
	public String lowStockWarning (Product product, Stock stock) {
		if (stock.getQuantity() < 50) {
			return "Estoque baixo, favor repor imediatamente!";
		}
		}
		
	public String highStockWarning (Product product, Stock stock) {
		if (stock.getQuantity() > 100) {
			return "Estoque cheio, operação negada!";
			}
		} 
	
	public void deductFromStock(HashMap<Product, Integer> stock, Transaction transaction) throws ProductNotFoundException {
		if (stockDataInterface.findByProduct(product).equals(null)) {
    		throw new ProductNotFoundException(product.getSku());
    	} else {
    		stock.put(product, stock.get(product) - quantidadeVendida);
    	}	
	} */
	
	private String createMessageResponse(String savedStock) {
		return "Foram adicionadas " + savedStock;
	};
	
	private String getStock(Product product, Integer quantity) {
        return stockDataInterface.save(product, quantity);
    }
	
	
	}

