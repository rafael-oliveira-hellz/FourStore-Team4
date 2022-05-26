package br.com.foursys.fourcamp.fourstore.communication;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.enums.BrandEnum;
import br.com.foursys.fourcamp.fourstore.enums.CategoryEnum;
import br.com.foursys.fourcamp.fourstore.enums.ColorEnum;
import br.com.foursys.fourcamp.fourstore.enums.DepartmentEnum;
import br.com.foursys.fourcamp.fourstore.enums.MenuEnum;
import br.com.foursys.fourcamp.fourstore.enums.SeasonEnum;
import br.com.foursys.fourcamp.fourstore.enums.SizeEnum;
import br.com.foursys.fourcamp.fourstore.enums.TypeOfMerchandiseEnum;
import br.com.foursys.fourcamp.fourstore.exception.InvalidSellValueException;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;

public class MainMenu {
	
	public void login() throws InvalidSellValueException, ProductNotFoundException {

		Scanner sc = new Scanner(System.in);
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

	boolean validator = true;

	public void menu() throws InvalidSellValueException, ProductNotFoundException {

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

	public void transactionMenu() {

		Scanner input = new Scanner(System.in);

		String sku;
		int quantity;
		int opcao = -2;
		while (true) {
			System.out.println("Digite o sku do produto: ");
			sku = input.next();
			while (true) {
				try {
					System.out.println("Digite a quantidade: ");
					input.nextLine();
					quantity = input.nextInt();

//						ProductController produto = new productController(sku, quantity);
//						 if (produto.validationSell() == true) {
//							System.out.println("Produto adicionado ao carrinho!");
					//
//						} else {
//							System.out.println("Não foi possível adicionar o produto ao carrinho!");
//						}

				} catch (InputMismatchException e) {
					System.err.println("Digite uma das opções!");
					ThreadDelay();
					continue;
				}
				break;
			}

			while (opcao != -1) {
				try {
					System.out.println("Deseja adicionar outro produto?  | 1 - SIM | 0 - NÃO |");
					input.nextLine();
					opcao = input.nextInt();
				} catch (InputMismatchException f) {
					System.err.println("Digite apenas uma das opções!");
					continue;
				}
				if (opcao == 0) {
					opcao = -1;
				} else if (opcao == 1) {
					break;
				} else {
					System.out.println("Digite uma das opções!");
					continue;
				}
			}
			if (opcao == -1) {
				break;
			}
		}

	}

	public void stockMenu() throws InvalidSellValueException, ProductNotFoundException {

		Scanner sc = new Scanner(System.in);
		String option = " ";

		while (true) {
			System.out.println();
			System.out.println("########  MENU ESTOQUE ########");
			System.out.println("+------------------------------+");
			System.out.println("| 1 - CADASTRAR PRODUTO        |");
			System.out.println("| 2 - BUSCAR POR SKU           |");
			System.out.println("| 3 - LISTAR TODO ESTOQUE      |");
			System.out.println("| 4 - ATUALIZAR QUANTIDADE     |");
			System.out.println("| 5 - VOLTAR AO MENU ANTERIOR  |");
			System.out.println("+------------------------------+");
			System.out.println("| 6 - SAIR                     |");
			System.out.println("+------------------------------+");
			System.out.print("\nOpção: ");
			option = sc.nextLine();

			if (option.equals("1")) {

				System.out.println("\nInsira a marca do produto: \n");

				for (BrandEnum brand : BrandEnum.values()) {
					System.out.println(" " + brand.getOption() + " - " + brand.getDescription());
				}

				System.out.print("\nOpção: ");
				String op = sc.next();
				String marca = " ";

				switch (op) {

				case "1": {
					String brand = BrandEnum.KOSAIR.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.KOSAIR.getKey();
					break;
				}
				case "2": {
					String brand = BrandEnum.HERING.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.HERING.getKey();
					break;
				}
				case "3": {
					String brand = BrandEnum.KARL.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.KARL.getKey();
					break;

				}
				case "4": {
					String brand = BrandEnum.MALWEE.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.MALWEE.getKey();
					break;

				}
				case "5": {
					String brand = BrandEnum.CALVINKLEIN.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.CALVINKLEIN.getKey();
					break;
				}

				case "6": {
					String brand = BrandEnum.LACOSTE.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.LACOSTE.getKey();
					break;
				}
				case "7": {
					String brand = BrandEnum.DIESEL.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.DIESEL.getKey();
					break;
				}
				case "8": {
					String brand = BrandEnum.NIKE.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.NIKE.getKey();
					break;
				}
				case "9": {
					String brand = BrandEnum.ADIDAS.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.ADIDAS.getKey();
					break;
				}
				case "10": {
					String brand = BrandEnum.PUMA.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.PUMA.getKey();
					break;
				}
				case "11": {
					String brand = BrandEnum.OLYMPIKUS.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.OLYMPIKUS.getKey();
					break;
				}
				case "12": {
					String brand = BrandEnum.OBOTICARIO.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.OBOTICARIO.getKey();
					break;
				}
				case "13": {
					String brand = BrandEnum.NATURA.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.NATURA.getKey();
					break;
				}
				case "14": {
					String brand = BrandEnum.AVON.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.AVON.getKey();
					break;
				}
				case "15": {
					String brand = BrandEnum.CHANEL5.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.CHANEL5.getKey();
					break;
				}
				case "16": {
					String brand = BrandEnum.ABIPROJECT.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.ABIPROJECT.getKey();
					break;
				}
				case "17": {
					String brand = BrandEnum.BOSS.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.BOSS.getKey();
					break;
				}
				case "18": {
					String brand = BrandEnum.REVAMPP.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.REVAMPP.getKey();
					break;
				}
				case "19": {
					String brand = BrandEnum.NAAU.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.NAAU.getKey();
					break;
				}
				case "20": {
					String brand = BrandEnum.ELEPHANT.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.ELEPHANT.getKey();
					break;
				}
				case "21": {
					String brand = BrandEnum.HIGHERSTORE.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.HIGHERSTORE.getKey();
					break;
				}
				case "22": {
					String brand = BrandEnum.SANTABOUTIQUE.getDescription();
					System.out.println("Marca " + brand);
					marca = BrandEnum.SANTABOUTIQUE.getKey();
					break;

				}
				default: {
					while (true) {
						System.err.println("Digite uma opção válida\n");
						System.out.println("Opção: ");
						op = sc.next();
						if ((op.equals("1")) || (op.equals("2")) || (op.equals("3")) || (op.equals("4"))
						|| (op.equals("5")) || (op.equals("6")) || (op.equals("7")) || (op.equals("8"))									
						|| (op.equals("9")) || (op.equals("10")) || (op.equals("11")) || (op.equals("12"))
						|| (op.equals("13")) || (op.equals("14")) || (op.equals("15")) || (op.equals("16"))
						|| (op.equals("17")) || (op.equals("18")) || (op.equals("19")) || (op.equals("20"))
						|| (op.equals("21")) || (op.equals("22"))) {
							break;
						}
					}
				}

				}

				System.out.println("\nInsira o tamanho do produto: \n");

				for (SizeEnum size : SizeEnum.values()) {
					System.out.println(" " + size.getKey() + " - " + size.getDescription());
				}

				System.out.print("\nOpção: ");
				String size = sc.next();
				String tamanho = " ";
				String tam = " ";

				switch (size) {
				case "10": {
					tam = SizeEnum.RN.getDescription();
					System.out.println("Tamanho: " + tam);
					tamanho = SizeEnum.RN.key;
					break;

				}
				case "32": {
					tam = SizeEnum.PP.getDescription();
					System.out.println("Tamanho: " + tam);
					tamanho = SizeEnum.PP.key;
					break;

				}
				case "35": {
					tam = SizeEnum.P.getDescription();
					System.out.println("Tamanho: " + tam);
					tamanho = SizeEnum.P.key;
					break;

				}
				case "37": {
					tam = SizeEnum.M.getDescription();
					System.out.println("Tamanho: " + tam);
					tamanho = SizeEnum.M.key;
					break;

				}
				case "41": {
					tam = SizeEnum.G.getDescription();
					System.out.println("Tamanho: " + tam);
					tamanho = SizeEnum.G.key;
					break;

				}
				case "43": {
					tam = SizeEnum.GG.getDescription();
					System.out.println("Tamanho: " + tam);
					tamanho = SizeEnum.GG.key;
					break;

				}
				case "45": {
					tam = SizeEnum.XG.getDescription();
					System.out.println("Tamanho: " + tam);
					tamanho = SizeEnum.XG.key;
					break;

				}
				case "48": {
					tam = SizeEnum.XXG.getDescription();
					System.out.println("Tamanho: " + tam);
					tamanho = SizeEnum.XXG.key;
					break;

				}
				case "50": {
					tam = SizeEnum.G1.getDescription();
					System.out.println("Tamanho: " + tam);
					tamanho = SizeEnum.G1.key;
					break;

				}
				case "52": {
					tam = SizeEnum.G2.getDescription();
					System.out.println("Tamanho: " + tam);
					tamanho = SizeEnum.G2.key;
					break;

				}
				case "54": {
					tam = SizeEnum.G3.getDescription();
					System.out.println("Tamanho: " + tam);
					tamanho = SizeEnum.G3.key;
					break;

				}
				default:
					while (true) {
						System.err.println("Digite uma opção válida\n");
						System.out.println("Tamanho: ");
						size = sc.next();
						if ((size.equals("10")) || (size.equals("32")) || (size.equals("35")) || (size.equals("37"))
								|| (size.equals("41")) || (size.equals("43")) || (size.equals("45"))
								|| (size.equals("48")) || (size.equals("50")) || (size.equals("52"))
								|| (size.equals("54"))) {
							break;
						}
					}
				}

				System.out.println("\nInsira a categoria do produto: \n");

				for (CategoryEnum category : CategoryEnum.values()) {
					System.out.println(" " + category.getKey() + " - " + category.getDescription());
				}

				System.out.print("\nOpção: ");
				String category = sc.next();

				switch (category) {

				case "10": {
					String categ = CategoryEnum.MALE.getDescription();
					System.out.println("Categoria: " + categ);
					category = CategoryEnum.MALE.key;
					break;

				}
				case "11": {
					String categ = CategoryEnum.FEMALE.getDescription();
					System.out.println("Categoria: " + categ);
					category = CategoryEnum.FEMALE.key;
					break;

				}
				case "12": {
					String categ = CategoryEnum.BABY.getDescription();
					System.out.println("Categoria: " + categ);
					category = CategoryEnum.BABY.key;
					break;

				}
				default:
					while (true) {
						System.err.println("Digite uma opção válida\n");
						System.out.println("Opção: ");
						category = sc.next();
						if ((category.equals("10") || (category.equals("11")) || category.equals("12"))) {
							break;
						}
					}
				}

				System.out.println("\nInsira a estação do produto: \n");

				for (SeasonEnum season : SeasonEnum.values()) {
					System.out.println(" " + season.getKey() + " - " + season.getDescription());
				}

				System.out.print("\nOpção: ");
				String season = sc.next();

				switch (season) {
				case "40": {

					String estacao = SeasonEnum.SUMMER.getDescription();
					System.out.println("Estação: " + estacao);
					season = SeasonEnum.SUMMER.key;
					break;

				}
				case "41": {

					String estacao = SeasonEnum.WINTER.getDescription();
					System.out.println("Estação: " + estacao);
					season = SeasonEnum.WINTER.key;
					break;

				}
				case "42": {

					String estacao = SeasonEnum.FALL.getDescription();
					System.out.println("Estação: " + estacao);
					season = SeasonEnum.FALL.key;
					break;

				}
				case "43": {

					String estacao = SeasonEnum.SPRING.getDescription();
					System.out.println("Estação: " + estacao);
					season = SeasonEnum.SPRING.key;
					break;
				}
				default:
					while (true) {
						System.err.println("Digite uma opção válida\n");
						System.out.println("Opção: ");
						season = sc.next();
						if ((season.equals("40") || season.equals("41") || season.equals("42"))
								|| (season.equals("43"))) {
							break;
						}
					}
				}

				System.out.println("\nInsira o departamento do produto: \n");

				for (DepartmentEnum department : DepartmentEnum.values()) {
					System.out.println(" " + department.getKey() + " - " + department.getDescription());
				}

				System.out.print("\nOpção: ");
				String department = sc.next();

				switch (department) {
				case "50": {

					String departmento = DepartmentEnum.CLOTHING.getDescription();
					System.out.println("Departamento: " + departmento);
					department = DepartmentEnum.CLOTHING.key;
					break;

				}
				case "51": {

					String departmento = DepartmentEnum.SHOES.getDescription();
					System.out.println("Departamento: " + departmento);
					department = DepartmentEnum.SHOES.key;
					break;

				}
				case "52": {

					String departmento = DepartmentEnum.PERFUMERY.getDescription();
					System.out.println("Departamento: " + departmento);
					department = DepartmentEnum.PERFUMERY.key;
					break;

				}
				case "53": {

					String departmento = DepartmentEnum.ACCESSORIES.getDescription();
					System.out.println("Departamento: " + departmento);
					department = DepartmentEnum.ACCESSORIES.key;
					break;

				}
				default:
					while (true) {
						System.err.println("Digite uma opção válida\n");
						System.out.println("Opção: ");
						season = sc.next();
						if ((department.equals("50") || department.equals("51") || department.equals("52"))
								|| (department.equals("53"))) {
							break;
						}
					}
				}
				
				System.out.println("\nInsira o tipo do produto: \n");

				for (TypeOfMerchandiseEnum type : TypeOfMerchandiseEnum.values()) {
					System.out.println(" " + type.getKey() + " - " + type.getDescription());
				}

				System.out.print("\nOpção: ");
				String type = sc.next();
				
				switch (type) {
				case "231": {
					
					String tipo = TypeOfMerchandiseEnum.PANTS.getDescription();
					System.out.println("Tipo: " + tipo);
					type = TypeOfMerchandiseEnum.PANTS.key;
					break;
					
				} case "232": {
					
					String tipo = TypeOfMerchandiseEnum.TSHIRT.getDescription();
					System.out.println("Tipo: " + tipo);
					type = TypeOfMerchandiseEnum.TSHIRT.key;
					break;
					
				} case "233": {
					
					String tipo = TypeOfMerchandiseEnum.BLOUSE.getDescription();
					System.out.println("Tipo: " + tipo);
					type = TypeOfMerchandiseEnum.BLOUSE.key;
					break;
					
				} case "234": {
					
					String tipo = TypeOfMerchandiseEnum.SHOES.getDescription();
					System.out.println("Tipo: " + tipo);
					type = TypeOfMerchandiseEnum.SHOES.key;
					break;
					
				} case "235": {
					
					String tipo = TypeOfMerchandiseEnum.FLIPFLOPS.getDescription();
					System.out.println("Tipo: " + tipo);
					type = TypeOfMerchandiseEnum.FLIPFLOPS.key;
					break;
					
				} case "236": {
					
					String tipo = TypeOfMerchandiseEnum.INTIMATE.getDescription();
					System.out.println("Tipo: " + tipo);
					type = TypeOfMerchandiseEnum.INTIMATE.key;
					break;
					
				} case "237": {
					
					String tipo = TypeOfMerchandiseEnum.MAKEUP.getDescription();
					System.out.println("Tipo: " + tipo);
					type = TypeOfMerchandiseEnum.MAKEUP.key;
					break;
					
				} case "238": {
					
					String tipo = TypeOfMerchandiseEnum.COSMETICS.getDescription();
					System.out.println("Tipo: " + tipo);
					type = TypeOfMerchandiseEnum.COSMETICS.key;
					break;
					
				} case "239": {
					
					String tipo = TypeOfMerchandiseEnum.SCARF.getDescription();
					System.out.println("Tipo: " + tipo);
					type = TypeOfMerchandiseEnum.SCARF.key;
					break;
					
				} case "240": {
					
					String tipo = TypeOfMerchandiseEnum.TIE.getDescription();
					System.out.println("Tipo: " + tipo);
					type = TypeOfMerchandiseEnum.TIE.key;
					break;
					
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + type);
				}
				
				
				System.out.println("\nInsira a cor do produto: \n");

				for (ColorEnum color : ColorEnum.values()) {
					System.out.println(" " + color.getKey() + " - " + color.getDescription());
				}

				System.out.print("\nOpção: ");
				String color = sc.next();
				
				switch (color) {
				
				case "50": {
					
					String cor = ColorEnum.RED.getDescription();
					System.out.println("Cor: " + cor);
					color = ColorEnum.RED.key;
					break;
					
				} case "51": {
					
					String cor = ColorEnum.GREEN.getDescription();
					System.out.println("Cor: " + cor);
					color = ColorEnum.GREEN.key;
					break;
					
				} case "52": {
					
					String cor = ColorEnum.BLUE.getDescription();
					System.out.println("Cor: " + cor);
					color = ColorEnum.BLUE.key;
					break;
					
				} case "53": {
					
					String cor = ColorEnum.WHITE.getDescription();
					System.out.println("Cor: " + cor);
					color = ColorEnum.WHITE.key;
					break;
					
				} case "54": {
					
					String cor = ColorEnum.BLACK.getDescription();
					System.out.println("Cor: " + cor);
					color = ColorEnum.BLACK.key;
					break;
					
				} case "55": {
					
					String cor = ColorEnum.YELLOW.getDescription();
					System.out.println("Cor: " + cor);
					color = ColorEnum.YELLOW.key;
					break;
					
				} case "56": {
					
					String cor = ColorEnum.BROWN.getDescription();
					System.out.println("Cor: " + cor);
					color = ColorEnum.BROWN.key;
					break;
					
				} case "57": {
					
					String cor = ColorEnum.GREY.getDescription();
					System.out.println("Cor: " + cor);
					color = ColorEnum.GREY.key;
					break;
					
				} case "58": {
					
					String cor = ColorEnum.PINK.getDescription();
					System.out.println("Cor: " + cor);
					color = ColorEnum.PINK.key;
					break;
					
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + color);
				}
				
				Scanner scan = new Scanner(System.in);
				ProductController productController = new ProductController();
				
				String joinSku  = marca + tamanho + category + season + department + type + color;
				
				System.out.print("Insira a descrição do produto: ");
				String desc = scan.next();
				
				System.out.print("Insira a quantidade do produto: ");
				Integer qtt = scan.nextInt();
				
				System.out.print("Insira o preço de compra do produto: ");
				Double priceIn = scan.nextDouble();
				
				System.out.print("Insira o preço de venda do produto: ");
				Double priceOut = scan.nextDouble();
				
				String retorno = productController.insertProduct(joinSku, desc, qtt, priceIn, priceOut);
				
				System.out.println(retorno);
				
			} else if (option.equals("2")) {
				
				System.out.print("\nDigite o SKU do produto: \n");
				String sku = sc.nextLine();
				
				ProductController productController = new ProductController();

				String produtoSku = productController.findSku(sku);
				
				if (!produtoSku.isEmpty()) {
					System.out.println(produtoSku);
				} else {
					System.out.println("Produto não encontrado");
				}
				
				
			} else if (option.equals("3")) {
				System.out.println("\nLISTAR TODO ESTOQUE\n");
				ProductController productController = new ProductController();

				String allProduct = productController.listAll();
				
				System.out.println(allProduct);
				
				
			} else if (option.equals("4")) {
				
				ProductController productController = new ProductController();
				//String regex = 
				
				//System.out.print("Insira o SKU do produto: ");
				
				
				
				// adicionar qtt
				// atualizar preço
				// remover produto

			} else if (option.equals("5")) {
				
				menu();
				break;
				
			} else if (option.equals("6")) {
				System.out.println("\n### ENCERRANDO SISTEMA... ATÉ A PRÓXIMA ###");
				System.exit(0);
				break;
			}else {
				System.err.println("\nDigite uma opção válida\n");
				System.exit(0);
				break;
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
