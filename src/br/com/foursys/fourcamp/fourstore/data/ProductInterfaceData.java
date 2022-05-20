package br.com.foursys.fourcamp.fourstore.data;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.model.Product;

public interface ProductInterfaceData {
	
	public Product save(Product product);

	public void deleteBySku(String sku);

	public List<Product> findAll();
	
	public Product findBySku(String sku);
	

}
