/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelos;

import modelos.Personas;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PersonasDAO {
    
    Conexion cn = new Conexion() ;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrarPersona(Personas personas){
    String sql = "INSERT INTO personas (Dni, Nombres, ApellidoPaterno, ApellidoMaterno, Telefono, CorreoElectronico, IdTipoPersona, RucEmpresa, Estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, personas.getDni());
        ps.setString(2, personas.getNombres());
        ps.setString(3, personas.getApellidoPaterno());
        ps.setString(4, personas.getApellidoMaterno());
        ps.setString(5, personas.getTelefono());
        ps.setString(6, personas.getCorreoElectronico());
        ps.setInt(7, personas.getIdTipoPersona());
        ps.setString(8, personas.getRucEmpresa());
        ps.setString(9, personas.getEstado());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al registrar persona: " + e.toString());
        return false;
    }
} 

public List<Personas> listarPersonas() {
    List<Personas> personasLista = new ArrayList<>();
    String sql = "SELECT * FROM personas";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Personas personas = new Personas();
            personas.setDni(rs.getString("Dni"));
            personas.setNombres(rs.getString("Nombres"));
            personas.setApellidoPaterno(rs.getString("ApellidoPaterno"));
            personas.setApellidoMaterno(rs.getString("ApellidoMaterno"));
            personas.setTelefono(rs.getString("Telefono"));
            personas.setCorreoElectronico(rs.getString("CorreoElectronico"));
            personas.setIdTipoPersona(rs.getInt("IdTipoPersona"));
            personas.setRucEmpresa(rs.getString("RucEmpresa"));
            personas.setEstado(rs.getString("Estado"));
            personasLista.add(personas);
        }
        cn.cierraConsultas();
    } catch (SQLException e) {
        System.out.println("Error al listar personas: " + e.toString());
    }
    return personasLista;
}

public boolean modificarPersona(Personas personas) {
    String sql = "UPDATE personas SET Nombres=?, ApellidoPaterno=?, ApellidoMaterno=?, Telefono=?, CorreoElectronico=?, IdTipoPersona=?, RucEmpresa=?, Estado=? WHERE Dni=?";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, personas.getNombres());
        ps.setString(2, personas.getApellidoPaterno());
        ps.setString(3, personas.getApellidoMaterno());
        ps.setString(4, personas.getTelefono());
        ps.setString(5, personas.getCorreoElectronico());
        ps.setInt(6, personas.getIdTipoPersona());
        ps.setString(7, personas.getRucEmpresa());
        ps.setString(8, personas.getEstado());
        ps.setString(9, personas.getDni());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al modificar persona: " + e.toString());
        return false;
    }
}

public boolean eliminarPersona(Personas personas) {
    String sql = "DELETE FROM personas WHERE Dni = ?";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, personas.getDni());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al eliminar persona: " + e.toString());
        return false;
    }
}

    
}