package org.exaple.felipe.main;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
         String url = "jdbc:mysql://localhost:3306/project";
         String user = "root";
         String pass = "admin";

        try (
            //1. conexion a nuestra base de datos, pasando 3 argumentos
            Connection myConn = DriverManager.getConnection(url, user, pass);
            //2. Crear una declaracion objeto
            Statement myStamt = myConn.createStatement();
            //3. Ejecutar consulta SQL
            ResultSet myRes = myStamt.executeQuery("SELECT * FROM employees");){

                while (myRes.next()) {
                    System.out.println(myRes.getString("first_name"));
                }
        }
                catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("algo salio mal");
                }
            }
 }

