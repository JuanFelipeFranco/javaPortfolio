package com.platzi;
import java.sql.Connection;
import java.sql.SQLException;
public class Inicio {
    public static void main(String[] args) {

        Conexion conexion = new Conexion();
        try(Connection cnx = conexion.get_connection()){

        }catch (Exception e){
            System.out.println(e);
        }


    }
}
