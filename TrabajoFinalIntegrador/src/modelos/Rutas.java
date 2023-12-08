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

   public class Rutas {
    private int idRuta;
    private String nombreRuta;
    private double montoRuta;
    private String estado;

    // Aquí irían los métodos para realizar operaciones CRUD en la tabla 'rutas'
    // Constructor, getters, setters, etc.

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public double getMontoRuta() {
        return montoRuta;
    }

    public void setMontoRuta(double montoRuta) {
        this.montoRuta = montoRuta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Rutas(){};
    public Rutas(int idRuta, String nombreRuta, double montoRuta, String estado) {
        this.idRuta = idRuta;
        this.nombreRuta = nombreRuta;
        this.montoRuta = montoRuta;
        this.estado = estado;
    }

    
    
}



