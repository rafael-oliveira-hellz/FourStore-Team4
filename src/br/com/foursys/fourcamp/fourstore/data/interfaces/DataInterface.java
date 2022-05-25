package br.com.foursys.fourcamp.fourstore.data.interfaces;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.model.Product;

public interface DataInterface {
		
	public void save(Object object);

	public List<?> findAll();
	

}