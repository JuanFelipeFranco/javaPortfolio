import javax.swing.*;

//va a evaluar una direccion de correo electronico.
public class For3Loop {
    public static void main(String[] args) {
        int arroba=0;
        boolean punto =false;
        String mail = JOptionPane.showInputDialog("Introduce E-Mail ");
//vamos a recorrer desde el caracter 0 hasta el final usando el metodo length
        for (int i = 0; i < mail.length(); i++) {
/*mail.charAt(i) lo que hacemos es que vamos a recorrer cada caracter de mail, empezamos en que i es igual a 0 y asi va
recorriendo cada una y si hay un @, la i va ir incrementando y evaluando hasta el final, si encuentra el @ entonces la
variable arroba va cambiar a True.
*/
            if(mail.charAt(i)=='@'){
                arroba ++;
            }

            if(mail.charAt(i)=='.'){
                punto = true;
            }
        }
        if(arroba == 1 && punto==true){
            System.out.println("Es Correcto");
        }else {
            System.out.println("No es correcto");
        }
    }
}
