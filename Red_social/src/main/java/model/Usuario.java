package model;

public class Usuario {
    //atributos
    int id_usuario;
    String correo_electronico;
    String password;
    String nombre;

    //constructores
    public Usuario() {
    }

    //constructor para borrar usuario
    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    //constructor para iniciar sesión
    public Usuario(String correo_electronico, String password) {
        this.correo_electronico = correo_electronico;
        this.password = password;
    }

    //constructor para traer datos de inicio de sesión
    public Usuario(int id_usuario, String correo_electronico, String nombre) {
        this.id_usuario = id_usuario;
        this.correo_electronico = correo_electronico;
        this.nombre = nombre;
    }

    //constructor para crear, editar usuario
    public Usuario(int id_usuario, String correo_electronico, String password, String nombre) {
        this.id_usuario = id_usuario;
        this.correo_electronico = correo_electronico;
        this.password = password;
        this.nombre = nombre;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
