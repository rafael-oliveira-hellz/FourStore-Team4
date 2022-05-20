package br.com.foursys.fourcamp.fourstore.enums;

public enum MenuEnum {
	VENDA(1),
	ESTOQUE(2),
	SAIR(0);
	
	private final Integer option;

	private MenuEnum(Integer option) {
		this.option = option;
	}

	public Integer getOption() {
		return option;
	}
}
