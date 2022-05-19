package br.com.foursys.fourcamp.fourstore.communication;

import java.util.Scanner;

/**
 * Fazer um menu com submenu para realizar vendar e consultar estoque de uma
 * loja.
 */

public class MainMenu {
	public void mainMenu() {
		Scanner input = new Scanner(System.in);

		int option = 0;
		boolean validation = true;
		String moveOn;

		do {
			System.out
					.println("1 - Realizar venda \n 2 - Consultar estoque \n 4 - Consultar vendas do dia \n 3 - Sair");
			System.out.print("Digite a opção desejada: ");
			option = input.nextInt();

			switch (option) {
				case 1:
					System.out.println("\nVenda realizada com sucesso!");
					break;
				case 2:
					System.out.println("\nConsulta realizada com sucesso!");
					break;
				case 3:
					System.out.println("\nSaindo...");
					break;
				case 4:
					System.out.println("\nConsulta realizada com sucesso!");
					break;
				default:
					System.out.println("\nOpção inválida!");
					break;
			}

			System.out.println("Deseja continuar? (S/N)");
			moveOn = input.nextLine();
			System.out.println("\n");

			if (moveOn.equalsIgnoreCase("n")) {
				validation = false;
				System.out.println("\n****** Obrigado e volte sempre!!! ******");
			}
		} while (validation);

		input.close();
	}

}
