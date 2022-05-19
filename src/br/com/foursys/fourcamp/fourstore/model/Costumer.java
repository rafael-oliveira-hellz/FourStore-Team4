package br.com.foursys.fourcamp.fourstore.model;

import br.com.foursys.fourcamp.fourstore.enums.PaymentMethodEnum;

public class Costumer {
	private String name;
	private String cpf;
	private PaymentMethodEnum paymentMethod;
	
	public Costumer(String name, String cpf, PaymentMethodEnum paymentMethod) {
		this.name = name;
		this.cpf = cpf;
		this.paymentMethod = paymentMethod;
	}

	public Costumer(String name, PaymentMethodEnum paymentMethod) {
		this.name = name;
		this.paymentMethod = paymentMethod;
	}
	
	public Costumer () {}

	@Override
	public String toString() {
		return "Costumer [name=" + name + ", cpf=" + cpf + "]";
	}
	
	
}


