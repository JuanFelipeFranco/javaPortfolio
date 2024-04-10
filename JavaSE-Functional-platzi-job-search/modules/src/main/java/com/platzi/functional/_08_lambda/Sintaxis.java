package com.platzi.functional._08_lambda;

import com.platzi.functional._06_reference_operator.nombresUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Sintaxis {
    public static void main(String[] args) {

        List <String> cursos = nombresUtils.getList("Java", "Functional");

        // esto es una lambda, ya que curso no esta almacenada en otro lugar, solo en este fragmento; lambda son casos unicos con logica simple
        cursos.forEach(curso -> System.out.println(curso));

        // estamos generando una lambda que no tiene ningun argumento o parametro, no colocamos un return java infiere que el valor a retornar es 2
        usarZero(()->2);

        //los predicados toman un solo dato y devuelven un boolean.
        usarPredicado(text -> text.isEmpty());

        //usamos bifunction pasamos parmametro 1 x y parametro 2 y y devuelve el resultado de la multiplicacion entre ellas
        usarBiFunction((x,y) -> x * y);

        //si yo voy hacer dos cosas dentro de mi funcion, primero le coloco las llaves y tengo que especificar el return ya que es un cuerpo mas grande
        //si el casos es de un solo elemento java asume el retono directamente pero al ser grande toca especificar el return
        usarBiFunction((x,y) -> {
            System.out.println("X" + x + ", Y:"+y);
            return x -y;
        } );

        //en este caso no estamos recibiendo ningun dato y no estoy generando ningun dato.
        usarNada(() -> {});

        //en caso de que queramos especificar el tipo de dato explicito tenemos que manejar un tipo de objeto INTEGER y no int. esto normalmente no se coloca explicitamente
        usarBiFunction((Integer x, Integer y) -> x * y);

        //utilizamos explicitamente en algunas ocasiones cuando estamos operando sobre una clase que es de un subtipo de alguna otra clase, por ejemplo en las listas
        // en este caso  usando esta nos especifica que debemos usar un dato super.
        //cursos.forEach();



    }

    //---------------  FUNCIONES DE ORDEN MAYOR --------------------

    //utilizamos la funcional interface de ZeroArgumentos generamos esta funcion para crear un elemento con la interface
    static void usarZero(ZeroArgumentos zeroArgumentos){

    }

    //en el caso de los predicados, en este casos toma un predicado de tipo string que llamamos predicado
    static void usarPredicado(Predicate<String> predicado){

    }

    //usamos bifunction y dentro pasamos tipo de dato integer integer y nos devuelve el dato integer
    static void usarBiFunction (BiFunction<Integer,Integer,Integer> operacion){

    }

    static void usarNada (Operarnada operarnada){

    }

    //en esta interface tenemos un metodo que obtenemos un int pero su argumento esta vacio
    @FunctionalInterface
    interface ZeroArgumentos {
        int get();
    }

    // funcion que no va recibir ningun parametro ni tampco genera un resultado; por ejemplo el println es una clase que recibe un parametro pero no hace nada
    //otro ejemplo es una funcion que requiera conectarse internet pero que no requiere un parametro para funcionar
    @FunctionalInterface
    interface Operarnada{
        void nada();
    }

}
