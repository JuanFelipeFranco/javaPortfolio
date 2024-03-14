import javax.swing.*;

//ejemplo de crear un programa donde vamos a hacer un factorial del numero que escojamos.
public class For4Loop {
    public static void main(String[] args) {

            long resultado = 1L;
            //variable que solicita el numero al usuario por medio de ventana, esta variable le vamos hacer  factorial.
            int numero=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero: "));

            //ciclo donde el iterador inicia en el numero ingresado y va disminuyendo mientras se multiplica
            for(int i=numero; i>0; i--){
                resultado = resultado * i;
            }

            System.out.println("el factorial de "+numero+" es "+resultado);
    }
}
/* Vamos a ingresar un numero, que es nuestro iterador, entra a la condicion si es mayor a 0, como cumple entonces multiplica resultado por el
* numero ingresado, en el primer caso es 1*numero ingresado, y ya nuestra variable resultado queda con este valor y vuelve al ciclo de nuevo, si
* cumple que sigue siendo mayor a 0 multipkica el resultado anterior por el nuevo iterador i-1, y asi hasta que i es igual a 0 y ya no cumple la condicion*/
