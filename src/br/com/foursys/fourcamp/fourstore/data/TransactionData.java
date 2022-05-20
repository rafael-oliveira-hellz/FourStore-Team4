package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;
import java.util.List;

public class TransactionData implements DataInterface {
	List<Object> list = new ArrayList<Object>();

	@Override
	public void save(Object transaction) {
		list.add(transaction);
		// TODO Auto-generated method stub

	}

	@Override
	public List<Object> findAll() {

		// TODO Auto-generated method stub
		return list;
	}


}
