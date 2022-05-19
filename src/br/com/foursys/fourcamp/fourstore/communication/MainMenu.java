package br.com.foursys.fourcamp.fourstore.communication;

import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.enums.MenuEnum;

/**
 * Fazer um menu com submenu para realizar vendar e consultar estoque de uma
 * loja.
 */

public class MainMenu {
	public void acesso() {

		Scanner sc = new Scanner(System.in);

		String login = "Admin";
		String senha = "1234";

		while (true) {
			System.out.println("### FAÇA SEU LOGIN ###");
			System.out.println("----------------------");
			System.out.print("Digite seu login: ");
			String valorLogin = sc.nextLine();
			System.out.print("Digite sua senha: ");
			String valorSenha = sc.nextLine();

			if ((!valorLogin.equalsIgnoreCase("Admin") || (!valorSenha.equals("1234")))) {
				System.out.println("Acesso negado!!!");
			} else {
				menu();
				break;
			}
		}
	}

	boolean verificador = true;

	public void menu() {

		Scanner input = new Scanner(System.in);
		String op = " ";
		while (verificador) {
			System.out.println("\n## MENU PRINCIPAL ##");
			System.out.println("|------------------|");
			for (MenuEnum m : MenuEnum.values()) {
				System.out.println("  " + m.getOpcao() + " - " + m);
			}
			System.out.println("|------------------|");
			System.out.print("Opção: ");
			op = input.nextLine();

			System.out.println();
			if (op.equals("0")) {
				System.out.println("### ENCERRANDO SISTEMA... ATÉ A PRÓXIMA ###");
				System.exit(0);
				input.close();

			} else if (op.equals("1")) {
				menuVenda();

			} else if (op.equals("2")) {
				menuEstoque();

			} else {
				System.err.println("Digite uma opção válida");
				ThreadDelay();
			}
		}
	}

	public void menuVenda() {

	}

	public void menuEstoque() {

		Scanner sc = new Scanner(System.in);
		String opc = " ";

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
			System.out.print("\nOpção: ");
			opc = sc.nextLine();

			if (opc.equals("1")) {
				System.out.println("\nCADASTRAR PRODUTO\n");
			} else if (opc.equals("2")) {
				System.out.println("\nBUSCAR POR SKU\n");
			} else if (opc.equals("3")) {
				System.out.println("\nLISTAR TODO ESTOQUE\n");
			} else if (opc.equals("4")) {
				menu();
			} else if (opc.equals("5")) {
				System.out.println("\n### ENCERRANDO SISTEMA... ATÉ A PRÓXIMA ###");
				System.exit(0);
				break;
			} else {
				System.err.println("\nDigite uma opção válida\n");
				ThreadDelay();
			}
		}

		if (opc.equals("")) {
			verificador = false;
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
