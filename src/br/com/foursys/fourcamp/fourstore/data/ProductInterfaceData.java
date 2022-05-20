package br.com.foursys.fourcamp.fourstore.data;

import java.util.List;

public interface ProductInterfaceData {
	public void save(Object object);

	public void delete(Object object);

	public List<Object> findAll();

}
