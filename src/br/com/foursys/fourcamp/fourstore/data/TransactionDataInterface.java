package br.com.foursys.fourcamp.fourstore.data;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.model.Transaction;

public interface TransactionDataInterface {
	
	public Transaction save(Transaction transaction);

	public List<Transaction> findAll();

}
