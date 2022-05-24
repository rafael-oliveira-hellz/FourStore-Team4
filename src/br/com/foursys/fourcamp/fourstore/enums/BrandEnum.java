package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum BrandEnum {
    KOSAIR("KSR", "Kosair"),
    HERING("HRG", "Hering"),
    KARL("KRL", "Karl"),
    MALWEE("MLW", "Malwee"),
    CALVINKLEIN("CKL", "Calvin Klein"),
    LACOSTE("LCO", "Lacoste"),
    DIESEL("DSL", "Diesel"),
    NIKE("NKE", "Nike"),
    ADIDAS("ADI", "Adidas"),
    PUMA("PMA", "Puma"),
    OLYMPIKUS("OLP", "Olympikus"),
    OBOTICARIO("OBT", "O Boticário"),
    NATURA("NTR", "Natura"),
    AVON("AVN", "Avon"),
    CHANEL5("CNL", "Chanel #5"),
    ABIPROJECT("ABI", "Abi Project"),
    BOSS("BOS", "Hugo Boss"),
    REVAMPP("RVP", "Revamp"),
    NAAU("NAA", "NAAU"),
    ELEPHANT("ELP", "Elephant"),
    HIGHERSTORE("HRS", "Higher Store"),
    SANTABOUTIQUE("STB", "Santa Boutique");

    public String key;
    public String description;

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    BrandEnum(String key, String description) {
        this.key = key;
        this.description = description;
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
}
