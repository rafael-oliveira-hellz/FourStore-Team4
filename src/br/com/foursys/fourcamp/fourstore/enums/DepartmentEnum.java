package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum DepartmentEnum {
	
	VESTUARIO("50"),
	CALCADOS("51"),
	PERFUMARIA("52"),
	ACESSORIOS("53");
	
	public String key;
	
	public String getKey() {
		return key;
	}
	
	DepartmentEnum(String key) {
		this.key = key;
	}
	
	private static final Map<String, DepartmentEnum> Lookup = new HashMap<String, DepartmentEnum>();
	
	static {
		for(DepartmentEnum keyValue : EnumSet.allOf(DepartmentEnum.class))
			Lookup.put(keyValue.getKey(), keyValue);
	}
	
	public static DepartmentEnum get(String key) {
		return Lookup.get(key);
	}
}
