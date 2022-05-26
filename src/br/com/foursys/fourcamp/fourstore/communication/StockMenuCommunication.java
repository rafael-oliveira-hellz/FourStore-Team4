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
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;

public class StockMenuCommunication {
	static ProductController productController = new ProductController();
	static Scanner sc = new Scanner(System.in);

	public static void createProduct() throws InvalidSellValueException {
		String sku = "";
		String optionString = "";
		Integer firstOption;
		String option;
		boolean validate = false;

		while (!validate) {
			System.out.println("\nMarcas\n");

			for (BrandEnum brands : BrandEnum.values()) {
				System.out.println(brands.getOption() + " " + brands.getDescription());
			}

			try {
				sc.nextLine();
				System.out.print("Escolha o dígito de uma marca: ");
				firstOption = sc.nextInt();

				optionString = BrandEnum.getByOption(firstOption).getKey();

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
				sc.nextLine();
				option = sc.nextLine();

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
				option = sc.nextLine();

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
				option = sc.nextLine();

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
				option = sc.nextLine();

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
				option = sc.nextLine();

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
				option = sc.nextLine();

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
				quantity = Integer.parseInt(sc.nextLine());
				validate = true;
			} catch (Exception e) {
				System.out.println("Quantidade inválida");
				continue;
			}
		}
		
		System.out.print("\nDigite a descrição: ");
		String description = sc.nextLine();
		
		validate = false;
		double buyPrice = 0.0;
		double sellPrice = 0.0;
		
		while (!validate) {
			try {
				System.out.print("\nDigite o preço de compra: ");
				buyPrice = Double.parseDouble(sc.nextLine());
				
				System.out.print("\nDigite o preço de venda: ");
				sellPrice = Double.parseDouble(sc.nextLine());
				
				validate = true;
			} catch (Exception e) {
				System.out.println("Preços inválidos");
				continue;
			}
		}
		System.out.println(sku);
		System.out.println(productController.insertProduct(sku, description, quantity, buyPrice, sellPrice));
	}

	public static void searchForSku() throws ProductNotFoundException {
		System.out.println("Informe o SKU do produto: ");
		String sku = sc.next();
		System.out.println(productController.findSku(sku));
	}

	public static void listAllStock() {
		System.out.println( productController.listAll());
		
	}

	public static void updateProduct() {
		
	}
}
