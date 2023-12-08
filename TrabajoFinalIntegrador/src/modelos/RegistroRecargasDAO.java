/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelos;

import modelos.RegistroRecargas;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RegistroRecargasDAO {
    
    Conexion cn = new Conexion() ;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
public boolean registrar(Rutas ruta) {
    String sql = "INSERT INTO rutas (NombreRuta, MontoRuta, estado) VALUES (?, ?, ?)";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, ruta.getNombreRuta());
        ps.setDouble(2, ruta.getMontoRuta());
        ps.setString(3, ruta.getEstado());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al registrar ruta: " + e.toString());
        return false;
    }
}

public List<Rutas> listarRutas() {
    List<Rutas> rutasLista = new ArrayList<>();
    String sql = "SELECT * FROM rutas";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Rutas ruta = new Rutas();
            ruta.setIdRuta(rs.getInt("IdRuta"));
            ruta.setNombreRuta(rs.getString("NombreRuta"));
            ruta.setMontoRuta(rs.getDouble("MontoRuta"));
            ruta.setEstado(rs.getString("estado"));
            rutasLista.add(ruta);
        }
        cn.cierraConsultas();
    } catch (SQLException e) {
        System.out.println("Error al listar rutas: " + e.toString());
    }
    return rutasLista;
}

public boolean modificar(Rutas ruta) {
    String sql = "UPDATE rutas SET NombreRuta = ?, MontoRuta = ?, estado = ? WHERE IdRuta = ?";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, ruta.getNombreRuta());
        ps.setDouble(2, ruta.getMontoRuta());
        ps.setString(3, ruta.getEstado());
        ps.setInt(4, ruta.getIdRuta());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al modificar ruta: " + e.toString());
        return false;
    }
}

public boolean eliminar(Rutas ruta) {
    String sql = "DELETE FROM rutas WHERE IdRuta = ?";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, ruta.getIdRuta());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al eliminar ruta: " + e.toString());
        return false;
    }
}


}
    