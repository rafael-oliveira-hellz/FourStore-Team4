package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ColorEnum {
	
	VERMELHO("50"),
	VERDE("51"),
	AZUL("52"),
	BRANCO("53"),
	PRETO("54"),
	AMARELO("55"),
	MARROM("56"),
	CINZA("57"),
	ROSA("58");
	
	public String key;
	
	public String getKey() {
		return key;
	}
	
	ColorEnum(String key) {
		this.key = key;
	}
	
	private static final Map<String, ColorEnum> Lookup = new HashMap<String, ColorEnum>();
	
	static {
		for(ColorEnum keyValue : EnumSet.allOf(ColorEnum.class))
			Lookup.put(keyValue.getKey(), keyValue);
	}
	
	public static ColorEnum get(String key) {
		return Lookup.get(key);
	}
}
