package br.com.foursys.fourcamp.fourstore.controller;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;
import br.com.foursys.fourcamp.fourstore.exception.StockInsufficientException;
import br.com.foursys.fourcamp.fourstore.model.Costumer;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Stock;
import br.com.foursys.fourcamp.fourstore.model.Transaction;
import br.com.foursys.fourcamp.fourstore.service.TransactionService;

public class TransactionController {

	private TransactionService transactionService;

	public TransactionController() {
		this.transactionService = new TransactionService();
	}

	public String purchase(List<Stock> list, String name, Integer payment) throws StockInsufficientException, ProductNotFoundException {
		Costumer costumer = new Costumer(name, payment);
		Transaction transaction = new Transaction(costumer);
		for (int x = 0; x < list.size(); x++) {
			Product product = list.get(x).getProduct();
			Integer quantity = list.get(x).getQuantity();
			transaction.addProducts(product, quantity);
		}
		Double totalPrice = transaction.getTotalPrice();
		String txt = transactionService.createTransaction(transaction);
		txt += "Compra realizada com sucesso!\nValor total: "+ totalPrice;
		return txt;
	}

	public String purchase(List<Stock> list, String name, String cpf, Integer payment) {
		return null;
	}

}
