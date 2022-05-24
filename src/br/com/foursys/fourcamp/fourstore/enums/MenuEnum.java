package br.com.foursys.fourcamp.fourstore.enums;

public enum MenuEnum {
	SALES(1, "Venda"),
	STOCK(2, "Estoque"),
	LOGOUT(0, "Sair");

	private final Integer option;
	private final String description;

	private MenuEnum(Integer option, String description) {
		this.option = option;
		this.description = description;
	}

	public Integer getOption() {
		return option;
	}

	public String getDescription() {
		return description;
	}
}
