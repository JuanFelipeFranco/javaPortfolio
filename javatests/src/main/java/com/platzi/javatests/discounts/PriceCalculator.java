package com.platzi.javatests.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    //guardamos los precios en una lista
    private List<Double> prices = new ArrayList<>();
    private double discount = 0;//crea un campo discount y este arranca e cero.

    public double getTotal() {
        double result =0; //arrancamos en 0
        //el total es calculado a partir de los valores que tenemos en prices, por medio de un bucle ITER .
        for (Double price : prices) { //este bucle va pasando por todos los precios y lo añade al resultado
            result += price;
        }
        return result * (1-(discount/100)); //retorna el valor, cuando tiene descuento
    }

    public void addPrice(double price) {
        //cada que añadimos un precio lo vamos añadiendo a la lista
        prices.add(price);
    }

    public void setDiscount(double discount) {

        this.discount = discount;
    }
}
