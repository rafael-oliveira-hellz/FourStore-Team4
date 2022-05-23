package br.com.foursys.fourcamp.fourstore.data;

import java.util.HashMap;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductData implements ProductDataInterface {

	public static HashMap<Product, Integer> listProduct = new HashMap<>();

	@Override
	public String save(Product product, Integer quantity) {
		listProduct.put(product, quantity);
		return quantity + " unidades do produto com a Sku" + product.getSku();
	}

	@Override
	public void deleteBySku(String sku) {
		listProduct.forEach((product, quantity) -> {
			if (product.getSku().equals(sku)) {
				ProductData.listProduct.remove(product);
			}
		});

	}

	@Override
	public HashMap<Product, Integer> findAll() {
		return listProduct;
	}

	@Override
	public Integer getQuantity(String sku) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findBySku(String sku) {
		for (Product product : listProduct.keySet()) {
			if (product.getSku().equals(sku)) {
				return product;
			}
		}
		return null;
	}

	@Override
	public void setQuantity(Product product, Integer quantity) {
		listProduct.put(product, quantity);
	}

}
