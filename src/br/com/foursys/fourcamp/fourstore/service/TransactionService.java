package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.data.TransactionDataInterface;
import br.com.foursys.fourcamp.fourstore.model.Transaction;

public class TransactionService {

	private TransactionDataInterface transactionDataInterface;

    public TransactionService(TransactionDataInterface transactionDataInterface) {
        this.transactionDataInterface = transactionDataInterface;
    }

    /*
    vai ter id ou não?
    public String createTransaction(Transaction Transaction) {
        Transaction savedTransaction = getTransaction(Transaction);
        return createMessageResponse(savedTransaction.getId(), " criado ");
    }
    */

    public List<Transaction> listAll() {
        List<Transaction> allTransactions = transactionDataInterface.findAll();
        return allTransactions;
    }

    private String createMessageResponse(Long id, String s) {
        return s + "Transação com a ID " + id;
    }
	
    
    private Transaction getTransaction(Transaction transaction) {
        return transactionDataInterface.save(transaction);
    }
}




