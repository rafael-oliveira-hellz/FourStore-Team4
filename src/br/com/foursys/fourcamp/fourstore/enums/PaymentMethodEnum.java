package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum PaymentMethodEnum {

	BILLET("Boleto à vista", 1),
	BILLETINSTALLMENT("Boleto parcelado", 2),
	CREDITCARD("Cartão de crédito", 3),
	DEBITCARD("Cartão de débito", 4),
	PIX("Pix", 5),
	CASH("Dinheiro à vista", 6);

	private final String paymentMethod;
	private final Integer paymentMethodId;

	private PaymentMethodEnum(String paymentMethod, Integer paymentMethodId) {
		this.paymentMethod = paymentMethod;
		this.paymentMethodId = paymentMethodId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}

	private static final Map<String, PaymentMethodEnum> Lookup = new HashMap<String, PaymentMethodEnum>();

	static {
		for (PaymentMethodEnum keyValue : EnumSet.allOf(PaymentMethodEnum.class))
			Lookup.put(keyValue.getPaymentMethod(), keyValue);
	}

	public static PaymentMethodEnum get(String paymentMethod) {
		return Lookup.get(paymentMethod);
	}

	public static PaymentMethodEnum getByPaymentMethodId(Integer paymentMethodId) {
		for (PaymentMethodEnum keyValue : EnumSet.allOf(PaymentMethodEnum.class))
			if (keyValue.getPaymentMethodId().equals(paymentMethodId))
				return keyValue;
		return null;
	}
}
