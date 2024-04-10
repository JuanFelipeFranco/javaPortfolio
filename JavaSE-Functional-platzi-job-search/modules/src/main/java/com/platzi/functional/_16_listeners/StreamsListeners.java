package com.platzi.functional._16_listeners;

import com.platzi.functional._06_reference_operator.nombresUtils;

import java.util.List;
import java.util.stream.Stream;

public class StreamsListeners {
    public static void main(String[] args) {
        List<String> courseList = nombresUtils.getList(
                "Java",
                "FrontEnd",
                "BackEnd",
                "FullStack"
        );

        //tomando las colecciones donde implementamos el stream
        //--------------------- CHAINING ENCADENAMIENTO ------------------
        Stream<String> coursesStream2 = courseList.stream();
        addOperator(
                coursesStream2.map(course -> course + "!!")
                .filter(course -> course.contains("Java"))
        ).forEach(System.out::println);

    }
//funcion estatica, que devuelve un stream de cierto tipo que agrega operador a un stream que se envia como parametro.
    static <T> Stream <T> addOperator(Stream <T> stream){
        //peek es una funcion que tma un consumer pero no devuelve ningun dato, toma un dato y devuelve el mismo dato
        return stream.peek(data -> System.out.println("Dato "+data));
    }
}
