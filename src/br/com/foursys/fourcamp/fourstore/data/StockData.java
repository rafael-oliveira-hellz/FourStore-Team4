package br.com.foursys.fourcamp.fourstore.data;

import java.util.HashMap;
import java.util.Map;

import br.com.foursys.fourcamp.fourstore.model.Product;

public class StockData implements StockDataInterface {

	HashMap<Product, Integer> stock = new HashMap<>();
	

	@Override
	public String save(Product product, Integer quantity) {
		stock.put(product, quantity);
		return quantity + " unidades do produtoc com a Sku" + product.getSku();
	}

	@Override
	public Map.Entry<Product, Integer> findByProduct(Product product) {
		if(stock.containsKey(product)) {
				return new java.util.AbstractMap.SimpleEntry<Product, Integer>(product, stock.get(product));
			} else { 
				return null;
		}
	}

	@Override
	public HashMap<Product, Integer> findAll() {
		
		return stock;
	}
	
}
