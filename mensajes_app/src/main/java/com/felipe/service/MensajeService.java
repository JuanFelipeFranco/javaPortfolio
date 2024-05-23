package com.felipe.service;

import com.felipe.dao.MensajeDAO;
import com.felipe.model.Mensaje;
import com.felipe.model.Usuario;

import java.util.Scanner;

//la capa intermedia entre el menu principal y la capa de acceso
public class MensajeService {
    public static void crearMensaje(Usuario usuario, Scanner sc) {
        System.out.println("Escribe tu mensaje");
        String mensajeTexto = sc.next();
        Mensaje mensaje = new Mensaje(mensajeTexto, usuario.getId_usuario());

        MensajeDAO.crearMensajeDB(mensaje);
    }
    public static void listarMensaje() {
        MensajeDAO.listarMensajeDB();
    }
    public static void borrarMensaje(Usuario usuario, Scanner sc) {
        System.out.println("indica el ID del mensaje a borrar");
        int id_mensaje = sc.nextInt();
        Mensaje mensaje = new Mensaje(id_mensaje,usuario.getId_usuario());

        MensajeDAO.borrarMensajeDB(mensaje);
    }


}
