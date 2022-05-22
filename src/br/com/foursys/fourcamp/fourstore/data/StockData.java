package br.com.foursys.fourcamp.fourstore.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Stock;

public class StockData implements StockDataInterface {

	HashMap<Product, Integer> stock = new HashMap<>();
	

	@Override
	public String save(Product product, Integer quantity) {
		stock.put(product, quantity);
		return quantity + " unidades do produtoc com a Sku" + product.getSku();
	}

	

	@Override
	public Map.Entry<Product, Integer> findByProduct(Product product) {
		for (Product currentProduct : stock.keySet()) {
			if (product.getSku().equals(stock.get(currentProduct.getSku()))) {
				return new java.util.AbstractMap.SimpleEntry<Product, Integer>(currentProduct, stock.get(currentProduct));
			}
		}
		return null;
	}

	@Override
	public HashMap<Product, Integer> findAll() {
		
		return stock;
	}
	
}
