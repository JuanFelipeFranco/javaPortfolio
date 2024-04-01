package com.platzi.javatests.util;

import org.junit.Test;

import static com.platzi.javatests.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {
    @Test
    public void weak_when_has_less_than_8_letters(){
        //comprobar que un pass es debil cuando tiene menos de 8 digitos.
        assertEquals(WEAK,PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void weak_when_has_only_letters(){
        //comprobar que un pass es debil cuando tiene solo letras.
        assertEquals(WEAK,PasswordUtil.assessPassword("abcdefgh"));
    }

    @Test
    public void medium_when_has_letters_and_numbers(){
        //comprobar que un pass es medio cuando tiene letras y numeros y son mayor o igual a 8 digitos .
        assertEquals(MEDIUM,PasswordUtil.assessPassword("abcd1234"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_symbols(){
        //comprobar que un pass es fuerte cuando tiene mas de 8 digitos, contiene letras numeros y digitos.
        assertEquals(STRONG,PasswordUtil.assessPassword("abcd12340$"));
    }




}