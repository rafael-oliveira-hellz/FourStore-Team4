package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TypeOfMerchandiseEnum {
	PANTS("231", "Calça"),
	TSHIRT("232", "Camisa"),
	BLOUSE("233", "Blusa"),
	SHOES("234", "Ténis"),
	FLIPFLOPS("235", "Chinelos"),
	INTIMATE("236", "Roupa intima"),
	MAKEUP("237", "Maquiagem"),
	COSMETICS("238", "Cosméticos"),
	SCARF("239", "Cachecol"),
	TIE("240", "Gravata");

	public String key;
	public String description;

	public String getKey() {
		return key;
	}

	public String getDescription() {
		return description;
	}

	TypeOfMerchandiseEnum(String key, String description) {
		this.key = key;
		this.description = description;
	}

	private static final Map<String, TypeOfMerchandiseEnum> Lookup = new HashMap<String, TypeOfMerchandiseEnum>();

	static {
		for (TypeOfMerchandiseEnum keyValue : EnumSet.allOf(TypeOfMerchandiseEnum.class))
			Lookup.put(keyValue.getKey(), keyValue);
	}

	public static TypeOfMerchandiseEnum get(String key) {
		return Lookup.get(key);
	}

	public static TypeOfMerchandiseEnum getByDescription(String description) {
		for (TypeOfMerchandiseEnum keyValue : EnumSet.allOf(TypeOfMerchandiseEnum.class)) {
			if (keyValue.getDescription().equals(description))
				return keyValue;
		}
		return null;
	}
}
