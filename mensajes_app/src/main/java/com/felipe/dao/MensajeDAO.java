package com.felipe.dao;

import com.felipe.database.Conexion;
import com.felipe.model.Mensaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//son los metodos que nos van a permitir la conexion con la base de Datos.
public class MensajeDAO {
    public static void crearMensajeDB(Mensaje mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps=null;
            try{
                String query = "INSERT INTO mensajes (id_usuario,mensaje, fecha) VALUES (?,?,CURRENT_TIMESTAMP)";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, mensaje.getId_usuario());
                ps.setString(2, mensaje.getMensaje());
                ps.executeUpdate(); //METODO que da la instruccion a la base de datos para ejecutar la consulta de la linea 14(query)
                System.out.println("Mensaje Creado");

            }catch (SQLException ex){
                System.out.println(ex);
                System.out.println("Mensaje No creado");
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void listarMensajeDB() {
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null; //NOS PERMITE PREPARAR LA SENTENCIA
            ResultSet rs = null; //Nos permite traer los datos en filas para mostrarlos.
            try {
                String query = "SELECT m.id_mensaje,m.mensaje,m.fecha,u.nombre from mensajes m join usuarios u on m.id_usuario=u.id_usuario";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();//ejecuta la consulta, y en este caso solicita datos.

                while (rs.next()) {
                    System.out.println("\n[ID: " + rs.getInt("id_mensaje")+" | ");
                    System.out.println("Mensaje: " + rs.getString("mensaje")+" | ");
                    System.out.println("Fecha: " + rs.getString("fecha")+" | ");
                    System.out.println("Nombre: " + rs.getString("nombre")+" ] ");
                }
            } catch (SQLException e) {
                System.out.println("No se pudieron recuperar los mensajes");
                System.out.println(e);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }

    }

    public static void borrarMensajeDB(Mensaje mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ? AND id_usuario = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1,mensaje.getId_mensaje());
                ps.setInt(2,mensaje.getId_usuario());
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
}
