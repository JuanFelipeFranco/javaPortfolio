package com.platzi.functional._15_streams_intro;

import com.platzi.functional._06_reference_operator.nombresUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> courseList = nombresUtils.getList(
                "Java",
                "FrontEnd",
                "BackEnd",
                "FullStack"
        );
//De esta manera podemos trabajar las colecciones, sobre listas set o arreglos.
        for (String course : courseList ){
            String newCourseName = course.toLowerCase().replace("!","!!");
            System.out.println("platzi: " + newCourseName);
        }

        Stream<String> coursesStream = Stream.of("Java",
                "FrontEnd",
                "BackEnd",
                "FullStack");
        //para consumir estos datos podemos agregar operaciones para que se itere,
  //      Stream <Integer> courseLengthStream = coursesStream.map(course -> course.length());

        //cual es el nombre maslargo que tenemos, s epone optional porque no sabemos si x o y puedan estar vacios.
   //     Optional<Integer> longest  = courseLengthStream.max((x, y)->y-x);

        Stream<String> emphasisCourses = coursesStream.map(course -> course+"!");
        //emphasisCourses.forEach(System.out::println);

        //estos cursos son solo los que tienen la palaba java
        Stream<String> justJavaCourses = emphasisCourses.filter(course -> course.contains("Java"));
        justJavaCourses.forEach(System.out::println);

    }
}
/*

Los Stream se utilizan para trabajar con colecciones de objetos, facilitando realizar operaciones de filtrado, mapeo, búsqueda, etc.
No son una estructura de datos (como List o Map), sino que se trata de un flujo de datos. ⠀ Se pueden crear a partir de colecciones
ya existentes pero se debe tener en cuenta que al tratarse de un flujo de datos, son de un solo uso, es decir, si se quiere operar con
Stream la misma colección varias veces, se debe crear uno nuevo cada vez. ⠀ Por ejemplo, se puede crear un Stream<String> a partir de
una lista para procesar sus elementos aplicando funciones que a su vez devuelven otro Stream:


List<String> distroList = Arrays.asList("Ubuntu 22.04 LTS", "Kubuntu 21.10", "Manjaro Xfce Desktop");

Stream<String> distroStream = distroList.stream(); // crea un Stream a partir de la lista
Stream<String> ubuntuStream = distroStream.filter(distroName -> distroName.contains("ubuntu")); // Devuelve un nuevo Stream con los elementos que contengan el texto "ubuntu"
Stream<String> lowercaseStream = ubuntuStream.map(String::toLowerCase); // Devuelve un nuevo Stream con los nombres en minúsculas
Stream<String> lowDashStream = lowercaseStream.map(nombre -> nombre.replaceAll(" ", "-")); // Devuelve un nuevo Stream donde se han reemlazado los espacios por "_"
lowDashStream.forEach(System.out::println); // Se recorre el Stream para mostrar sus elementos

// En lugar de asignar cada Stream a una variable, se pueden encadenar las llamadas a las funciones y obtener el mismo resultado
distroList.stream()
        .filter(distroName -> distroName.contains("ubuntu"))
        .map(String::toLowerCase)
        .map(nombre -> nombre.replaceAll(" ", "-"))
        .forEach(System.out::println);
También existen funciones que tras operar sobre un Stream devuelven un tipo de dato distino. Algunos ejemplos son:


// Largo del String más largo
long largomaximo = distroList.stream()
        .mapToInt(String::length) // Devuelve un Strean<Integer> con el largo de cada String
        .max() // Si habían elementos, devuelve un Optional<Integer> con el valor máximo de los largos de las Strings
        .orElse(0); // Si no había elementos, devuelve 0

// Devuelve true si alguno de los elementos de la lista contiene la cadena "Debian"
boolean contieneDebian = distroList.stream().anyMatch(nombre -> nombre.contains("Debian"));

// Devuelve true si ninguno de los elementos de la lista es un String vacío
boolean ningunoEstaVacio = distroList.stream().noneMatch(nombre -> nombre.isEmpty());

// Devuelve un String con los elementos de la lista separados por ", "
String todos = distroList.stream().reduce("", (acumulador, actual) -> acumulador + ", " + actual);
*/
