package com.felipe.dao;

import com.felipe.database.Conexion;
import com.felipe.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public static void CrearUsuarioDB(Usuario usuario){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps=null;
            try {
                String query="insert into usuarios (correo_electronico,password,nombre) values (?,?,?)";
                ps=conexion.prepareStatement(query);
                ps.setString(1, usuario.getCorreo_electronico());
                ps.setString(2, usuario.getPassword());
                ps.setString(3, usuario.getNombre());
                ps.executeUpdate();
                System.out.println("\n usuario creado, ahora puedes iniciar sesión \n");
            } catch (SQLException e) {
                System.out.println( "\n no se pudo crear el usuario \n");
                System.out.println(e);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void listarUsuarioDB(){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps=null;
            ResultSet rs=null;
            try {
                String query="select * from usuarios";
                ps=conexion.prepareStatement(query);
                rs=ps.executeQuery();
                while(rs.next()){
                    System.out.print("\n[ID: "+rs.getString("id_usuario")+" | ");
                    System.out.print("Correo: -"+rs.getString("correo_electronico")+" | ");
                    System.out.print("Nombre: "+rs.getString("nombre")+" ] ");
                }
            } catch (SQLException e) {
                System.out.println("\n no se pudo listar los usuarios \n");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void editarUsuarioDB(Usuario usuario){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps=null;
            try {
                String query="UPDATE usuarios set correo_electronico = ?, password = ?, nombre = ? where id_usuario = ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, usuario.getCorreo_electronico());
                ps.setString(2, usuario.getPassword());
                ps.setString(3, usuario.getNombre());
                ps.setInt(4, usuario.getId_usuario());
                ps.executeUpdate();
                System.out.println("\n usuario actualizado \n");
            } catch (SQLException e) {
                System.out.println("\n no se pudo actualizar el usuario \n");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static Usuario loginDB(Usuario usuario){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection();){
            PreparedStatement ps=null;
            ResultSet rs=null;
            try {
                String query="SELECT * FROM usuarios where correo_electronico=? and password= ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, usuario.getCorreo_electronico());
                ps.setString(2, usuario.getPassword());
                rs=ps.executeQuery();
                Usuario login = new Usuario();
                if(rs.next()){
                    System.out.println("login correcto!");
                    login.setId_usuario(rs.getInt("id_usuario"));
                    login.setCorreo_electronico(rs.getString("correo_electronico"));
                    login.setNombre(rs.getString("nombre"));
                }else{
                    System.out.println("login fallo");
                }
                //retornamos el objeto usuario con los datos o vacío
                return login;
            } catch (SQLException e) {
                System.out.println("\n no se pudo autenticar con el servidor \n");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        //si no se logra iniciar sesión devolvemos un objeto vacío
        return null;
    }

}
