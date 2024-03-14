public class ArraysEjemplo4 {
    public static void main(String[] args) {
        double acumulado;
        double interes = 0.10;

        double [][] saldo = new double[6][5];

        for (int i = 0; i < 6; i++) {
            //se deja en el i0 la variable con que iniciamos siempre es igual
            saldo[i][0]=10000; //para que no me mueva kla segunda dimesion se coloca el valor.
            acumulado = 10000;

            //inicia en 1 porque el 0 esta establecido que es 10000
            for (int j = 1; j < 5; j++) {
                acumulado =  acumulado + (acumulado *interes);
                saldo[i][j]=acumulado;
            }

            //declaramos la variable interes por fuera debido a que es la que va aunmentando en 1% = 0.01
            interes = interes + 0.01;

        }
            //ciclo for para leer y mostrar en pantalla
            for(int z=0; z<6; z++){
                System.out.println();
                for (int h = 0; h < 5 ; h++) {
                    System.out.printf("%1.2f", saldo[z][h]);
                    System.out.print(" ");
                    //imprimimos con format donde dejamos que imprima con 2 decimales al final
                }
        }
    }
}
