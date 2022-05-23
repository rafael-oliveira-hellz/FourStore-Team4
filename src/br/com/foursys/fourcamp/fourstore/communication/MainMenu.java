package br.com.foursys.fourcamp.fourstore.communication;

import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.enums.MenuEnum;

public class MainMenu {
	public void login() {

		Scanner sc = new Scanner(System.in);
		{
			String mockUser = "Admin";
			String mockPassword = "1234";

			while (true) {
				System.out.println("### FA�A SEU LOGIN ###");
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

	boolean validator = true;

	public void menu() {

		Scanner input = new Scanner(System.in);
		String option = " ";
		while (validator) {
			System.out.println("\n## MENU PRINCIPAL ##");
			System.out.println("|------------------|");
			for (MenuEnum navigation : MenuEnum.values()) {
				System.out.println("  " + navigation.getOption() + " - " + navigation);
			}
			System.out.println("|------------------|");
			System.out.print("Opção: ");
			option = input.nextLine();

			System.out.println();
			if (option.equals("0")) {
				System.out.println("### ENCERRANDO SISTEMA... ATÉ A PRÓXIMA ###");
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

	public void transactionMenu() {

	}

	public void stockMenu() {

		Scanner sc = new Scanner(System.in);
		String option = " ";

		while (true) {

			System.out.println("########  MENU ESTOQUE ########");
			System.out.println("+------------------------------+");
			System.out.println("| 1 - CADASTRAR PRODUTO        |");
			System.out.println("| 2 - BUSCAR POR SKU           |");
			System.out.println("| 3 - LISTAR TODO ESTOQUE      |");
			System.out.println("| 4 - VOLTAR AO MENU ANTERIOR  |");
			System.out.println("+------------------------------+");
			System.out.println("| 5 - SAIR                     |");
			System.out.println("+------------------------------+");
			System.out.print("\nOp��o: ");
			option = sc.nextLine();

			if (option.equals("1")) {
				System.out.println("\nCADASTRAR PRODUTO\n");
			} else if (option.equals("2")) {
				System.out.println("\nBUSCAR POR SKU\n");
			} else if (option.equals("3")) {
				System.out.println("\nLISTAR TODO ESTOQUE\n");
			} else if (option.equals("4")) {
				menu();
			} else if (option.equals("5")) {
				System.out.println("\n### ENCERRANDO SISTEMA... ATÉ A PRÓXIMA ###");
				System.exit(0);
				break;
			} else {
				System.err.println("\nDigite uma op��o válida\n");
				ThreadDelay();
			}
		}

		if (option.equals("")) {
			validator = false;
		}
	}

	public void ThreadDelay() {
		try {
			Thread.sleep(1L);
		} catch (InterruptedException e) {
			System.out.println("Nunca vai cair aqui");
		}
	}
}
