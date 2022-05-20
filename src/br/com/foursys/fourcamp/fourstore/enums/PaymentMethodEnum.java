package br.com.foursys.fourcamp.fourstore.enums;

public enum PaymentMethodEnum {
	
	BILLET(1), BILLETINSTALLMENT(2), CREDITCARD(3), PIX(4), CASH(5);
	
	private final Integer paymentMethod;

	private PaymentMethodEnum(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Integer getPaymentMethod() {
		return paymentMethod;
	}
}
