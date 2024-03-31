package com.platzi.javatests.util;

public class PasswordUtil {
    public enum SecurityLevel{
        //se coloca una enumeracion donde hay 3 posibles valores; cuando estan muy concetados los valores posibles debemos usar una enumeracion y los casos posibles.
        WEAK,MEDIUM,STRONG
    }
    public static SecurityLevel assessPassword(String password){

        if (password.length()< 8){
            return SecurityLevel.WEAK;
        }
        //si password tiene letras, colocamos la funcion matches, donde le colocamos una expresion regular.
        //"[a-zA-z]" esta expresion nos dice que puede contener letras de la a a la z en minuscula y mayuscula y el + que puede contener varias veces estas letras
        if (password.matches("[a-zA-Z]+")){
            return SecurityLevel.WEAK;
        }
        //"[a-zA-z0-9]+" puede contener letras manusculas y minusculas, numeros del 0-9 y que se pueden repetir letras o numeros.
        if(password.matches("[a-zA-Z0-9]+")){
            return SecurityLevel.MEDIUM;
        }

        return SecurityLevel.STRONG;
    }
}
