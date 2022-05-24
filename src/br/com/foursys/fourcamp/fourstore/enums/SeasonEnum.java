package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SeasonEnum {

	SUMMER("40"),
	WINTER("41"),
	FALL("42"),
	SPRING("43");

	public String key;

	public String getKey() {
		return key;
	}

	SeasonEnum(String key) {
		this.key = key;
	}

	private static final Map<String, SeasonEnum> Lookup = new HashMap<String, SeasonEnum>();

	static {
		for (SeasonEnum keyValue : EnumSet.allOf(SeasonEnum.class))
			Lookup.put(keyValue.getKey(), keyValue);
	}

	public static SeasonEnum get(String key) {
		return Lookup.get(key);
	}
}
