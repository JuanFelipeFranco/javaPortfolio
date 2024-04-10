package com.platzi.functional._09_defaults;

public class StringFunctions {
    @FunctionalInterface
    interface StringOperation {
        //metodo que devuelve un entero
        int getAmount();

        //metodo abstracto  tiene una definicion, default nos permite definir un cuerpo para un metodo que vamos a usar en la interface
        default void operate(String text){
            //obtener un numero a partir de la otra funcion
            int x = getAmount();

            while (x-- > 0 ){
                System.out.println(text);
            }

        }

    }

    @FunctionalInterface
    interface DoOperation{
        //va a tomar un texto.
        void take(String text);

        //internamente daremos un default en el cual llamaremos execute que tomara un entero
        default void execute(int x, String text){
            while ( x-- > 0){
                take(text);
            }
        } // de esta forma ahora se puede crear una operacion.

    }
    public static void main(String[] args) {
        //hacemos una funcion de la interfaz
        StringOperation six = () -> 6;
        six.operate("Hola");

        //creando la operacion que lo que va hacer es tomar un texto e imprimirlo
        DoOperation operate = text -> System.out.println(text);
        operate.execute(2,"Pla");
    }



}
