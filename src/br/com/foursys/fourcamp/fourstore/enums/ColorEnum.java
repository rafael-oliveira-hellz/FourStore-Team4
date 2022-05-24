package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ColorEnum {

	RED("50"),
	GREEN("51"),
	BLUE("52"),
	WHITE("53"),
	BLACK("54"),
	YELLOW("55"),
	BROWN("56"),
	GREY("57"),
	PINK("58");

	public String key;

	public String getKey() {
		return key;
	}

	ColorEnum(String key) {
		this.key = key;
	}

	private static final Map<String, ColorEnum> Lookup = new HashMap<String, ColorEnum>();

	static {
		for (ColorEnum keyValue : EnumSet.allOf(ColorEnum.class))
			Lookup.put(keyValue.getKey(), keyValue);
	}

	public static ColorEnum get(String key) {
		return Lookup.get(key);
	}
}
