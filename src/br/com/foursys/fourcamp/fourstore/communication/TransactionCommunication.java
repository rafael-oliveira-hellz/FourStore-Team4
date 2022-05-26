package br.com.foursys.fourcamp.fourstore.communication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.controller.TransactionController;
import br.com.foursys.fourcamp.fourstore.enums.PaymentMethodEnum;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;
import br.com.foursys.fourcamp.fourstore.exception.StockInsufficientException;
import br.com.foursys.fourcamp.fourstore.model.Stock;

public class TransactionCommunication {
	static Scanner sc = new Scanner(System.in);
	static ProductController productController = new ProductController();
	static TransactionController transactionController = new TransactionController();

	public static void purchase() throws ProductNotFoundException, StockInsufficientException {
		List<Stock> cart = new ArrayList<Stock>();
		String option = "s";

		while (option.equalsIgnoreCase("S")) {
			System.out.print("Digite o SKU do produto: ");
			String sku = sc.nextLine();
			Integer quantity = 0;
			boolean validate = false;

			while (!validate) {
				try {
					System.out.print("Digite a quantidade que deseja comprar: ");
					quantity = Integer.parseInt(sc.nextLine());
					validate = true;
				} catch (Exception e) {
					System.out.println("Quantidade inválida!");
				}
				
				try {
					Stock stock = productController.validatePrePurchase(sku, quantity);
					if (stock != null) {
						cart.add(stock);
						validate = true;
					} else {
						System.out.println("Quantidade insuficiente ou produto não encontrado!");
					}

				} catch (Exception e) {
					System.out.println("Quantidade insuficiente ou produto não encontrado!");
				}
			}
				

			System.out.print("Deseja continuar? S/N ");
			option = sc.nextLine();
		}

		Double totalPrice = 0.0;

		for (Stock stock : cart) {
			System.out.println(stock.toString());
			totalPrice += stock.getProduct().getSellPrice() * stock.getQuantity();
		}

		System.out.println("Preço total: " + totalPrice);

		System.out.println("\nDigite o nome do cliente: ");
		String name = sc.nextLine();

		boolean validate = false;
		String cpf = "";

		while (!validate) {
			System.out.println("\nDeseja inserir o cpf? S/N");
			char choice = sc.nextLine().charAt(0);

			if (choice == 's' || choice == 'S') {
				System.out.print("Digite o CPF: ");
				cpf = sc.nextLine();
				validate = true;
			} else if (choice == 'n' || choice == 'N') {
				validate = true;
			} else {
				System.out.println("Opção inválida!");
			}
		}

		for (PaymentMethodEnum payment : PaymentMethodEnum.values()) {
			System.out.println(payment.getPaymentMethodId() + "  " + payment.getPaymentMethod());
		}

		Integer payment = 0;

		try {
			System.out.print("Escolha um método pelo dígito: ");
			payment = Integer.parseInt(sc.nextLine());
			PaymentMethodEnum.getByPaymentMethodId(payment);
		} catch (Exception e) {
			System.out.println("Opção inválida!");
		}

		if (cpf.equals("")) {
			System.out.println(transactionController.purchase(cart, name, payment));
		} else {
			System.out.println(transactionController.purchase(cart, name, cpf, payment));
		}
	}

	public static void listTransactions() {

	}
}
