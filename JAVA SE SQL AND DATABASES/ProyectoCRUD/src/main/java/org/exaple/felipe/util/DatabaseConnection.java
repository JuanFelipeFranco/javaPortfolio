package org.exaple.felipe.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String url="jdbc:mysql://localhost:3306/project";
    private static String user="root";
    private static String pass="admin";

    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException {
        if (pool == null){
            pool = new BasicDataSource();
            //configuration of connection
            pool.setUrl(url);
            pool.setUsername(user);
            pool.setPassword(pass);

            //parameters pool
            pool.setInitialSize(3); //tamaño inicial del pool de conexiones
            pool.setMinIdle(3); //numero minimo de conexiones inactivas
            pool.setMaxIdle(10); //establece el numero maximo de conexiones inactivas que se van a mantener
            pool.setMaxTotal(10);//el numero de conexiones totales que el pool puede mantener activas simultaneamente
        }
        return pool;
    }

    //metodo que va a obtener una solo conexion del pool
    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
