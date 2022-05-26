package br.com.foursys.fourcamp.fourstore.model;

import br.com.foursys.fourcamp.fourstore.enums.PaymentMethodEnum;

public class Costumer {
	private String name;
	private String cpf;
	private String paymentMethod;
	private Integer paymentData;
	
	public Integer getPaymentData() {
		return paymentData;
	}

	public void setPaymentData(Integer paymentData) {
		this.paymentData = paymentData;
	}

	public Costumer(String name, String cpf, Integer paymentMethod, Integer paymentData) {
		this.name = name;
		this.cpf = cpf;
		this.paymentMethod = PaymentMethodEnum.getByPaymentMethodId(paymentMethod).getPaymentMethod();
		this.paymentData = paymentData;
	}

	public Costumer(String name, Integer paymentMethod, Integer paymentData) {
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

	@Override
	public String toString() {
		String message = (cpf == null) ? hasNoCpf() : hasCpf();
		return message;
	}

	public String hasNoCpf() {
		if (paymentData != 99999999) {
			return "Cliente " + name + " com o cpf " + cpf + " cartão/pix " + paymentData;
			} else {
				return "Cliente " + name + " com o cpf " + cpf + ", pagou à vista";
			}
	}

	public String hasCpf() {
		if (paymentData != 99999999) {
			return "Cliente " + name + " cartão/pix " + paymentData;
		} else {
				return "Cliente " + name + ", pagou à vista";
		}
	}
		
	}

	
	
	



