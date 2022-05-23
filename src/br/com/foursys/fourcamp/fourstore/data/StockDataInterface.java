package br.com.foursys.fourcamp.fourstore.data;

import java.util.HashMap;
import java.util.Map.Entry;

import br.com.foursys.fourcamp.fourstore.model.Product;

public interface StockDataInterface {

	public String save(Product product, Integer quantity);

	public HashMap<Product, Integer> findAll();
	
	public Entry<Product, Integer> findByProduct(Product product);
	
}
