package br.com.foursys.fourcamp.fourstore.communication;

import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.enums.BrandEnum;
import br.com.foursys.fourcamp.fourstore.enums.CategoryEnum;
import br.com.foursys.fourcamp.fourstore.enums.ColorEnum;
import br.com.foursys.fourcamp.fourstore.enums.DepartmentEnum;
import br.com.foursys.fourcamp.fourstore.enums.SeasonEnum;
import br.com.foursys.fourcamp.fourstore.enums.SizeEnum;
import br.com.foursys.fourcamp.fourstore.enums.TypeOfMerchandiseEnum;
import br.com.foursys.fourcamp.fourstore.exception.InvalidSellValueException;

public class StockMenuCommunication {
	static ProductController productController = new ProductController();
	static Scanner sc = new Scanner(System.in);

	public static void createProduct() throws InvalidSellValueException {
		String sku = "";
		String optionString = "";
		Integer option;
		boolean validate = false;

		while (!validate) {
			System.out.println("\nMarcas\n");

			for (BrandEnum brands : BrandEnum.values()) {
				System.out.println(brands.getOption() + " " + brands.getDescription());
			}

			try {
				System.out.print("Escolha o dígito de uma marca: ");
				option = sc.nextInt();

				optionString = BrandEnum.getByOption(option).getKey();

				validate = true;
			} catch (Exception e) {
				System.out.println("Opção inválida");
				continue;
			}
		}

		sku += optionString;
		validate = false;

		while (!validate) {
			System.out.println("\nTamanho\n");

			for (SizeEnum sizes : SizeEnum.values()) {
				System.out.println(sizes.getKey() + "  " + sizes.getDescription());
			}

			try {
				System.out.print("Escolha o dígito de um tamanho: ");
				option = sc.nextInt();

				optionString = SizeEnum.get(option.toString()).getKey();

				validate = true;
			} catch (Exception e) {
				System.out.println("Opção inválida");
				continue;
			}
		}

		sku += optionString;
		validate = false;

		while (!validate) {
			System.out.println("\nCategoria\n");

			for (CategoryEnum categories : CategoryEnum.values()) {
				System.out.println(categories.getKey() + "  " + categories.getDescription());
			}

			try {
				System.out.print("Escolha o dígito de uma categoria: ");
				option = sc.nextInt();

				optionString = CategoryEnum.get(option.toString()).getKey();

				validate = true;
			} catch (Exception e) {
				System.out.println("Opção inválida");
				continue;
			}
		}

		sku += optionString;
		validate = false;

		while (!validate) {
			System.out.println("\nEstação\n");

			for (SeasonEnum seasons : SeasonEnum.values()) {
				System.out.println(seasons.getKey() + "  " + seasons.getDescription());
			}

			try {
				System.out.print("Escolha o dígito de uma estação: ");
				option = sc.nextInt();

				optionString = SeasonEnum.get(option.toString()).getKey();

				validate = true;
			} catch (Exception e) {
				System.out.println("Opção inválida");
				continue;
			}
		}

		sku += optionString;
		validate = false;

		while (!validate) {
			System.out.println("\nDepartamento\n");

			for (DepartmentEnum departments : DepartmentEnum.values()) {
				System.out.println(departments.getKey() + "  " + departments.getDescription());
			}

			try {
				System.out.print("Escolha o dígito de um departamento: ");
				option = sc.nextInt();

				optionString = DepartmentEnum.get(option.toString()).getKey();

				validate = true;
			} catch (Exception e) {
				System.out.println("Opção inválida");
				continue;
			}
		}

		sku += optionString;
		validate = false;

		while (!validate) {
			System.out.println("\nTipo\n");

			for (TypeOfMerchandiseEnum types : TypeOfMerchandiseEnum.values()) {
				System.out.println(types.getKey() + "  " + types.getDescription());
			}

			try {
				System.out.print("Escolha o dígito de um tipo: ");
				option = sc.nextInt();

				optionString = TypeOfMerchandiseEnum.get(option.toString()).getKey();

				validate = true;
			} catch (Exception e) {
				System.out.println("Opção inválida");
				continue;
			}
		}

		sku += optionString;
		validate = false;

		while (!validate) {
			System.out.println("\nCor\n");

			for (ColorEnum types : ColorEnum.values()) {
				System.out.println(types.getKey() + "  " + types.getDescription());
			}

			try {
				System.out.print("Escolha o dígito de uma cor: ");
				option = sc.nextInt();

				optionString = ColorEnum.get(option.toString()).getKey();

				validate = true;
			} catch (Exception e) {
				System.out.println("Opção inválida");
				continue;
			}
		}

		sku += optionString;

		validate = false;
		Integer quantity = 0;

		while (!validate) {
			try {
				System.out.print("Digite a quantidade a ser adicionada: ");
				quantity = sc.nextInt();
				validate = true;
			} catch (Exception e) {
				System.out.println("Quantidade inválida");
				continue;
			}
		}
		
		System.out.print("\nDigite a descrição: ");
		sc.nextLine();
		String description = sc.nextLine();
		
		validate = false;
		double buyPrice = 0.0;
		double sellPrice = 0.0;
		
		while (!validate) {
			try {
				System.out.print("\nDigite o preço de compra: ");
				buyPrice = sc.nextDouble();
				
				System.out.print("\nDigite o preço de venda: ");
				sellPrice = sc.nextDouble();
				
				validate = true;
			} catch (Exception e) {
				System.out.println("Preços inválidos");
				continue;
			}
		}

		System.out.println(productController.insertProduct(sku, description, quantity, buyPrice, sellPrice));
	}

	public static void searchForSku() {

	}

	public static void listAllStock() {

	}

	public static void updateProduct() {

	}
}
