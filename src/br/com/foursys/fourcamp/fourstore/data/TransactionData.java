package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;
import java.util.List;

import br.com.foursys.fourcamp.fourstore.model.Transaction;

public class TransactionData implements TransactionDataInterface {
	
	public static List<Transaction> list = new ArrayList<Transaction>();

	@Override
	public Transaction save(Transaction transaction) {
		list.add(transaction);
		return transaction;
	}

	@Override
	public List<Transaction> findAll() {
		return list;
	}


}
