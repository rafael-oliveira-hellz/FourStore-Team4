package br.com.foursys.fourcamp.fourstore.data;

import java.util.HashMap;
import br.com.foursys.fourcamp.fourstore.model.Product;

public interface ProductDataInterface {
		
	public String save(Product product, Integer quantity);

	public HashMap<Product, Integer> findAll();
	
	public Integer getQuantity(String sku);

	public void deleteBySku(String sku);
	
	public Product findBySku(String sku);
	
	public void setQuantity(Product product, Integer quantity);

}