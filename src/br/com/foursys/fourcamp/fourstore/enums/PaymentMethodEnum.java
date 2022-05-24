package br.com.foursys.fourcamp.fourstore.enums;

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
}
