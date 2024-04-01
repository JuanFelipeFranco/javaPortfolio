package com.platzi.javatests.Reto;

import com.platzi.javatests.util.DateUtil;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class FizzBuzzShould {
   /* -Si el número es divisible por 3, retorna “Fizz”
    Si el número es divisible por 5, retorna “Buzz”
    Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
    En otro caso, retorna el mismo número*/

    @Test
    public void return_Fizz_when_numero_is_divisible_by_3(){
        assertThat(FizzBuzz.fizzBuzz(3), is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(6), is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(9), is("Fizz"));
    }
    @Test
    public void return_Buzz_when_numero_is_divisible_by_5(){
        assertThat(FizzBuzz.fizzBuzz(5), is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(10), is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(20), is("Buzz"));
    }
    @Test
    public void return_FizzBuzz_when_numero_is_divisible_by_3_and_5(){
        assertThat(FizzBuzz.fizzBuzz(15), is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(30), is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(45), is("FizzBuzz"));
    }
    @Test
    public void return_numero_when_numero_not_is_divisible_by_3_and_5(){
        assertThat(FizzBuzz.fizzBuzz(16), is("16"));
        assertThat(FizzBuzz.fizzBuzz(2), is("2"));
        assertThat(FizzBuzz.fizzBuzz(8), is("8"));
    }





}