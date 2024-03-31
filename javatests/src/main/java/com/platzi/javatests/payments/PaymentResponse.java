package com.platzi.javatests.payments;

public class PaymentResponse {
    //enumeracion que tiene dos respuestas del pago
    enum PaymentStatus {
        OK, ERROR
    }
    //codigo de respuesta.
    private PaymentStatus status;

    public PaymentResponse(PaymentStatus status) {
        this.status = status;
    }
    public PaymentStatus getStatus() {
        return status;
    }
}
