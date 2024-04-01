package com.platzi.javatests.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {
    //Estas variables deben tenerse como campos de clase.
    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;
    @Before //metodo que le dice a JUnit que antes de ejecutar cada test ejecuta esta parte de setup
    public void setup(){
        paymentGateway= Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }
    @Test
    public void payment_is_correct(){
        //simulamos el paymentgateway que lo pasaremos al procesador
//        PaymentGateway paymentGateway= Mockito.mock(PaymentGateway.class);

        //simulamos con mokito que cuando al paymentgateway se le haga un request de algun payment,
        // cualquier tipo de request el va devolver una respuesta correcta.
        //----ARRANGE---- PREPAPARACION que queremos probar
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(
                new PaymentResponse(PaymentResponse.PaymentStatus.OK
        ));

//        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        //comprobamos que cuando al procesor intenta crear el pago de cierta cantidad el resultado es correcto
        assertTrue(paymentProcessor.makePayment(1500));
    }

    //
    @Test
    public void payment_is_wrong(){
        //----------PREPARACION DE LOS OBJETOS-------------
//        PaymentGateway paymentGateway= Mockito.mock(PaymentGateway.class);
        //simulamos que cuando se le haga un request al getway el va devolver ERROR
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(
                new PaymentResponse(PaymentResponse.PaymentStatus.ERROR ));
        //el payment processor deberia decir que es false. Que el pago no se ha realizado correcto.
//        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        //--------EJECUCION DEL METODO - probando el metodo makepayment: nuestro objetivo----------
        boolean result = paymentProcessor.makePayment(1500);

        //----------COMPROBACION DEL RESULTADO-----------
        assertFalse(result);
    }

}