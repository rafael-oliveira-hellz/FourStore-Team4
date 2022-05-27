package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum CategoryEnum {

	MALE("10", "Masculino"),
	FEMALE("11", "Feminino"),
	BABY("12", "Moda Bebe");

	public String key;
	public String description;

	public String getKey() {
		return key;
	}

	public String getDescription() {
		return description;
	}

	CategoryEnum(String key, String description) {
		this.key = key;
		this.description = description;
	}

	private static final Map<String, CategoryEnum> Lookup = new HashMap<String, CategoryEnum>();

	static {
		for (CategoryEnum keyValue : EnumSet.allOf(CategoryEnum.class))
			Lookup.put(keyValue.getKey(), keyValue);
	}

	public static CategoryEnum get(String key) {
		return Lookup.get(key);
	}

	public static CategoryEnum getByDescription(String description) {
		for (CategoryEnum keyValue : EnumSet.allOf(CategoryEnum.class)) {
			if (keyValue.getDescription().equals(description))
				return keyValue;
		}
		return null;
	}
}
