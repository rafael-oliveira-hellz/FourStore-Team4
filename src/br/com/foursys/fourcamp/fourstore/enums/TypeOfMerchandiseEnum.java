package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TypeOfMerchandiseEnum {
	PANTS("231"),
	TSHIRT("232"),
	BLOUSE("233"),
	SHOES("234"),
	FLIPFLOP("235"),
	INTIMATE("236"),
	MAKEUP("237"),
	COSMETIC("238"),
	SCARF("239"),
	TIE("240");

	public String key;

	public String getKey() {
		return key;
	}

	TypeOfMerchandiseEnum(String key) {
		this.key = key;
	}

	private static final Map<String, TypeOfMerchandiseEnum> Lookup = new HashMap<String, TypeOfMerchandiseEnum>();

	static {
		for (TypeOfMerchandiseEnum keyValue : EnumSet.allOf(TypeOfMerchandiseEnum.class))
			Lookup.put(keyValue.getKey(), keyValue);
	}

	public static TypeOfMerchandiseEnum get(String key) {
		return Lookup.get(key);
	}
}
