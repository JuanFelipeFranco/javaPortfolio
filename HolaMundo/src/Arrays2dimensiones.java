public class Arrays2dimensiones {
    public static void main(String[] args) {
        int [][] tabla = new int[4][5];

        tabla[0][0]=15;
        tabla[0][1]=21;
        tabla[0][2]=18;
        tabla[0][3]=9;
        tabla[0][4]=15;

        tabla[1][0]=10;
        tabla[1][1]=52;
        tabla[1][2]=17;
        tabla[1][3]=19;
        tabla[1][4]=7;

        tabla[2][0]=19;
        tabla[2][1]=2;
        tabla[2][2]=19;
        tabla[2][3]=17;
        tabla[2][4]=7;

        tabla[3][0]=92;
        tabla[3][1]=13;
        tabla[3][2]=13;
        tabla[3][3]=32;
        tabla[3][4]=41;

/*Entra al bucle for i, donde i =0 inicia asi y cumple la condicion de ser menor que 4, despues entra
al bucle de j, alli j es igual a 0, y cumple la condicion de ser menor que 5 entonces ejecuta la impresion, el bucle vuelve y repite
los de j ya este debe repetirse hasta que j es = 5 alli sale y entra al bucle i.
  */
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 5; j++) {
                System.out.print(tabla[i][j]+" ");
            }
        }
    }
}
