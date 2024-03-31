package com.platzi.javatests.payments;

public class PaymentRequest {
    //LA CLASE REQUIERE EL MONTO QUE QUEREMOS PAGAR
    private double amount;

    public PaymentRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
