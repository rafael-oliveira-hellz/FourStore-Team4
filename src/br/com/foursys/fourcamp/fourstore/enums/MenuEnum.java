package br.com.foursys.fourcamp.fourstore.enums;

public enum MenuEnum {
	SALES(1),
	STOCK(2),
	LOGOUT(0);

	private final Integer option;

	private MenuEnum(Integer option) {
		this.option = option;
	}

	public Integer getOption() {
		return option;
	}
}
