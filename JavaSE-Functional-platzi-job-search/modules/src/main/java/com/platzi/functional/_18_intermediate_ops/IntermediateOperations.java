package com.platzi.functional._18_intermediate_ops;

import com.platzi.functional.util.Utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    static void operaciones() {
        /*
        Las operaciones intermedias, como se vio en el modulo anterior, son operaciones que
        retornan un nuevo Stream.

        Estas operaciones son:

           - filter()
           - map()
           - flatMap()
           - distinct()
           - limit()
           - peek()
         */

        //filter
        //Toma un Predicate que indica si debemos o no considerar el elemento para el nuevo Stream
        //forma general : Stream<T> filter(Predicate<? super T> predicate)
        Stream<Integer> evenNumbersStream = Stream.iterate(0, i -> i + 1);
        evenNumbersStream.filter(i -> i % 2 == 0); //Solo los numeros pares.

        /*Algunas cosas que podemos deducir únicamente viendo los elementos de la operación son:

        La operación trabaja sobre un Stream y nos devuelve un nuevo Stream del mismo tipo (T)
        Sin embargo, el Predicate que recibe como parámetro trabaja con elementos de tipo T y cualquier elemento siempre
        que sea un subtipo de T. Esto quiere decir que si tenemos la clase PlatziStudent extends Student y tenemos un
        Stream<Student> donde también tenemos elementos de tipo PlatziStudent, podemos filtrarlos sin tener que revisar
        o aclarar el tipo

        Predicate es una @FunctionalInterface (como lo viste en la clase 11), lo cual nos permite pasar como parámetro
        objetos que implementen esta interfaz o lambdas

        El uso de esta operación es sencillo:

        public Stream<String> getJavaCourses(List<String> courses){
            return courses.stream()
                    .filter(course -> course.contains("Java"));
        }

        /*Lo interesante radica en la condición que usamos en nuestra lambda, con ella determinamos si un elemento debe
        permanecer o no en el Stream resultante. En la lectura anterior hicimos una aproximación de la operación filter:

        public Stream<T> filter(Predicate<T> predicate) {
            List<T> filteredData = new LinkedList<>();
            for(T t : this.data){
                if(predicate.test(t)){
                    filteredData.add(t);
                }
            }

            return filteredData.stream();
        }

        filter se encarga de iterar cada elemento del Stream y evaluar con el Predicate si el elemento debe estar o no
        en el Stream resultante. Si nuestro Predicate es sencillo y no incluye ningún ciclo o llamadas a otras funciones
        que puedan tener ciclos, la complejidad del tiempo es de O(n), lo cual hace que el filtrado sea bastante rápido.

        Usos comunes de filter es limpiar un Stream de datos que no cumplan un cierto criterio. Como ejemplo podrías pensar en un Stream de transacciones bancarias, mantener el Stream solo aquellas que superen un cierto monto para mandarlas a auditoria, de un grupo de calificaciones de alumnos filtrar únicamente por aquellos que aprobaron con una calificación superior a 6, de un grupo de objetos JSON conservar aquellos que tengan una propiedad en especifico, etc.

       Entre mas sencilla sea la condición de filtrado, más legible sera el código. Te recomiendo que, si tienes más de una condición de filtrado, no le temas a usar varias veces filter:

        courses.filter(course -> course.getName().contains("Java"))
                .filter(course -> course.getDuration() > 2.5)
                .filter(course -> course.getInstructor().getName() == Instructors.SINUHE_JAIME)
        Tu código sera más legible y las razones de por qué estás aplicando cada filtro tendrán más sentido. Como algo adicional podrías mover esta lógica a funciones individuales en caso de que quieras hacer más legible el código, tener más facilidad de escribir pruebas o utilices en más de un lugar la misma lógica para algunas lambdas:

        courses.filter(Predicates::isAJavaCourse)
                .filter(Predicates::hasEnoughDuration)
                .filter(Predicates::hasSinuheAsInstructor);

// La lógica es la misma:
        public final class Predicates {
            public static final boolean isAJavaCourse(Course course){
                return course.getName().contains("Java");
            }
        }*/

        //--------------------------map

        //Convertir un Stream de tipo T a un Stream de tipo V. Es posible que T y V sean el mismo tipo:


        Stream<String> namesStream = Stream.of("Sinuhe", "Brenn", "Ricardo", "Sebastian", "Luisa");
        Stream<Integer> lengthNameStream = namesStream.map(String::length);

        //--------------------------flatMap
        /*
        Como mencionamos en el modulo sobre Listeners, flatMap convierte un Stream complejo en un Stream lineal.
        Es decir, flatMap opera sobre un Stream que contenga datos "anidados" como puede ser una Collection o un Array,
        tomando una lambda que retorne otro Stream de los datos anidados y concatenando todos los datos en un solo stream.

        Si nuestro Stream inicial tenia:
        Stream{ List{ "Node.js", "JavaScript"}, List{"Android", "Kotlin"}, List{"JavaSE 8", "Java FP"}}

        Aplicar flatMap retorna:
        Stream{ "Node.js", "JavaScript", "Android", "Kotlin", "JavaSE 8", "Java FP" }
         */
        List<String> nodeCourses = Utils.getListOf("Node.js", "Express.js", "Eventloop");
        List<String> javaCourses = Utils.getListOf("Spring", "Maven", "Gradle", "Funtional");

        Stream<List<String>> coursesListStream = Stream.of(nodeCourses, javaCourses);
        Stream<String> coursesStream = coursesListStream.flatMap(Collection::stream);


        /*flatMap
        En ocasiones no podremos evitar encontrarnos con streams del tipo Stream<List<Courses>>, donde tenemos datos con muchos datos…

        Este tipo de streams es bastante común y puede pasarte por multiples motivos. Se puede tornar difícil operar el Stream inicial si queremos aplicar alguna operación a cada uno de los elementos en cada una de las listas.

                Si mantener la estructura de las listas (o colecciones) no es importante para el procesamiento de los datos que contengan, entonces podemos usar flatMap para simplificar la estructura del Stream, pasándolo de Stream<List<Courses>> a Stream<Courses>.

        Visto en un ejemplo más “visual”:

        Stream<List<Courses>> coursesLists; // Stream{List["Java", "Java 8 Functional", "Spring"], List["React", "Angular", "Vue.js"], List["Big Data", "Pandas"]}
        Stream<Courses> allCourses; // Stream{ ["Java", "Java 8 Functional", "Spring", "React", "Angular", "Vue.js", "Big Data", "Pandas"]}
        flatMap tiene la siguiente forma:

<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
        Lo interesante es que el resultado de la función mapper debe ser un Stream<R>. Stream usará el resultado de mapper para “acumular” elementos en un Stream desde otro Stream. Puede sonar confuso, por lo que ejemplificarlo nos ayudará a entenderlo mejor:

//Tenemos esta clase:
        public class PlatziStudent {
            private boolean emailSubscribed;
            private List<Email> emails;

            public boolean isEmailSubscribed() {
                return emailSubscribed;
            }

            public List<Email> getEmails(){
                return new LinkedList<>(emails); //Creamos una copia de la lista para mantener la clase inmutable por seguridad
            }
        }

//Primero obtenemos objetos de tipo usuario registrados en Platzi:
        Stream<PlatziStudent> platziStudents = getPlatziUsers().stream();

// Despues, queremos enviarle un correo a todos los usuarios pero… solo nos interesa obtener su correo para notificarlos:
        Stream<Email> allEmailsToNotify =
                platziStudents.filter(PlatziStudent::isEmailSubscribed) //Primero evitamos enviar correos a quienes no estén subscritos
                        .flatMap(student -> student.getEmails().stream()); // La lambda genera un nuevo Stream de la lista de emails de cada studiante.

        sendMonthlyEmails(allEmailsToNotify);
//El Stream final solo es un Stream de emails, sin mas detalles ni información adicional.
        flatMap es una manera en la que podemos depurar datos de información adicional que no sea necesaria.*/


        //distinct
/*
        Esta operación es simple:

        Stream<T> distinct()
        Lo que hace es comparar cada elemento del Stream contra el resto usando el método equals. De esta manera, evita
        que el Stream contenga elementos duplicados. La operación, al ser intermedia, retorna un nuevo Stream donde los
        elementos son únicos. Recuerda que para garantizar esto es recomendable que sobrescribas el método equals en tus
        clases que representen datos.*/


        //Genera un Stream de elementos unicos tomando como fuente: Object.equals
        Stream<String> heroesNamesStream = Stream.of("Peter", "Logan", "Luisa", "Clark", "Gwen", "Logan", "Peter");
        Stream<String> uniqueHeroesNamesStream = heroesNamesStream.distinct();// "Peter", "Logan", "Luisa", "Clark", "Gwen"


//
//
//
//
//
        //----------------limit
   /*   La operación limit recibe un long que determina cuántos elementos del Stream original seran preservados. Si el
        número es mayor a la cantidad inicial de elementos en el Stream, básicamente, todos los elementos seguirán en el
        Stream. Un detalle interesante es que algunas implementaciones de Stream pueden estar ordenadas (sorted()) o
        explícitamente no ordenadas (unordered()), lo que puede cambiar drásticamente el resultado de la operación y el
        performance.

        Stream<T> limit(long maxSize)

        La operación asegura que los elementos en el Stream resultante serán los primeros en aparecer en el Stream. Es
        por ello que la operación es ligera cuando el Stream es secuencial o se usó la operación unordered()
        (no disponible en todos los Streams, ya que la operación pertenece a otra clase).

        Como reto adicional, crea el código para representar lo que hace la operación limit.*/


        //Limita los elementos del Stream al numero indicado.
        Stream<String> justTwoHeroes = uniqueHeroesNamesStream.limit(2);

//
//
        //----------------------peek
        /*
        Recibe un Consumer para operar sobre cada elemento del Stream pero manteniendo el tipo del Stream
        Es una manera sencilla de hacer una operacion intermedia sobre el Stream sin alterarlo (idealmente)
         */
        Stream<String> choosenTwoHeroes = justTwoHeroes.peek(heroe -> System.out.println("Un heroe ha sido elegido:  " + heroe));
        /*
        ------------------------skip
        Esta operación es contraria a limit(). Mientras limit() reduce los elementos presentes en el Stream a un numero especifico, skip descarta los primeros n elementos y genera un Stream con los elementos restantes en el Stream.

        Esto es:

        Stream<Integer> first10Numbers = Stream.of(0,1,2,3,4,5,6,7,8,9);
        Stream<Integer> last7Numbers = first10Numbers.skip(3); // 3,4,5,6,7,8,9
        Esto puede ser de utilidad si sabemos qué parte de la información puede ser descartable. Por ejemplo, descartar la primera línea de un XML (<? xml …>), descartar metadatos de una foto, usuarios de prueba al inicio de una base de datos, el intro de un video, etc.

        ------------------sorted
        La operación sorted() requiere que los elementos presentes en el Stream implementen la interfaz Comparable para poder hacer un ordenamiento de manera natural dentro del Stream. El Stream resultante contiene todos los elementos pero ya ordenados, hacer un ordenamiento tiene muchas ventajas, te recomiendo los cursos de algoritmos de Platzi para poder conocer a mas detalle estas ventajas.

        /*
        Existen otras operaciones como sorted() que alteran el orden del Stream
        o mas especificas como las operaciones mapTo… que convierten el Stream de un tipo a otro

        Es importante entender que estas operaciones solo generan nuevos Stream con cada invocacion.
         */


    }
}
