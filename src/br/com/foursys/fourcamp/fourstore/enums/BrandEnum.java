package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum BrandEnum {
	KOSAIR("KSR", "Kosair", 1),
    HERING("HRG", "Hering", 2),
    KARL("KRL", "Karl", 3),
    MALWEE("MLW", "Malwee", 4),
    CALVINKLEIN("CKL", "Calvin Klein", 5),
    LACOSTE("LCO", "Lacoste", 6),
    DIESEL("DSL", "Diesel", 7),
    NIKE("NKE", "Nike", 8),
    ADIDAS("ADI", "Adidas", 9),
    PUMA("PMA", "Puma", 10),
    OLYMPIKUS("OLP", "Olympikus", 11),
    OBOTICARIO("OBT", "O Boticario", 12),
    NATURA("NTR", "Natura", 13),
    AVON("AVN", "Avon", 14),
    CHANEL5("CNL", "Chanel #5", 15),
    ABIPROJECT("ABI", "Abi Project", 16),
    BOSS("BOS", "Hugo Boss", 17),
    REVAMPP("RVP", "Revamp", 18),
    NAAU("NAA", "NAAU", 19),
    ELEPHANT("ELP", "Elephant", 20),
    HIGHERSTORE("HRS", "Higher Store", 21),
    SANTABOUTIQUE("STB", "Santa Boutique", 22);

	private String key;
    private String description;
    private Integer option;

    BrandEnum(String key, String description, int option) {
    	this.key = key;
    	this.description = description;
    	this.option = option;
    }
    
    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }


    public Integer getOption() {
		return option;
	}

	private static final Map<String, BrandEnum> Lookup = new HashMap<String, BrandEnum>();

    static {
        for (BrandEnum keyValue : EnumSet.allOf(BrandEnum.class))
            Lookup.put(keyValue.getKey(), keyValue);
    }

    public static BrandEnum get(String key) {
        return Lookup.get(key);
    }

    public static BrandEnum getByDescription(String description) {
        for (BrandEnum keyValue : EnumSet.allOf(BrandEnum.class))
            if (keyValue.getDescription().equals(description))
                return keyValue;
        return null;
    }
    
    public static BrandEnum getByOption(Integer option) {
        for (BrandEnum keyValue : EnumSet.allOf(BrandEnum.class))
            if (keyValue.getOption().equals(option))
                return keyValue;
        return null;
    }
}
