package com.platzi.functional._09_defaults;

public class StringFunctions {
    @FunctionalInterface
    interface StringOperation {
        //metodo que devuelve un entero
        int getAmount();

        //metodo abstracto que NO tiene una definicion, default nos permite definir un cuerpo para un metodo que vamos a usar en la interface
        default void operate(String text){
            //obtener un numero a partir de la otra funcion
            int x = getAmount();

            while (x-- > 0 ){
                System.out.println(text);
            }

        }

    }

    public static void main(String[] args) {
        //hacemos una funcion de la interfaz
        StringOperation six = () -> 6;
        six.operate("Hola");
    }


}
