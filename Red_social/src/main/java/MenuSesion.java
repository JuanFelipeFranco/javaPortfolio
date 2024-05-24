import model.Usuario;
import service.MensajeService;
import service.UserService;

import java.util.Scanner;

public class MenuSesion {
    public static void menuSesion(Usuario usuario, Scanner sc){
        int opcion = 0;
        String sessionMenuMensaje = ("=================== \n"
                + "\n red social, hola \n"
                + "1. escribir mensaje \n"
                + "2. leer mensajes \n"
                + "3. eliminar mensaje \n"
                + "4. editar perfil \n"
                + "5. ver usuarios \n"
                + "6. cerrar sesión \n");

        //menu when session starts
        do{
            System.out.println(sessionMenuMensaje);
            //Read user input
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    MensajeService.crearMensaje(usuario, sc);
                    break;
                case 2:
                    MensajeService.listarMensaje();
                    break;
                case 3:
                    MensajeService.borrarMensaje(usuario, sc);
                    break;
                case 4:
                    UserService.editarUsuario(usuario, sc);
                    break;
                case 5:
                    UserService.listaUsuarios();
                    break;
                default:
                    break;
            }
        }while(opcion != 6);
    }
}
