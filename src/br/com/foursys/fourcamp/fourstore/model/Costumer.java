package br.com.foursys.fourcamp.fourstore.model;

public class Costumer {
	private String name;
	private String cpf;
	private PaymentMethod paymentMethod;
	
	public Costumer(String name, String cpf, PaymentMethod paymentMethod) {
		this.name = name;
		this.cpf = cpf;
		this.paymentMethod = paymentMethod;
	}

	public Costumer(String name, PaymentMethod paymentMethod) {
		this.name = name;
		this.paymentMethod = paymentMethod;
	}
	
	public Costumer () {}

	@Override
	public String toString() {
		return "Costumer [name=" + name + ", cpf=" + cpf + "]";
	}
	
	
}


