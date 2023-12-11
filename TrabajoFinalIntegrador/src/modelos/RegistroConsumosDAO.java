/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelos;

import modelos.RegistroConsumos;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RegistroConsumosDAO {
    
    Conexion cn = new Conexion() ;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrarConsumo(RegistroConsumos registroConsumos){
    String sql = "INSERT INTO registroconsumos (MontoConsumo, CodTarjeta, CodUnidad, FechaConsumo, Estado) VALUES (?, ?, ?, ?, ?)";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, registroConsumos.getMontoConsumo());
        ps.setString(2, registroConsumos.getCodTarjeta());
        ps.setString(3, registroConsumos.getCodUnidad());
        ps.setString(4, registroConsumos.getFechaConsumo());
        ps.setString(5, registroConsumos.getEstado());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al registrar consumo: " + e.toString());
        return false;
    }
}   

public List<RegistroConsumos> listarConsumos() {
    List<RegistroConsumos> consumosLista = new ArrayList<>();
    String sql = "SELECT * FROM registroconsumos";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            RegistroConsumos consumos = new RegistroConsumos();
            consumos.setCodConsumo(rs.getInt("CodConsumo"));
            consumos.setMontoConsumo(rs.getDouble("MontoConsumo"));
            consumos.setCodTarjeta(rs.getString("CodTarjeta"));
            consumos.setCodUnidad(rs.getString("CodUnidad"));
            consumos.setFechaConsumo(rs.getString("FechaConsumo"));
            consumos.setEstado(rs.getString("Estado"));
            consumosLista.add(consumos);
        }
        cn.cierraConsultas();
    } catch (SQLException e) {
        System.out.println("Error al listar consumos: " + e.toString());
    }
    return consumosLista;
}

public boolean modificarConsumos(RegistroConsumos registroConsumos) {
    String sql = "UPDATE registroconsumos SET MontoConsumo=?, CodTarjeta=?, CodUnidad=?, FechaConsumo=?, Estado=? WHERE CodConsumo=?";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, registroConsumos.getMontoConsumo());
        ps.setString(2, registroConsumos.getCodTarjeta());
        ps.setString(3, registroConsumos.getCodUnidad());
        ps.setString(4, registroConsumos.getFechaConsumo());
        ps.setString(5, registroConsumos.getEstado());
        ps.setInt(6, registroConsumos.getCodConsumo());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al modificar consumos: " + e.toString());
        return false;
    }
}

public boolean eliminarConsumo(RegistroConsumos registroConsumos) {
    String sql = "UPDATE registroconsumos SET estado = 'inactivo' WHERE CodConsumo = ?;";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, registroConsumos.getCodConsumo());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al eliminar consumo: " + e.toString());
        return false;
    }
}
public boolean actualizarsaldoconsumo(RegistroConsumos registroConsumos){
String sql = "UPDATE tarjetas SET Saldo = Saldo - ? WHERE CodTarjeta = ?";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, registroConsumos.getMontoConsumo());
        ps.setString(2, registroConsumos.getCodTarjeta());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al actualizar saldo" + e.toString());
        return false;
    }

}
public List<RegistroConsumos> listarConsumosOrdenadosPorCampo(String dni) {
    List<RegistroConsumos> consumosLista = new ArrayList<>();
    String sql = "SELECT rc.* FROM registroconsumos rc JOIN unidades u ON rc.CodUnidad = u.CodUnidad WHERE u.Dni = ?";
    Conexion cn = new Conexion();
    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        
        // Establecer el valor del parámetro DNI de manera segura
        ps.setString(1, dni);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            RegistroConsumos consumos = new RegistroConsumos();
            consumos.setCodConsumo(rs.getInt("CodConsumo"));
            consumos.setMontoConsumo(rs.getDouble("MontoConsumo"));
            consumos.setCodTarjeta(rs.getString("CodTarjeta"));
            consumos.setCodUnidad(rs.getString("CodUnidad"));
            consumos.setFechaConsumo(rs.getString("FechaConsumo"));
            consumos.setEstado(rs.getString("Estado"));
            consumosLista.add(consumos);
        }
        
        cn.cierraConsultas();
    } catch (SQLException e) {
        System.out.println("Error al listar consumos ordenados por campo: " + e.toString());
    }
    return consumosLista;
}
}