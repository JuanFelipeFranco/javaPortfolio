package com.felipe.service;

import com.felipe.dao.MensajeDAO;
import com.felipe.model.Mensaje;

import java.util.Scanner;

//la capa intermedia entre el menu principal y la capa de acceso
public class MensajeService {
    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensajeTexto = sc.nextLine();

        System.out.println("Tu nombre");
        String nombre = sc.nextLine();

        Mensaje mensaje = new Mensaje();
        mensaje.setMensaje(mensajeTexto);
        mensaje.setAuthor_mensaje(nombre);

        MensajeDAO.crearMensajeDB(mensaje);
    }
    public static void listarMensaje() {
       MensajeDAO.leerMensajeDB();
    }
    public static void borrarMensaje() {
        Scanner sc = new Scanner(System.in);
       System.out.println("indica el ID del mensaje a borrar");
        int id_mensaje = sc.nextInt();

        MensajeDAO.borrarMensajeDB(id_mensaje);
    }

    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Indica el ID del mensaje a editar");
        int id_mensaje = sc.nextInt();
        Mensaje actualizacion = new Mensaje();
        actualizacion.setId_mensaje(id_mensaje);
        actualizacion.setMensaje(mensaje);
        MensajeDAO.actualizarMensajeDB(actualizacion);
    }

}
