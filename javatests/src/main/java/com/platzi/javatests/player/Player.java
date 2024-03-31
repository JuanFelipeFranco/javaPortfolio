package com.platzi.javatests.player;

public class Player {
    private Dice dice; //creamos un campo de la clase

    //suponemos que el jugador gana dependiendo de un cierto numero.
    private int minNumberToWin;

    public Player(Dice dice, int minNumberToWin) {
        this.dice = dice;
        this.minNumberToWin = minNumberToWin;
    }

    public boolean play() {
        int diceNumber = dice.roll(); //obtiene el valor resultante del dado.

        //el jugador gana cuando el numero sea mayor o igual que el mismo numero para ganar
        return diceNumber > minNumberToWin;
    }
}
