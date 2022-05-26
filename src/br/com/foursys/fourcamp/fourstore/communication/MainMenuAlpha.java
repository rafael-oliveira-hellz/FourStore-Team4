package br.com.foursys.fourcamp.fourstore.communication;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.enums.BrandEnum;
import br.com.foursys.fourcamp.fourstore.enums.MenuEnum;
import br.com.foursys.fourcamp.fourstore.exception.InvalidSellValueException;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;

public class MainMenuAlpha {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InvalidSellValueException, ProductNotFoundException {
		new MainMenuAlpha();

	}

	public MainMenuAlpha() throws InvalidSellValueException, ProductNotFoundException {
		{
			String mockUser = "Admin";
			String mockPassword = "********";

			while (true) {
				System.out.println("### FAÇA SEU LOGIN ###");
				System.out.println("----------------------");
				System.out.print("Digite seu login: ");
				String user = sc.nextLine();
				System.out.print("Digite sua senha: ");
				String password = sc.nextLine();

				if ((!user.equals(mockUser) || (!password.equals(mockPassword)))) {
					System.out.println("Acesso negado!!!");
				} else {
					menu();
					break;
				}
			}
		}
	}

	public void menu() throws InvalidSellValueException, ProductNotFoundException {
		boolean validator = true;
		Scanner input = new Scanner(System.in);
		String option = " ";
		while (validator) {
			System.out.println("\n## MENU PRINCIPAL ##");
			System.out.println("|------------------|");
			for (MenuEnum navigation : MenuEnum.values()) {
				System.out.println("  " + navigation.getOption() + " - " + navigation.getDescription());
			}
			System.out.println("|------------------|");

			System.out.print("Opção: ");

			option = input.nextLine();

			System.out.println();
			if (option.equals("0")) {

				System.out.println("### ENCERRANDO SISTEMA... ATÉ A PROXIMA ###");
				System.exit(0);
				input.close();

			} else if (option.equals("1")) {
				transactionMenu();

			} else if (option.equals("2")) {
				stockMenu();

			} else {
				System.err.println("Digite uma opção válida");
				ThreadDelay();
			}
		}
	}

	public void ThreadDelay() {
		try {
			Thread.sleep(1L);
		} catch (InterruptedException e) {
			System.out.println("Nunca vai cair aqui");
		}
	}

	private void stockMenu() throws InvalidSellValueException {
		Integer option;
		boolean validate = false;

		while (!validate) {
			System.out.println();
			System.out.println("########  MENU ESTOQUE ########");
			System.out.println("+------------------------------+");
			System.out.println("| 1 - CADASTRAR PRODUTO        |");
			System.out.println("| 2 - BUSCAR POR SKU           |");
			System.out.println("| 3 - LISTAR TODO ESTOQUE      |");
			System.out.println("| 4 - ATUALIZAR PRODUTO        |");
			System.out.println("| 5 - VOLTAR AO MENU ANTERIOR  |");
			System.out.println("+------------------------------+");
			System.out.println("| 6 - SAIR                     |");
			System.out.println("+------------------------------+");
			System.out.print("\nOpção: ");

			try {
				option = sc.nextInt();
				switch (option) {
				case 1:
					StockMenuCommunication.createProduct();
					break;
				case 2:
					StockMenuCommunication.searchForSku();
					break;
				case 3:
					StockMenuCommunication.listAllStock();
					break;
				case 4:
					StockMenuCommunication.updateProduct();
					break;
				case 5:
					break;
				case 6:
					System.out.println("### ENCERRANDO SISTEMA... ATÉ A PROXIMA ###");
					System.exit(0);
					break;
				case default:
					System.out.println("Opção inválida!");
					break;
				}

				validate = true;
			} catch (InputMismatchException e) {
				validate = false;
			}

		}

	}

	private void transactionMenu() {
		Integer option;
		boolean validate = false;

		while (!validate) {
			System.out.println();
			System.out.println("########  MENU VENDAS ########");
			System.out.println("+------------------------------+");
			System.out.println("| 1 - REALIZAR COMPRAS         |");
			System.out.println("| 2 - HISTÓRICO DE COMPRAS     |");
			System.out.println("| 3 - VOLTAR AO MENU ANTERIOR  |");
			System.out.println("+------------------------------+");
			System.out.println("| 4 - SAIR                     |");
			System.out.println("+------------------------------+");
			System.out.print("\nOpção: ");

			try {
				option = sc.nextInt();
				switch (option) {
				case 1:
					TransactionCommunication.purchase();
					break;
				case 2:
					TransactionCommunication.listTransactions();;
					break;
				case 3:
					break;
				case 4:
					System.out.println("### ENCERRANDO SISTEMA... ATÉ A PROXIMA ###");
					System.exit(0);
					break;
				case default:
					System.out.println("Opção inválida!");
					break;
				}

				validate = true;
			} catch (InputMismatchException e) {
				validate = false;
			}
		}

	}
}
