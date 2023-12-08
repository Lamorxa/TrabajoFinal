package modelos;


import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luisz
 */
public class Personas  {
    
    String Dni;
    String Nombres;
    String ApellidoPaterno;
    String ApellidoMaterno;
    String Telefono;
    String CorreoElectronico;
    int IdTipoPersona;
    String RucEmpresa;
    String Estado;

    public Personas() {

    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public int getIdTipoPersona() {
        return IdTipoPersona;
    }

    public void setIdTipoPersona(int IdTipoPersona) {
        this.IdTipoPersona = IdTipoPersona;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getRucEmpresa() {
        return RucEmpresa;
    }

    public void setRucEmpresa(String RucEmpresa) {
        this.RucEmpresa = RucEmpresa;
    }

    public Personas(String Dni, String Nombres, String ApellidoPaterno, String ApellidoMaterno, String Telefono, String CorreoElectronico, int IdTipoPersona, String RucEmpresa, String Estado) {
        this.Dni = Dni;
        this.Nombres = Nombres;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Telefono = Telefono;
        this.CorreoElectronico = CorreoElectronico;
        this.IdTipoPersona = IdTipoPersona;
        this.RucEmpresa = RucEmpresa;
        this.Estado = Estado;
    }

    
    
    
}
