package com.platzi.functional._04_functional;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {
    //funcion estatica
    public static void main(String[] args) {
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        UnaryOperator<String> addMark = text -> text + "!";

        System.out.println(quote.apply("Hola Developer"));
        System.out.println(addMark.apply("Hola Developer"));

        BiFunction<Integer, Integer, Integer> multiplicacion = (x,y)->x*y;
        System.out.println(multiplicacion.apply(5,4));

        //se usa cuando nuestras variables todas son del mismo tipo en este caso INTEGER
        BinaryOperator<Integer> suma = (x,y)-> x+y;
        System.out.println(suma.apply(4,6));

        //Agregando espacios a un string. La palabra tiene 4 pero como nos da un texto de 10 el resto son espacios
        BiFunction<String, Integer, String> leftpad = (text,number) -> String.format("%" +number+ "s", text);
        System.out.println(leftpad.apply("JAVA", 10));

        //LISTA DE FUNCTIONS QUE HAGA UNA SERIE DE FORMATEOS
        List<BiFunction<String, Integer, String>> formateadores;
    }
}
