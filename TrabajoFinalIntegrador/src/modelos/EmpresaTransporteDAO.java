/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelos;

import modelos.EmpresaTransporte;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpresaTransporteDAO {
    
    Conexion cn = new Conexion() ;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
     public boolean registrarEmpresa(EmpresaTransporte empresaTransporte) {
    String sql = "INSERT INTO empresatransporte (RucEmpresa, NombreEmpresa, Color, Estado) VALUES (?, ?, ?, ?)";
    Conexion cn = new Conexion();

    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, empresaTransporte.getRucEmpresa());
        ps.setString(2, empresaTransporte.getNombreEmpresa());
        ps.setString(3, empresaTransporte.getColor());
        ps.setString(4, empresaTransporte.getEstado());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al registrar la empresa de transporte: " + e.toString());
        return false;
    }
}
     public List<EmpresaTransporte> listarEmpresas() {
    List<EmpresaTransporte> empresaTransporteLista = new ArrayList<>();
    String sql = "SELECT * FROM empresatransporte";
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        con = cn.crearConexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            EmpresaTransporte empresaTransporte = new EmpresaTransporte();
            empresaTransporte.setRucEmpresa(rs.getString("RucEmpresa"));
            empresaTransporte.setNombreEmpresa(rs.getString("NombreEmpresa"));
            empresaTransporte.setColor(rs.getString("Color"));
            empresaTransporte.setEstado(rs.getString("Estado"));
            empresaTransporteLista.add(empresaTransporte);
        }
    } catch (SQLException e) {
        System.out.println("Error al listar empresas de transporte: " + e.toString());
    } finally {
        cn.cierraConsultas();
    }
    return empresaTransporteLista;
}

    public boolean modificarEmpresa(EmpresaTransporte empresaTransporte) {
    String sql = "UPDATE empresatransporte SET NombreEmpresa = ?, Color = ?, Estado = ? WHERE RucEmpresa = ?";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, empresaTransporte.getNombreEmpresa());
        ps.setString(2, empresaTransporte.getColor());
        ps.setString(3, empresaTransporte.getEstado());
        ps.setString(4, empresaTransporte.getRucEmpresa());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al modificar empresa de transporte: " + e.toString());
        return false;
    }
}

public boolean eliminarEmpresa(EmpresaTransporte empresaTransporte) {
    String sql = "DELETE FROM empresatransporte WHERE RucEmpresa = ?";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, empresaTransporte.getRucEmpresa());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al eliminar empresa de transporte: " + e.toString());
        return false;
    }
}

    
}