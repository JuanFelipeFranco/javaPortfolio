package com.platzi.functional._06_reference_operator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class nombresUtils {

    public static void main(String[] args) {
        //con esto estamos obteniendo una lista de nombres a partir del nombre creado.
        List<String> profesores  = getList("Felipe","Juan","");

        //como el metodo foreach requiere de un consumer que recibe como metodo, entonces creamos un Consumer de tipo string
        Consumer <String> printer = text -> System.out.println(text);
        profesores.forEach(printer); //lo que hace es que va a recorrer la lista cada uno de los elementos y va ejecutar el consumer
        System.out.println("---------------------LO MISMO-----------------------");
        //otra manera de hacer: podemos hacer referencia a metodos o funciones definidas en otra clase o objeto
        profesores.forEach(System.out::println);//:: significa ve a buscar este metodo definida en el objeto system.out
    }
    public static <T> List <T> getList(T...elements){
        return Arrays.asList(elements);
    }

}
