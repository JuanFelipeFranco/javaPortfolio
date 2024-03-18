package com.platzi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection get_connection(){
        Connection conection = null;
        try{
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes.app","root","");
            if (conection != null){
                System.out.println("conexion exitosa");
            }
        }catch(SQLException e) {
            System.out.println(e);
        }
        return conection;

    }
}
