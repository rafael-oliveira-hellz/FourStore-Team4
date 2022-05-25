package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;
import java.util.List;

import br.com.foursys.fourcamp.fourstore.data.interfaces.DataInterface;
import br.com.foursys.fourcamp.fourstore.model.Transaction;

public class TransactionData implements DataInterface {

	public static List<Transaction> list = new ArrayList<Transaction>();

	@Override
	public void save(Object transaction) {
		list.add((Transaction)transaction);
	}

	@Override
	public List<Transaction> findAll() {
		return list;
	}

}
