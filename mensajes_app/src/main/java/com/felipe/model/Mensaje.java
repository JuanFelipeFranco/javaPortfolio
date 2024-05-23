package com.felipe.model;
//Clase que tiene la estructura para hacer las operaciones.
public class Mensaje {
    //Atributos
    int id_mensaje;
    String mensaje;
    String fecha;
    String nombre;

    //foreign attributes
    int id_usuario;

    //Constructores
    public Mensaje() {
    }

    //delete message by Id
    public Mensaje(int id_mensaje, int id_usuario) {
        this.id_mensaje = id_mensaje;
        this.id_usuario = id_usuario;
    }

    //create message
    public Mensaje(String mensaje, int id_usuario) {
        this.mensaje = mensaje;
        this.id_usuario = id_usuario;
    }

    //list messages
    public Mensaje(int id_mensaje, String mensaje, String fecha, String nombre) {
        this.id_mensaje = id_mensaje;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.nombre = nombre;
    }

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
