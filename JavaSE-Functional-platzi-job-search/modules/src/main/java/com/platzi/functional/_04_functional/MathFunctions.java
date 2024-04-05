package com.platzi.functional._04_functional;

import java.sql.SQLOutput;
import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {
    public static void main(String[] args) {
        //---------------------FUNCTION-----------------//
        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        System.out.println(square.apply(3));
        System.out.println(square.apply(4));

        System.out.println(squareFunction(3)); //funcion como metodo.

        Function<Integer, Boolean> isOdd = x -> x % 2 == 1; //(x=integer -> x%2==1Boolean)

        //-------------------------- PREDICATE ---------------------//
        Predicate<Integer> isEven = x -> x % 2 == 0;
        //para ejecutar estAS FUNCIONES ESPECIFICAS conocida como predicado se usa el metodo test.
        isEven.test(4); //true

        //con los predicados podemos generar predicciones, validaciones rapidas, validaciones sobre unas funciones o metodos que tenemos
        //nos puede beneficiar cuando estemos filtrando elementos o cuando queremos corroborar que algo tiene datos dentro
        Predicate<Student> isApproved = student -> student.getCalificacion() >= 6.0;
        Student sinuhe = new Student(5.9);
        System.out.println(isApproved.test(sinuhe));
    }
    //---------------------FUNCTION-----------------//
    static int squareFunction(int x){
        return x * x;
    }
    //-------------------------- PREDICATE ---------------------//
    static class Student{
        private double calificacion;
        public Student(double calificacion) {
            this.calificacion = calificacion;
        }

        public double getCalificacion() {
            return calificacion;
        }
    }




}
