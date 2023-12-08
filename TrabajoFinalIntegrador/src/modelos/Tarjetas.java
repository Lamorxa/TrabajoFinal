package modelos;


import conexion.Conexion;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luisz
 */
public class Tarjetas  {
    private String codTarjeta;
    private double saldo;
    private String dni;
    private String fechaCreacion;
    private String fechaCaducidad;
    private String estado;

    // Aquí irían los métodos para realizar operaciones CRUD en la tabla 'tarjetas'
    // Constructor, getters, setters, etc.

    public String getCodTarjeta() {
        return codTarjeta;
    }

    public void setCodTarjeta(String codTarjeta) {
        this.codTarjeta = codTarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Tarjetas(){}
    
    
    
}
