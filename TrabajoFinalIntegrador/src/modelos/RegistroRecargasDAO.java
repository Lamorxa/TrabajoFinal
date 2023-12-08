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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RegistroRecargasDAO {
    
    Conexion cn = new Conexion() ;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
public boolean registrarRecarga(RegistroRecargas registrorecargas){
    String sql = "INSERT INTO registrorecargas (MontoRecarga, CodTarjeta, FechaRecarga, estado) VALUES (?, ?, ?, ?)";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, registrorecargas.getMontoRecarga());
        ps.setString(2, registrorecargas.getCodTarjeta());
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime ahora = LocalDateTime.now();
            String fechaHoraFormateada = ahora.format(formato);
            String fechaConsumo = fechaHoraFormateada;
        
        ps.setString(3, fechaHoraFormateada);
        ps.setString(4, registrorecargas.getEstado());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al registrar consumo: " + e.toString());
        return false;
    }
}   

public List<RegistroRecargas> listarRecargas() {
    List<RegistroRecargas> RecargasLista = new ArrayList<>();
    String sql = "SELECT * FROM registrorecargas";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            RegistroRecargas recarga = new RegistroRecargas();
            recarga.setCodRecarga(rs.getInt("CodRecarga"));
            recarga.setMontoRecarga(rs.getDouble("MontoRecarga"));
            recarga.setCodTarjeta(rs.getString("CodTarjeta"));
            recarga.setFechaRecarga(rs.getString("FechaRecarga"));
            recarga.setEstado(rs.getString("estado"));
            RecargasLista.add(recarga);
        }
        cn.cierraConsultas();
    } catch (SQLException e) {
        System.out.println("Error al listar recargas: " + e.toString());
    }
    return RecargasLista;
}

public boolean modificarRecargas(RegistroRecargas registrorecargas) {
    String sql = "UPDATE registrorecargas SET MontoRecarga = ?, CodTarjeta = ?, estado = ? WHERE CodRecarga = ?";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, registrorecargas.getMontoRecarga());
        ps.setString(2, registrorecargas.getCodTarjeta());
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime ahora = LocalDateTime.now();
            String fechaHoraFormateada = ahora.format(formato);
            String fechaConsumo = fechaHoraFormateada;
        
  //      ps.setString(3, fechaConsumo);
        ps.setString(3, registrorecargas.getEstado());
        ps.setInt(4, registrorecargas.getCodRecarga());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al modificar consumos: " + e.toString());
        return false;
    }
}

public boolean eliminarRecarga(RegistroRecargas registrorecargas) {
    String sql = "UPDATE registrorecargas SET estado = 'inactivo' WHERE CodRecarga = ?;";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, registrorecargas.getCodRecarga());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al eliminar Regcarga: " + e.toString());
        return false;
    }
}
public boolean actualizarsaldoconsumo(RegistroRecargas registrorecargas){
String sql = "UPDATE tarjetas SET Saldo = Saldo + ? WHERE CodTarjeta = ?";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, registrorecargas.getMontoRecarga());
        ps.setString(2, registrorecargas.getCodTarjeta());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al actualizar saldo" + e.toString());
        return false;
    }

}}
    