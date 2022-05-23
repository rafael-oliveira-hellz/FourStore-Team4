package br.com.foursys.fourcamp.fourstore.enums;

public enum PaymentMethodEnum {
	
	BILLET("Boleto à vista"), BILLETINSTALLMENT("Boleto parcelado"), CREDITCARD("Cartão de crédito"), PIX("Pix"), CASH("Dinheiro à vista");
	
	private final String paymentMethod;

	private PaymentMethodEnum(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
}
