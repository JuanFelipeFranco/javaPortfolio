package com.platzi.javatests.Reto;
/*En una aplicación que estamos construyendo, nos hemos dado cuenta de que comprobamos muchas veces si un
string está vacío o no. Implementa esta función, y crea una clase StringUtilTest añadiendo tests que prueben varios escenarios:
Probar que un string cualquiera no es vacío
Probar que “” es un string vacío
Probar que null también es un string vacío
Extra: un string con espacios " " también lo queremos considerar como vacío (pista: puedes usar la función trim)*/
public class StringUtil {
    public static boolean isEmpty (String str) {
        return str == null || str.trim().equals("");
    }
}
