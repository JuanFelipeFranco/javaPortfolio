package com.platzi.javatests.payments;

public interface PaymentGateway {
    //tiene un metodo llamado requestpayment que recibre un paymentrequest y devuelve un payment response.
    PaymentResponse requestPayment(PaymentRequest request);
}
