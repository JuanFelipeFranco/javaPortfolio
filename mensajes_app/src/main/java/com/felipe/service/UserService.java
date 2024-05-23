package com.felipe.service;

import com.felipe.dao.UsuarioDAO;
import com.felipe.model.Usuario;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.Scanner;

public class UserService {
    public static void crearUsuario(Scanner sc){
        System.out.println("indica tu nombre completo");
        String nombre = sc.nextLine();

        System.out.println("indica tu email");
        String correo_electronico = sc.nextLine();

        System.out.println("indica tu password");
        String password = sc.nextLine();

//        password = getMd5Hash(password);

        Usuario nuevoUsuario = new Usuario(0, correo_electronico, password, nombre);
        UsuarioDAO.CrearUsuarioDB(nuevoUsuario);
    }

    public static void listaUsuarios(){
        UsuarioDAO.listarUsuarioDB();
    }

    public static void editarUsuario(Usuario usuario, Scanner sc) {
        System.out.println("indica tu nombre completo");
        String nombre = sc.nextLine();
        System.out.println("indica tu email");
        String correo_electronico = sc.nextLine();
        System.out.println("indica tu password");
        String password = sc.nextLine();

        String passwordHashed = (password);
        Usuario actualizazrUsuario = new Usuario(usuario.getId_usuario(), correo_electronico, passwordHashed, nombre);
        UsuarioDAO.editarUsuarioDB(actualizazrUsuario);
    }

//    public static String getMd5Hash(String password){
//        return DigestUtils.md5Hex(password);
//    }

    public static Usuario login(Scanner sc){
        //create an instance of Scanner class to read user input
        System.out.println("indica tu email");
        String correo_electronico= sc.next();
        System.out.println("indica tu password");
        String password = sc.next();

//        String passwordHashed = getMd5Hash(password);

        Usuario login = new Usuario(correo_electronico, password);
        Usuario result = UsuarioDAO.loginDB(login);
        return result;
    }
}
