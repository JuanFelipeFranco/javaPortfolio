package com.platzi.javatests.player;

import java.util.Random;

public class Dice {
    private int sides; //el numero de caras del dado.

    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll(){
        //nextint es para dar un limite entre 0 y el limite que marcamos; en este caso si sides es 6 nos dara entre 0 y 5 por eso +1
        return new Random().nextInt(sides)+1;//el dado nos dara un numero 1-6 depende las caras que tenga el dado.
    }
}
