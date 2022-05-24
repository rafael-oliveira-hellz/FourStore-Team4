package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ColorEnum {

	RED("50", "Vermelho"),
	GREEN("51", "Verde"),
	BLUE("52", "Azul"),
	WHITE("53", "Branco"),
	BLACK("54", "Preto"),
	YELLOW("55", "Amarelo"),
	BROWN("56", "Marrom"),
	GREY("57", "Cinza"),
	PINK("58", "Rosa");

	public String key;
	public String description;

	public String getKey() {
		return key;
	}

	public String getDescription() {
		return description;
	}

	ColorEnum(String key, String description) {
		this.key = key;
		this.description = description;
	}

	private static final Map<String, ColorEnum> Lookup = new HashMap<String, ColorEnum>();

	static {
		for (ColorEnum keyValue : EnumSet.allOf(ColorEnum.class))
			Lookup.put(keyValue.getKey(), keyValue);
	}

	public static ColorEnum get(String key) {
		return Lookup.get(key);
	}

	public static ColorEnum getByDescription(String description) {
		for (ColorEnum keyValue : EnumSet.allOf(ColorEnum.class)) {
			if (keyValue.getDescription().equals(description))
				return keyValue;
		}
		return null;
	}
}
