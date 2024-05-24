import model.Usuario;
import service.UserService;

import java.util.Scanner;

public class inicio {
    static String MenuPrincipalMensajes = ("=================== \n"
            + "\n Mini red social \n"
            + "1. Registrarse \n"
            + "2. Iniciar sesión \n"
            + "3. salir \n");
    public static void main(String[] args) {
        //create an instance of Scanner class to read user input
        Scanner sc = new Scanner(System.in);
        MenuPrincipal(sc);
        sc.close();
    }

    public static void MenuPrincipal(Scanner sc) {
        int opcion = 0;

        //First Menu
        do{
            System.out.println(MenuPrincipalMensajes);
            //Read user input
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    UserService.crearUsuario(sc);
                    break;
                case 2:
                    Usuario usuario = UserService.login(sc);
                    if(usuario.getId_usuario() > 0){
                        MenuSesion.menuSesion(usuario, sc);
                    }
                    break;
                default:
                    break;
            }
        }while(opcion != 3);
    }
}



