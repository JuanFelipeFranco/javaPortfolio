import java.util.Scanner;

//juego de adivinar numero
/* un juego donde vamos a adivinar un numero del 0 al 100, digitaremos un numero y
* el programam ira dando pistas si es mayor o menor.
* usaremos metodo random: random nos genera numeros entre 0 y 1, para ir acomodando debemos multiplicar en este caso x 100
* */
public class While3LoopAdivinaNumero {
    public static void main(String[] args) {
        //se escoge un numero de 1  100 con la clase random, se debe multiplicar por 100 debido a que random viene de 0 a 1
        int aleatorio = (int)(Math.random()*100);
        //se va a ejecutar por consola, los intenots y el numero arranca en 0, por ende es diferente de entrada al que genera random
        Scanner entrada = new Scanner(System.in);
        int numero = 0;
        int intentos = 0;

        /**
         * Descripcion: Juego donde la maquina escoge un numero aleatorio y el usuario va digitando para acertar, el programa genera pistas si es mas alto o bajo
         * @param numero es el numero que el usuario va ingresando
         * @param intentos es la cantidad de intentos que ha hecho el usuario para adivinar el numero
         * @param aleatorio es el numero aleatorio que escoge la maquina
         * */

        /* el ciclo while inicia que aleatorio y numero son diferentes
        cada numero que vamos digitando va ir aumentando los intentos, el entra al ciclo y evalua si es menor o mayor al aleatorio nos da la pista
        y como sigue siendo diferente vuelve al ciclo, y se va repitiendo hasta que acertamos entonces numero ya es igual a aleatorio y sale del ciclo
        y nos da el mensaje que acertamos en los intentos que hicimos
        * */
        while(numero != aleatorio){
            intentos++;
            System.out.println("Introduce un numero: ");
            numero = entrada.nextInt();

            if(aleatorio < numero){
                System.out.println("Mas bajo");
            } else if (aleatorio > numero) {
                System.out.println("Mas alto");
            }
        }
        System.out.println("Correcto. lo has conseguido en "+intentos+" intentos");
    }
}
