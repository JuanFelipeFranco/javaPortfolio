import java.util.Scanner;
/*Usamos el ejemplo anterior, en el anterior no tuvimos en cuenta que de entrada podia
* el numero aleatorio y la variable numero iguales (0) por ende no entraria a evaluar al ciclo
* en este caso vamos a transformarlo a DO WHILE donde lo evalua una vez por lo menos.
*  */
public class DoWhile2Loop {
    public static void main(String[] args) {
        int aleatorio = (int)(Math.random()*100);
        Scanner entrada = new Scanner(System.in);
        int numero = 0;
        int intentos = 0;

        //en este caso lo ejecuta por lo menos una vez con el Do. se ejecutara al menos una vez
        //seguido de ello  entre al while y mira que la condicio de numero y aleatorio son diferentes entonces se repite el ciclo.

        do{
            intentos++;
            System.out.println("Introduce un numero: ");
            numero = entrada.nextInt();

            if(aleatorio < numero){
                System.out.println("Mas bajo");
            } else if (aleatorio > numero) {
                System.out.println("Mas alto");
            }
        } while(numero != aleatorio);
        System.out.println("Correcto. lo has conseguido en "+intentos+" intentos");
    }
}
