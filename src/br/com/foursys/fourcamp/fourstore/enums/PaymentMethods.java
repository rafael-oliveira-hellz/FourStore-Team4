package br.com.foursys.fourcamp.fourstore.enums;

public class PaymentMethods {
    public static final int Billet = 1;
    public static final int BilletInstallment = 2;
    public static final int CreditCard = 3;
    public static final int Pix = 4;

    public static PaymentMethodEnum getPaymentMethod(int paymentMethod) {
        switch (paymentMethod) {
            case 1:
                return PaymentMethodEnum.Billet;
            case 2:
                return PaymentMethodEnum.BilletInstallment;
            case 3:
                return PaymentMethodEnum.CreditCard;
            case 4:
                return PaymentMethodEnum.Pix;
            default:
                return null;
        }
    }
}
