package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum CategoryEnum {

	MALE("10"),
	FEMALE("11"),
	BABY("12");

	public String key;

	public String getKey() {
		return key;
	}

	CategoryEnum(String key) {
		this.key = key;
	}

	private static final Map<String, CategoryEnum> Lookup = new HashMap<String, CategoryEnum>();

	static {
		for (CategoryEnum keyValue : EnumSet.allOf(CategoryEnum.class))
			Lookup.put(keyValue.getKey(), keyValue);
	}

	public static CategoryEnum get(String key) {
		return Lookup.get(key);
	}
}
