package com.platzi.javatests.Reto;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {
    @Test
    public void string_is_not_empty(){
        assertFalse(StringUtil.isEmpty("Felipe"));
    }
    @Test
    public void empty_qoute_is_string_empty(){
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void null_is_string_empty(){
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void String_space_is_string_empty(){
        assertTrue(StringUtil.isEmpty(" "));
    }

}