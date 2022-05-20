package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SizeEnum {
	
	RN("10"),
	PP("32"),
	P("35"),
	M("37"),
	G("41"),
	GG("43"),
	XG("45"),
	XXG("48"),
	G1("50"),
	G2("52"),
	G3("54");

	public String key;
	
	public String getKey() {
		return key;
	}
	
	SizeEnum(String key) {
		this.key = key;
	}
	
	private static final Map<String, SizeEnum> Lookup = new HashMap<String, SizeEnum>();
	
	static {
		for(SizeEnum keyValue : EnumSet.allOf(SizeEnum.class))
			Lookup.put(keyValue.getKey(), keyValue);
	}
	
	public static SizeEnum get(String key) {
		return Lookup.get(key);
	}
}
