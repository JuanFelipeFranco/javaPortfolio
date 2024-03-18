package com.platzi;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//son los metodos que nos van a permitir la conexion con la base de Datos.
public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps=null;
            try{
                String query = "INSERT INTO `mensajes` (`mensaje`, `author_mensaje`) VALUES (?,?)";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate(); //METODO que da la instruccion a la base de datos para ejecutar la consulta de la linea 14(query)
                System.out.println("Mensaje Creado");

            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void leerMensajeDB() {
        Conexion db_connect = new Conexion();

        PreparedStatement ps = null; //NOS PERMITE PREPARAR LA SENTENCIA
        ResultSet rs = null; //Nos permite traer los datos en filas para mostrarlos.

        try (Connection conexion = db_connect.get_connection()) {
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();//ejecuta la consulta, y en este caso solicita datos.

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensajes"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("author_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(e);
        }

    }

    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM mensajes WHERE `id_mensajes` = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1,id_mensaje);
                ps.executeUpdate();
                System.out.println("Mensaje Eliminado");

            }catch (SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo borrar el mensaje");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try{
                String query = "UPDATE mensajes SET mensaje = ? WHERE `id_mensajes` = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setInt(2,mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje se acualizo correctamente");
            }
            catch (SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo actualizar el mensaje");
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }
}
