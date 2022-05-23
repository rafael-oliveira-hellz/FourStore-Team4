package br.com.foursys.fourcamp.fourstore.data;

import java.util.HashMap;
import java.util.Map.Entry;

import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductData implements ProductDataInterface {

	HashMap<Product, Integer> listProduct = new HashMap<>();

	@Override
	public String save(Product product, Integer quantity) {
		listProduct.put(product, quantity);
		return quantity + " unidades do produto com a Sku" + product.getSku();
	}

	@Override
	public void deleteBySku(String sku) {

		listProduct.forEach((i, j) -> {
			if (i.getSku().equals(sku)) {
				this.listProduct.remove(i);

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
		Product comeback;

		for (Product p : listProduct.keySet()) {
			if (p.getSku().equals(sku)) {
				return p;
			}
		}

		return null;
	}

}
