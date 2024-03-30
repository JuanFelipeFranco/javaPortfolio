package com.platzi.javatests.util;
public class StringUtilTest {
    public static void main(String[] args) {
        //refactorizado
        assertEquals(StringUtil.repeat("hola",3),"holaholahola");

        String result2 = StringUtil.repeat("hola",1);
        assertEquals(result2,"hola");

       /* if (result2.equals("hola")){
            System.out.println("OK");
        }
//        System.out.println(result2);*/

    }

    private static void assertEquals(String actual, String expected) {
        if (!actual.equals(expected)){
            throw new RuntimeException(actual +" is not equal to expected "+expected);
//            System.out.println("OK");
        }


    }

}