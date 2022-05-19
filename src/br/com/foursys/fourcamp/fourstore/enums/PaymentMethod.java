package br.com.foursys.fourcamp.fourstore.enums;

public enum PaymentMethod {
	Billet(1), BilletInstallment(2), CreditCard(3), Pix(4);

	PaymentMethod(int i) {
		this.billet = billet;
		this.billetInstallment = billetInstallment;
		this.creditCard = creditCard;
		this.pix = pix;
	}

	private int billet;
	private int billetInstallment;
	private int creditCard;
	private int pix;

	public int getBillet() {
		return billet;
	}

	public int getBilletInstallment() {
		return billetInstallment;
	}

	public int getCreditCard() {
		return creditCard;
	}

	public int getPix() {
		return pix;
	}

	public void setBillet(int billet) {
		this.billet = billet;
	}

	public void setBilletInstallment(int billetInstallment) {
		this.billetInstallment = billetInstallment;
	}

	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}

	public void setPix(int pix) {
		this.pix = pix;
	}
}
