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
public class Unidades  {
    private String codUnidad;
    private String dni;
    private int idRuta;
    private int codSoat;
    private String estado;

    // Aquí irían los métodos para realizar operaciones CRUD en la tabla 'unidades'
    // Constructor, getters, setters, etc.
public Unidades(){}
    public Unidades(String codUnidad, String dni, int idRuta, int codSoat, String estado) {
        this.codUnidad = codUnidad;
        this.dni = dni;
        this.idRuta = idRuta;
        this.codSoat = codSoat;
        this.estado = estado;
    }

    public String getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(String codUnidad) {
        this.codUnidad = codUnidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public int getCodSoat() {
        return codSoat;
    }

    public void setCodSoat(int codSoat) {
        this.codSoat = codSoat;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
}
