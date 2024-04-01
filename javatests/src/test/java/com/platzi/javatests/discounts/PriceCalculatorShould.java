package com.platzi.javatests.discounts;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PriceCalculatorShould {
    @Test //retornar cero cuando no hay ningun precio
    public void total_zero_when_there_are_prices(){
        PriceCalculator calculator = new PriceCalculator();
        assertThat(calculator.getTotal(),is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices(){
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(10.2);
        calculator.addPrice(15.5);

        assertThat(calculator.getTotal(),is(25.7));
    }

    @Test
    public void apply_discount_to_prices(){
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(14.4);
        calculator.addPrice(15.6);

        calculator.setDiscount(25); //aplicando descuento.

        assertThat(calculator.getTotal(),is(22.5));
    }




}