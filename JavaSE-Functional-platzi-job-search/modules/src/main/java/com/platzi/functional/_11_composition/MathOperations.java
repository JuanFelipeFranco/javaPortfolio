package com.platzi.functional._11_composition;

import java.util.function.Function;

public class MathOperations {
    public static void main(String[] args) {
        Function<Integer,Integer> multiplyBy3= x -> {
            System.out.println("Multiplicando x: "+x+ " por 3");
            return x*3;
        };

        Function<Integer,Integer> add1MultplyBy3=
                //agregando impresion por pantalla
                multiplyBy3.compose(y->{
                    System.out.println("le agregare 1 a: " +y);
                    return y+1; });

        //agregar un paso despues de la ejecucion de la funcion
        Function<Integer, Integer> andSquare = add1MultplyBy3.andThen(x->{
            System.out.println("Estoy elevando "+x+" al cuadrado");
            return x *x;
        });

        System.out.println(add1MultplyBy3.apply(1));
        System.out.println(andSquare.apply(3));





        /*//cuando se invoca la funcion add1MultiplyBY3  se esta generando una funcion intermedia
        //a partir de compose, esta toma la funcion y la ejecuta primero y despues la funcion sobre la cual se mando a llamar que es
        //multiplyby3; en resumen toma la funcion con la lambda y despues la otra funcion ultiplyby3
        */
    }
}

/*Composición de funciones
La composición de funciones consta en crear dos o más funciones y asignarlas de forma tal
que el resultado de una sea tomado como parámetro de otra. Esto sólo es válido con funciones
que reciban un solo parámetro, pero la cadena puede tener tantas funciones como sea necesario.
Por ejemplo, tomando como base las funciones porTres y masUno, es posible componer la función
masUnoYPorTres la cual equivale a llamar la función masUno y al resultado aplicarle porTres.
Para ello basta con usar el método compose sobre la segunda función, y pasar por parámetro la primera.


Function<Integer, Integer> porTres = x -> x * 3;
Function<Integer, Integer> masUno = x -> x + 1;

Function<Integer, Integer> masUnoYPorTres = porTres.compose(masUno);

Integer resultado = masUnoYPorTres.apply(2); // resultado valdrá 9, ya que ((2 + 1) * 3)
Ya que el orden de las funciones en la composición es importante, también es de utilidad el método andThen.


/// ...
Function<Integer, Integer> porTresYMasUno = porTres.andThen(masUno);

Integer resultado = porTresYMasUno.apply(2); // resultado valdrá 7, ya que ((2 * 3) + 1)*/
