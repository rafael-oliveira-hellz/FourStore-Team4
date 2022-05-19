package br.com.foursys.fourcamp.fourstore.enums;

public enum PaymentMethodEnum {
	
	Billet(1), BilletInstallment(2), CreditCard(3), Pix(4);
	
	
	private final Integer paymentMethod;

	private PaymentMethodEnum(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Integer getPaymentMethod() {
		return paymentMethod;
	}
	
	
}
