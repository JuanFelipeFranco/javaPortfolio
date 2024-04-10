package com.platzi.functional._17_operators_collectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TypeStream {
    public static void main(String[] args) {
        //string que emite enteros
        IntStream infiniteStream = IntStream.iterate(0, (x->x+1));
        //transformamos un stream a una lista
        List<Integer> numbersList = infiniteStream.limit(1000)
                //.parallel() //en este caso el paralell ejecuta el codigo en desorden debido a que hace que este codigo se vaya ejecutando por el numero de nucleos; por eso no tiene un orden especifico
                .filter(x->x%2 ==0)
                .boxed()//lo convertimos a un box que este caso esta trabajando en enteros vamos a convertir a un stream de enteros
                .collect(Collectors.toList()); //recopilar los datos stream en una estructura (lista, mapa o arreglo) en este caso una lista.
                //.forEach(System.out::println);

      //        .allMatch(x-> true)//sirve para verificar en este caso devuelve un boolean


    }
}

/*
Streams de tipo específico
Existen casos donde se quiere operar con Streams sobre tipos de datos incorporados en Java (como Integer o Double),
es por eso que Java incorpora los Streams de tipo específico, los cuales permiten asegurar que las operaciones que
se realicen sobre ellos trabajarán con el tipo de dato correspondiente.


List<String> numeros = Arrays.asList("0,37", "4,87", "1,23", "2,34", "3,45", "4,56");

DoubleStream doubleStream = numeros.stream()
        .map(numero -> numero.replace(",", ".")) // Reedecion las comas por puntos para que el Parse sea correcto
        .mapToDouble(Double::parseDouble) // Convierte los numeros de String a Double. A partir de acá se trabaja con DoubleStream en lugar de Stream
        .filter(numero -> numero < 1.5) // Filtra los numeros menores a 1.5
        .map(numero -> numero / 2) // Divide entre 2
        .sorted(); // Ordena los Doubles
Los Streams de tipo específico también permiten generar los datos en lugar de construirse a partir de una lista. ⠀ Por ejemplo, con IntStream.iterate se puede definir un número inicial y la Lambda que se usará para generar nuevos elementos.


// IntStream que contiene los primeros 100 años biciestos a partir del 1900
        IntStream leapYears = IntStream.iterate(1900, x -> x + 1) // Genera numeros partiendo de 100 y aumentando 1 cada vez
        .filter(x -> x % 4 == 0) // los años bisiestos son divisibles entre 4
        .filter(x -> (x % 100 != 0) || (x % 100 == 0 && x % 400 == 0)) // pero si son divisibles entre 100 tambien deben serlo entre 400
        .limit(100); // limita a los 100 primeros años bisiestos
Es importante tener en cuenta que al generar Streams infinitos, se debe detener su generación en algún punto, de lo contrario se comportará como un bucle infinito (while (true)). ⠀

        ⠀

Streams con paralelismo

Existen casos donde se quiere operar los elementos de un Stream de forma paralela, es decir, que existan varios procesos
tomando elementos distintos y procesarlos a la misma vez. Para crearlos a partir de una lista se puede utilizar la función
parallelStream() en lugar de stream(), o si se tiene un Stream secuencial se puede convertir con parallel().


List<String> lenguajes = Arrays.asList("C#", "C++", "Go", "Java", "JavaScript", "PHP", "Python", "Ruby", "Swift", "TypeScript");

// Secuencial (ordenado)
lenguajes.stream()
        .forEach(System.out::println);

// Paralelo (desordenado)
lenguajes.parallelStream()
        .forEach(System.out::println);

Es importante tener en cuenta que al generar Streams paralelos no se mantiene el orden al iterar sobre él, ni tampoco
existe un orden predecible en el Stream resultante.*/
