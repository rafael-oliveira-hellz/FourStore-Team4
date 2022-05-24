package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.data.TransactionDataInterface;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;
import br.com.foursys.fourcamp.fourstore.exception.StockInsufficientException;
import br.com.foursys.fourcamp.fourstore.model.Transaction;


public class TransactionService {

	private TransactionDataInterface transactionDataInterface;
	private StockService stockService;

    public TransactionService(TransactionDataInterface transactionDataInterface) {
        this.transactionDataInterface = transactionDataInterface;
    }

    
    public String createTransaction(Transaction transaction) throws StockInsufficientException, ProductNotFoundException {
        stockService.validatePurchase(transaction);
        Transaction savedTransaction = getTransaction(transaction);
        return createMessageResponse(savedTransaction.getId(), " criado ");
    }
    
    public List<Transaction> listAll() {
        List<Transaction> allTransactions = transactionDataInterface.findAll();
        return allTransactions;
    }

    private String createMessageResponse(Integer id, String s) {
        return s + "Transação com a ID " + id;
    }
	
    private Transaction getTransaction(Transaction transaction) {
        return transactionDataInterface.save(transaction);
    }
}




