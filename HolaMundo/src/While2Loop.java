import javax.swing.*;
//programa que el usuario adivina la contrasena, mientras no sean iguales va generar la pestana para que el usuario digite, solo se va salir de la pestana cuando adivine la contrasena
public class While2Loop {
    public static void main(String[] args) {
        //acceso aplicacion
        String clave = "Juan";
        String password = "";

        //equals compara dos cadenas de texto si son iguales
        //evalua si la cadena de texto clave es igual a password
        //como clave y password no son iguales al entrar al ciclo por eso colocamos falso
        while (clave.equals(password) == false){
            //mientras clave sea diferente a password va sacar la ventana, esta se va almacenando en la variable passsword
            password = JOptionPane.showInputDialog("Introduce la contrasena");
            if (clave.equals(password)==false){
                System.out.println("Contrasena inconrrecta");
            }
        }
        System.out.println("contrasena correcta. Acceso permitido");
    }
}
