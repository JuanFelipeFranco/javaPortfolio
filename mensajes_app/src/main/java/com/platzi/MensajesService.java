package com.platzi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//la capa intermedia entre el menu principal y la capa de acceso
public class MensajesService {
    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("tu nombre");
        String nombre = sc.nextLine();


        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);

        MensajesDAO.crearMensajeDB(registro);
    }
    public static void listarMensajes() {
        MensajesDAO.leerMensajeDB();
    }
    public static void borrarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("indica el ID del mensaje a borrar");
        int id_mensaje = sc.nextInt();

        MensajesDAO.borrarMensajeDB(id_mensaje);
    }
    public static void editarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo Mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Indica el id del mensaje a editar");
        int id_mensaje = sc.nextInt();

        Mensajes actualizacion = new Mensajes();
        actualizacion.setMensaje(mensaje);
        actualizacion.setId_mensaje(id_mensaje);

        MensajesDAO.actualizarMensajeDB(actualizacion);
    }


}
