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
import br.com.foursys.fourcamp.fourstore.utils.RunTime;

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

		if (totalPrice == 0.0) {
			return;
		}

		System.out.println("Preço total: " + totalPrice);

		System.out.print("\nDigite o nome do cliente: ");
		String name = sc.nextLine();

		boolean validate = false;
		String cpf = "";

		while (!validate) {
			System.out.print("\nDeseja inserir o cpf? S/N ");
			char choice = sc.nextLine().charAt(0);

			if (choice == 's' || choice == 'S') {
				while (!validate) {
					System.out.print("Digite o CPF: ");
					cpf = sc.nextLine();
					if (cpf.length() == 11) {
						validate = true;
					} else {
						System.err.println("O cpf deve ter 11 números!");
						RunTime.ThreadDelay();
					}
				}
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
		String paymentData = null;

		validate = false;

		while (!validate) {
			try {
				System.out.print("Escolha um método pelo dígito: ");
				payment = Integer.parseInt(sc.nextLine());
				
				paymentData = checkPayment(payment);
				if (paymentData == null || paymentData.equals("")) {
					paymentData = PaymentMethodEnum.getByPaymentMethodId(payment).getPaymentMethod();
				}
				validate = true;
			} catch (Exception e) {
				System.out.println("Opção inválida!");
				validate = false;
			}
		}

		if (cpf.equals("")) {
			System.out.println(transactionController.purchase(cart, name, payment, paymentData));
		} else {
			System.out.println(transactionController.purchase(cart, name, cpf, payment, paymentData));
		}
	}

	public static void listTransactions() {
		System.out.println(transactionController.listAll());
	}

	public static String checkPayment(Integer option) {
		String data = null;
		String temp;
		Integer cardNumber;
		boolean validator = false;

		switch (option) {
		case 3:
			while (!validator) {
				try {
					System.out.print("Digite o numero do cartão");
					data = "Crédito\n" + "Número do cartão: ";
					temp = sc.nextLine();

					if (temp.length() == 12 && temp.matches("[0-9]+")) {
						data += temp + "\nCód. de Segurança: ";

						System.out.print("Digite o código de segurança: ");
						temp = sc.nextLine();

						if (temp.length() != 3) {
							System.err.println("Número do código de segurança inválido! Precisa ter 3 digitos");
						} else {
							cardNumber = Integer.parseInt(temp);
							data += cardNumber + "\nVencimento: ";

							System.out.print("Digite a data de validade: MM:AA");
							temp = sc.nextLine();

							if (temp.substring(2, 3).equals("/") && temp.length() == 5) {
								String[] date = temp.split("/");
								Integer.parseInt(date[0]);
								Integer.parseInt(date[1]);

								data += temp;
								validator = true;
								return data;
							}
						}
					} else {
						System.err.println("Número do cartão inválido! Precisa ter 12 digitos");
					}
				} catch (Exception e) {
					System.err.println("Entrada inválida");
				}
			}
			break;
		case 4:
			while (!validator) {
				try {
					System.out.print("Digite o numero do cartão");
					data = "Débito\n" + "Número do cartão: ";
					temp = sc.nextLine();

					if (temp.length() != 12) {
						System.err.println("Número do cartão inválido! Precisa ter 12 digitos");
					} else {
						cardNumber = Integer.parseInt(temp);
						data += cardNumber + "\nCód. de Segurança: ";

						System.out.print("Digite o código de segurança: ");
						temp = sc.nextLine();

						if (temp.length() != 3) {
							System.err.println("Número do código de segurança inválido! Precisa ter 3 digitos");
						} else {
							cardNumber = Integer.parseInt(temp);
							data += cardNumber + "\nVencimento: ";

							System.out.print("Digite a data de validade: MM:AA");
							temp = sc.nextLine();

							if (temp.substring(2, 3).equals("/") && temp.length() == 5) {
								String[] date = temp.split("/");
								Integer.parseInt(date[0]);
								Integer.parseInt(date[1]);

								data += temp;
								validator = true;
								return data;
							}
						}
					}
				} catch (Exception e) {
					System.err.println("Entrada inválida");
				}
			}
			break;
		case 5:

			while (!validator) {
				System.out.print("Digite sua chave pix: ");
				temp = sc.nextLine();

				if (temp != "") {
					data = "Pix\nChave: " + temp;
					validator = true;
					return data;
				} else {
					System.err.println("Chave Inválida");
				}
			}
			break;
		case default:
			return data;
		}
		return data;
	}
}
