package com.platzi.functional._07_inference;

import com.platzi.functional._06_reference_operator.nombresUtils;

import java.util.List;
import java.util.function.Function;

public class Inferencia {
    public static void main(String[] args) {
        //inferencia de tipos: java en tiempo de compilacion java se encarga de validar que los datos que esta pasando en la funcion corresponde al tipo de dato
        Function<Integer, String> funcionConvertidora = integer -> "al doble:"+(integer*2);


        //ejemplo anterior
        List<String> alumnos = nombresUtils.getList("Hugo","paco","luis");
        alumnos.forEach((String name) -> System.out.println(name)); //de manera explicita
        alumnos.forEach(name->System.out.println(name)); //sin definir el tipo, java se encarga de corroborar que ambos tipos sean el mismo
        alumnos.forEach(System.out::println); //con operator.
    }
    }