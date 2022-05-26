package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.data.TransactionData;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;
import br.com.foursys.fourcamp.fourstore.exception.StockInsufficientException;
import br.com.foursys.fourcamp.fourstore.model.Transaction;

public class TransactionService {

	private TransactionData transactionData;
	private StockService stockService;

	public TransactionService() {
		this.transactionData = new TransactionData();
		this.stockService = new StockService();
	}

	public String createTransaction(Transaction transaction)
			throws StockInsufficientException, ProductNotFoundException {
		if (stockService.validatePurchase(transaction)) {
			Transaction savedTransaction = setTransaction(transaction);
			return createMessageResponse(savedTransaction.getId(), " criada.");
		}
		
		return "Transação não criada!";
	}

	public List<Transaction> listAll() {
		List<Transaction> allTransactions = transactionData.findAll();
		return allTransactions;
	}

	private String createMessageResponse(Integer id, String s) {
		return "Transação com a ID " + id + s;
	}

	private Transaction setTransaction(Transaction transaction) {
		transactionData.save(transaction);
		return transaction;
	}
}
