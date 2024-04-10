package com.platzi.functional._06_reference_operator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*The double colon ( :: ) operator, also known as method reference operator in Java,
is used to call a method by referring to it with the help of its class directly.
They behave exactly as the lambda expressions. The only difference it has from lambda
expressions is that this uses direct reference to the method by name instead of providing a delegate to the method.
Method reference or double colon operator can be used to refer: A static method: (ClassName::methodName)
An instance method: (objectOfClass::methodName) A constructor: (super::methodName)*/

public class nombresUtils {

    public static void main(String[] args) {
        //lista de nombres llamado profesores, le hacemos get list de los nombres; con esto estamos obteniendo una lista de nombres a partir del metodo creado.
        List<String> profesores  = getList("Felipe","Juan","");

        //como el metodo foreach requiere de un consumer que recibe como metodo, entonces creamos un Consumer de tipo string
        Consumer <String> printer = text -> System.out.println(text);
        profesores.forEach(printer); //lo que hace es que va a recorrer la lista cada uno de los elementos y va ejecutar el consumer printer.

        System.out.println("---------------------LO MISMO-----------------------");
        //otra manera de hacer: podemos hacer referencia a metodos o funciones definidas en otra clase o objeto con este simbolo ::
        profesores.forEach(System.out::println);//:: significa ve a buscar este metodo definida en el objeto system.out
    }

    //Estamos creando una lista llamada getlista que recibe n elementos y que nos devuelve una lista a partir de esos elementos.
    public static <T> List <T> getList(T...elements){
        return Arrays.asList(elements);
    }

}
