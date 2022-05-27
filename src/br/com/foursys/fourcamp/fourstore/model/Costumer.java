package br.com.foursys.fourcamp.fourstore.model;

import br.com.foursys.fourcamp.fourstore.enums.PaymentMethodEnum;

public class Costumer {
	private String name;
	private String cpf;
	private String paymentMethod;
	private String paymentData;
	

	public Costumer(String name, String cpf, Integer paymentMethod, String paymentData) {
		this.name = name;
		this.cpf = cpf;
		this.paymentMethod = PaymentMethodEnum.getByPaymentMethodId(paymentMethod).getPaymentMethod();
		this.paymentData = paymentData;
	}

	public Costumer(String name, Integer paymentMethod, String paymentData) {
		this.name = name;
		this.paymentMethod = PaymentMethodEnum.getByPaymentMethodId(paymentMethod).getPaymentMethod();
		this.paymentData = paymentData;
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

	public String getPaymentData() {
		return paymentData;
	}

	public void setPaymentData(String paymentData) {
		this.paymentData = paymentData;
	}
	
	@Override
	public String toString() {
		String message = (cpf == null) ? hasNoCpf() : hasCpf();
		return message;
	}

	public String hasCpf() {
		if (paymentData != null || paymentData.equalsIgnoreCase("")) {
			return name + " com o cpf " + cpf + "\n" +  paymentData;
			} else {
				return name + " com o cpf " + cpf + ", pagou à vista";
			}
	}

	public String hasNoCpf() {
		if (paymentData != null || paymentData.equals("")) {
			return name + " " + paymentData;
		} else {
				return name + ", pagou à vista";
		}
	}
		
	}

	
	
	



