package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SizeEnum {

	RN("10", "Tamanho RN"),
	PP("32", "Tamanho PP"),
	P("35", "Tamanho P"),
	M("37", "Tamanho M"),
	G("41", "Tamanho G"),
	GG("43", "Tamanho GG"),
	XG("45", "Tamanho XG"),
	XXG("48", "Tamanho XXG"),
	G1("50", "Tamanho G1"),
	G2("52", "Tamanho G2"),
	G3("54", "Tamanho G3");

	public String key;
	public String description;

	public String getKey() {
		return key;
	}

	public String getDescription() {
		return description;
	}

	SizeEnum(String key, String description) {
		this.key = key;
		this.description = description;
	}

	private static final Map<String, SizeEnum> Lookup = new HashMap<String, SizeEnum>();

	static {
		for (SizeEnum keyValue : EnumSet.allOf(SizeEnum.class))
			Lookup.put(keyValue.getKey(), keyValue);
	}

	public static SizeEnum get(String key) {
		return Lookup.get(key);
	}

	public static SizeEnum getByDescription(String description) {
		for (SizeEnum keyValue : EnumSet.allOf(SizeEnum.class))
			if (keyValue.getDescription().equals(description))
				return keyValue;
		return null;
	}
}
