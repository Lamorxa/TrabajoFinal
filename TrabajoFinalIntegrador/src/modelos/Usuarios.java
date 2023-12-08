/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import conexion.Conexion;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author LamorxaXD
 */
public class Usuarios{
    private int idUsuario;
    private String dni;
    private String user;
    private String contrasena;
    private String estado;

    // Aquí irían los métodos para realizar operaciones CRUD en la tabla 'usuarios'
    // Constructor, getters, setters, etc.

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Usuarios(){};
    public Usuarios(int idUsuario, String dni, String user, String contrasena, String estado) {
        this.idUsuario = idUsuario;
        this.dni = dni;
        this.user = user;
        this.contrasena = contrasena;
        this.estado = estado;
    }


}