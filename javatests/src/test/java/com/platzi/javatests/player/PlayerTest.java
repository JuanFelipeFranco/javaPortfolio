package com.platzi.javatests.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void looses_when_dice_number_is_too_low(){
        //eliminamos la instancia y creamos un mock del dice un dado simulado
        Dice dice = Mockito.mock(Dice.class);
        //como hacer para que el dado nos devuelva un numero en especifico
        //ejemplo si el jugador gana con un 3 pero el dado saca un 2 entonces va perder. para simular usamos lo siguiente
        Mockito.when(dice.roll()).thenReturn(2); //cuando el dado haga un roll devuelva el dos; esta forzando a que siempre cae en 2

        //en este caso como el dado siempre es obligado a que sea dos y el numero que estoy dando como jugador es 3
        //siempre voy a perder como jugador y lo que espero es false entonces siempre el test va pasar
        //el valos minimo que espero es 3 y esta cayendo en 2 siempre voy a perder

        Player player = new Player(dice,3);
        assertFalse(player.play());
    }
    @Test
    public void looses_when_dice_number_is_big(){
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);

        //el numero minimo para ganar es 3 y como el dado lo obligamos a caer en 4 entonces estamos con un numero mayor por ende estamos esperando que gane
        //colocamos true porque estamos ganando
        Player player = new Player(dice,3);
        assertTrue(player.play());
    }


}