package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TypeOfMerchandiseEnum {
	CALCA("231"),
	CAMISETA("232"),
	BLUSA("233"),
	TENIS("234"),
	CHINELO("235"),
	INTIMA("236"),
	MAQUIAGEM("237"),
	COSMETICOS("238"),
	CACHECOL("239"),
	GRAVATA("240");

	public String key;
	
	public String getKey() {
		return key;
	}
	
	TypeOfMerchandiseEnum(String key) {
		this.key = key;
	}
	
	private static final Map<String, TypeOfMerchandiseEnum> Lookup = new HashMap<String, TypeOfMerchandiseEnum>();
	
	static {
		for(TypeOfMerchandiseEnum keyValue : EnumSet.allOf(TypeOfMerchandiseEnum.class))
			Lookup.put(keyValue.getKey(), keyValue);
	}
	
	public static TypeOfMerchandiseEnum get(String key) {
		return Lookup.get(key);
	}
}
