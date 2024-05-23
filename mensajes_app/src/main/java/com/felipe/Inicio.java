package com.felipe;
import com.felipe.model.Usuario;
import com.felipe.service.UserService;

import java.util.Scanner;

public class Inicio {
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



        /*int opcion =0;
        do {
            System.out.println("-----------------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. listar mensajes");
            System.out.println("3. eliminar mensaje");
            System.out.println("4. editar mensaje");
            System.out.println("5. Salir");

            //leemos la opcion del usuario
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.borrarMensaje();
                    break;
                case 4:
                    MensajesService.editarMensaje();
                    break;
                default:
                    break;
            }
        }while (opcion !=5);*/


        /*Conexion conexion = new Conexion();
        try(Connection cnx = conexion.get_connection()){

        }catch (Exception e){
            System.out.println(e);
        }*/

