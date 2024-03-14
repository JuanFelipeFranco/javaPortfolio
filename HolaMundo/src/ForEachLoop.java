import javax.swing.*;

public class ForEachLoop {
    public static void main(String[] args) {
        String [] paises = new String[8];

        /*paises[0]="Espana";
        paises[1]="Mexico";
        paises[2]="Colombia";
        paises[3]="Peru";
        paises[4]="Chile";
        paises[5]="Argentina";
        paises[6]="Ecuador";
        paises[7]="Venezuela";*/

        /*for (int i = 0; i < paises.length; i++) {
            System.out.println("Pais "+(i+1)+" "+paises[i]);;
        }*/

        //rellena la matriz de los paises que vamos ingresando por ventana
        for (int i = 0; i < 8; i++) {
            paises[i] = JOptionPane.showInputDialog("Introduce pais: "+ (i+1));

        }
        //recorre la matriz rellenada por el bucle que ingresamos por ventana
        for (String elemento:paises){
            System.out.println(elemento);
        }
    }
}
