package com.platzi.functional._05_sam;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class AgeUtils {
    public static void main(String[] args) {
        //si es menor a 10 van a tener un cero antes del numero. tomamos un x que si es menor a cero vamos a devolver un cero en string y le adicionamos el numero x, en caso contrario si es mayor a cero devolvemos el x
        Function<Integer,String> addCeros = x -> x < 10 ? "0" + x :String.valueOf(x);

        //tres integer que devuelven una fecha, en este caso localdate es una representacion de un objeto de una fecha
        TriFunction<Integer,Integer,Integer, LocalDate> parseDate =
                (day, month, year) -> LocalDate.parse(year + "-" + addCeros.apply(month)+ "-" + addCeros.apply(day));

        //funcion que calcula la edad
        TriFunction<Integer,Integer,Integer,Integer> calculateAge =
                (day, month, year) -> Period.between(parseDate.apply(day,month,year),LocalDate.now()).getYears();

        System.out.println(calculateAge.apply(10,10,1992));
    }
    @FunctionalInterface
    interface TriFunction <T,U,V, R>{
        // es una funcion que esta recibiendo tres paramteros.
        R apply(T t,U u, V v);
    }
}
