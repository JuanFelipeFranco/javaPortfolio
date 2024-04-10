package com.platzi.functional._10_chaining;

public class Encadenamiento {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hola")
                .append("world")
                .append("soy")
                .append("Felipe");

        Chainer chainer =new Chainer();

        Chainer chainer2 = chainer.sayHi();
        Chainer chainer3 = chainer2.sayBye();

        //llamando los dos al tiempo
        chainer.sayBye().sayHi();
    }

    static class Chainer{
        public Chainer sayHi(){
            System.out.println("Hola");
            return this;
        }

        public Chainer sayBye(){
            System.out.println("Bye");
            return this;
        }
    }
}

/*Chaining o Encadenamiento
El Chaining o encadenamiento consiste en hacer llamadas consecutivas a diferentes metodos de un mismo objeto.
Un ejemplo claro es al utilizar la clase StringBuilder, esta permite encadenar llamadas al objeto creado inicialmente
para manipular la creación de un String.

StringBuilder stringBuilder = new StringBuilder();
String s = stringBuilder.append("Hola") // Agrega el texto "Hola"
        .append(" world")               // Agrega el texto " world"
        .delete(5, 10)                  // Borra el texto "world" (por índices)
        .append("mundo")                // Agrega el texto "mundo"
        .reverse()                      // Invierte el texto
        .toString();                    // Lo convierte a String (termina la cadena)
System.out.println(s);                  // Imprime "odnum aloH"
La explicación detrás de este comportamiento es que cada una de las funciones aplica el cambio correspondiente y devuelve una referencia al mismo objeto (return this;), lo que hace posible llamar otra función sin perder el cambio realizado en la anterior.*/
