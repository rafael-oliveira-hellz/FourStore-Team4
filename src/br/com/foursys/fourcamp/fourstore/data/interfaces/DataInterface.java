package br.com.foursys.fourcamp.fourstore.data.interfaces;

import java.util.List;

public interface DataInterface {
		
	public void save(Object object);

	public List<?> findAll();
	

}