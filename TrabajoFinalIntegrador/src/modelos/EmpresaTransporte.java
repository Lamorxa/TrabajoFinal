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
public class EmpresaTransporte  {
    private String rucEmpresa;
    private String nombreEmpresa;
    private String color;
    private String estado;

    public EmpresaTransporte() {
    }

    public String getRucEmpresa() {
        return rucEmpresa;
    }

    public void setRucEmpresa(String rucEmpresa) {
        this.rucEmpresa = rucEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return estado;
    }

    // Aquí irían los métodos para realizar operaciones CRUD en la tabla 'empresatransporte'
    // Constructor, getters, setters, etc.
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EmpresaTransporte(String rucEmpresa, String nombreEmpresa, String color, String estado) {
        this.rucEmpresa = rucEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.color = color;
        this.estado = estado;
    }

}
