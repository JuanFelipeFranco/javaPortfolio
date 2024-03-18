package com.platzi;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static void leerMensajeDB(){

    }

    public static void borrarMensajeDB(int id_mensaje){

    }

    public static void actualizarMensajeDB(Mensajes mensaje){

    }
}
