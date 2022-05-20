package br.com.foursys.fourcamp.fourstore.data;

import java.util.List;

public interface DataInterface {
	public void save(Object object);

	public List<Object> findAll();

}
