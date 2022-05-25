package br.com.foursys.fourcamp.fourstore.model;

import br.com.foursys.fourcamp.fourstore.enums.PaymentMethodEnum;

public class Costumer {
	private String name;
	private String cpf;
	private String paymentMethod;
	
	public Costumer(String name, String cpf, Integer paymentMethod) {
		this.name = name;
		this.cpf = cpf;
		this.paymentMethod = PaymentMethodEnum.getByPaymentMethodId(paymentMethod).getPaymentMethod();
	}

	public Costumer(String name, Integer paymentMethod) {
		this.name = name;
		this.paymentMethod = PaymentMethodEnum.getByPaymentMethodId(paymentMethod).getPaymentMethod();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = PaymentMethodEnum.getByPaymentMethodId(paymentMethod).getPaymentMethod();
	}

	@Override
	public String toString() {
		return "Costumer [name=" + name + ", cpf=" + cpf + "]";
	}
	
	
}


