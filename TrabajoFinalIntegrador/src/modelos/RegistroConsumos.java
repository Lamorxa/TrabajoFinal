/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;


import conexion.Conexion;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LamorxaXD
 */
public class RegistroConsumos  {
    private int codConsumo;
    private double montoConsumo;
    private String codTarjeta;
    private String codUnidad;
    private String fechaConsumo;
    private String estado;

    // Aquí irían los métodos para realizar operaciones CRUD en la tabla 'registroconsumos'
    // Constructor, getters, setters, etc.
    public RegistroConsumos(){};
    public RegistroConsumos(int codConsumo, double montoConsumo, String codTarjeta, String codUnidad, String fechaConsumo, String estado) {
        this.codConsumo = codConsumo;
        this.montoConsumo = montoConsumo;
        this.codTarjeta = codTarjeta;
        this.codUnidad = codUnidad;
        this.fechaConsumo = fechaConsumo;
        this.estado = estado;
    }

    public RegistroConsumos(int codConsumo) {
        this.codConsumo = codConsumo;
    }
    
 public RegistroConsumos( double montoConsumo, String codTarjeta, String codUnidad, String fechaConsumo, String estado) {
        this.montoConsumo = montoConsumo;
        this.codTarjeta = codTarjeta;
        this.codUnidad = codUnidad;
        this.fechaConsumo = fechaConsumo;
        this.estado = estado;
    }
    public int getCodConsumo() {
        return codConsumo;
    }

    public void setCodConsumo(int codConsumo) {
        this.codConsumo = codConsumo;
    }

    public double getMontoConsumo() {
        return montoConsumo;
    }

    public void setMontoConsumo(double montoConsumo) {
        this.montoConsumo = montoConsumo;
    }

    public String getCodTarjeta() {
        return codTarjeta;
    }

    public void setCodTarjeta(String codTarjeta) {
        this.codTarjeta = codTarjeta;
    }

    public String getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(String codUnidad) {
        this.codUnidad = codUnidad;
    }

    public String getFechaConsumo() {
        return fechaConsumo;
    }

    public void setFechaConsumo(String fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

 
    
}


