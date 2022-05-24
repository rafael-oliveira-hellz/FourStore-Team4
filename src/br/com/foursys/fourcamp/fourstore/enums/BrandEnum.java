package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum BrandEnum {
    KOSAIR("KSR"),
    HERING("HRG"),
    KARL("KRL"),
    MALWEE("MLW"),
    CALVINKLEIN("CKL"),
    LACOSTE("LCO"),
    DIESEL("DSL"),
    NIKE("NKE"),
    ADIDAS("ADI"),
    PUMA("PMA"),
    OLYMPIKUS("OLP"),
    OBOTICARIO("OBT"),
    NATURA("NTR"),
    CHANEL5("CNL"),
    ABIPROJECT("ABI"),
    BOSS("BOS"),
    REVAMPP("RVP"),
    NAAU("NAA"),
    ELEPHANT("ELP"),
    HIGHERSTORE("HRS"),
    SANTABOUTIQUE("STB");

    public String key;

    public String getKey() {
        return key;
    }

    BrandEnum(String key) {
        this.key = key;
    }

    private static final Map<String, BrandEnum> Lookup = new HashMap<String, BrandEnum>();

    static {
        for (BrandEnum keyValue : EnumSet.allOf(BrandEnum.class))
            Lookup.put(keyValue.getKey(), keyValue);
    }

    public static BrandEnum get(String key) {
        return Lookup.get(key);
    }
}
