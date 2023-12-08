/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;


import conexion.Conexion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LamorxaXD
 */
public class RegistroRecargas {
    private int codRecarga;
    private double montoRecarga;
    private String codTarjeta;
    private String fechaRecarga;
    private String estado;
 public RegistroRecargas(int codRecarga, double montoRecarga, String codTarjeta, String fechaRecarga, String estado) {
        this.codRecarga = codRecarga;
        this.montoRecarga = montoRecarga;
        this.codTarjeta = codTarjeta;
        this.fechaRecarga = fechaRecarga;
        this.estado = estado;
    }

    public RegistroRecargas() {
    }
 
    // Aquí irían los métodos para realizar operaciones CRUD en la tabla 'registrorecargas'
    // Constructor, getters, setters, etc.

    public int getCodRecarga() {
        return codRecarga;
    }

    public void setCodRecarga(int codRecarga) {
        this.codRecarga = codRecarga;
    }

    public double getMontoRecarga() {
        return montoRecarga;
    }

    public void setMontoRecarga(double montoRecarga) {
        this.montoRecarga = montoRecarga;
    }

    public String getCodTarjeta() {
        return codTarjeta;
    }

    public void setCodTarjeta(String codTarjeta) {
        this.codTarjeta = codTarjeta;
    }

    public String getFechaRecarga() {
        return fechaRecarga;
    }

    public void setFechaRecarga(String fechaRecarga) {
        this.fechaRecarga = fechaRecarga;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
