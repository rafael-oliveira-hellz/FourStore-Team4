package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;
import java.util.List;

import br.com.foursys.fourcamp.fourstore.data.interfaces.DataInterface;

import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Stock;

public class ProductData implements DataInterface {

	public static List<Stock> listProduct = new ArrayList<>();

	@Override
	public void save(Object object) {

		Stock stock = (Stock) object;
		listProduct.add(stock);
		
	}

	public void deleteBySku(String sku) {
		for (int i = 0; i < listProduct.size(); i++) {
			String p = listProduct.get(i).getProduct().getSku();
			if (p.equals(sku)) {
				listProduct.remove(i);
			}
		}
	}

	@Override
	public List<Stock> findAll() {
		return listProduct;
	}

	public Integer getQuantity(String sku) {

		for (int i = 0; i < listProduct.size(); i++) {
			Stock p = listProduct.get(i);
			if (p.getProduct().getSku().equals(sku)) {
				return p.getQuantity();
			}
		}
		return null;

	}

	public Product findBySku(String sku) {
		for (int i = 0; i < listProduct.size(); i++) {
			Stock p = listProduct.get(i);
			if (p.getProduct().getSku().equals(sku)) {
				return p.getProduct();
			}
		}
		return null;
	}

	public void setQuantity(Object object) {
		for (int i = 0; i < listProduct.size(); i++) {
			Stock p = listProduct.get(i);
			Stock stock = (Stock) object;
			String sku = stock.getProduct().getSku();
			Integer newQuantity = stock.getQuantity();
			Integer quantity = p.getQuantity();
			if (p.getProduct().getSku().equals(sku)) {
				p.setQuantity(newQuantity + quantity);
			}
		}

	}

}
