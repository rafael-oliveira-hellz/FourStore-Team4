package br.com.foursys.fourcamp.fourstore.enums;

public class PaymentMethods {
    public static final int Billet = 1;
    public static final int BilletInstallment = 2;
    public static final int CreditCard = 3;
    public static final int Pix = 4;

    public static PaymentMethod getPaymentMethod(int paymentMethod) {
        switch (paymentMethod) {
            case 1:
                return PaymentMethod.Billet;
            case 2:
                return PaymentMethod.BilletInstallment;
            case 3:
                return PaymentMethod.CreditCard;
            case 4:
                return PaymentMethod.Pix;
            default:
                return null;
        }
    }
}
