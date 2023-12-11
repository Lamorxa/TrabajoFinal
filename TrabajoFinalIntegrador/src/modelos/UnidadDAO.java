/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Unidades;

public class UnidadDAO {
    
    Conexion cn = new Conexion() ;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
public boolean registrarUnidad(Unidades unidades) {
    String sql = "INSERT INTO unidades (CodUnidad, Dni, IdRuta, CodSoat, Estado) VALUES (?, ?, ?, ?, ?)";
    try {
        Connection con = new Conexion().crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, unidades.getCodUnidad());
        ps.setString(2, unidades.getDni());
        ps.setInt(3, unidades.getIdRuta());
        ps.setInt(4, unidades.getCodSoat());
        ps.setString(5, unidades.getEstado());
        ps.execute();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
        return false;
    }
}

public List<Unidades> listarUnidades() {
    List<Unidades> unidadesLista = new ArrayList<>();
    String sql = "SELECT * FROM unidades";
    try {
        Connection con = new Conexion().crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Unidades unidades = new Unidades();
            unidades.setCodUnidad(rs.getString("CodUnidad"));
            unidades.setDni(rs.getString("Dni"));
            unidades.setIdRuta(rs.getInt("IdRuta"));
            unidades.setCodSoat(rs.getInt("CodSoat"));
            unidades.setEstado(rs.getString("Estado"));
            unidadesLista.add(unidades);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
    }
    return unidadesLista;
}

public boolean modificarUnidad(Unidades unidades) {
    String sql = "UPDATE unidades SET Dni=?, IdRuta=?, CodSoat=?, Estado=? WHERE CodUnidad=?";
    try {
        Connection con = new Conexion().crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, unidades.getDni());
        ps.setInt(2, unidades.getIdRuta());
        ps.setInt(3, unidades.getCodSoat());
        ps.setString(4, unidades.getEstado());
        ps.setString(5, unidades.getCodUnidad());
        ps.execute();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
        return false;
    }
}

public boolean eliminarUnidad(Unidades unidades) {
    String sql = "UPDATE unidades SET estado = 'inactivo'  WHERE CodUnidad = ?";
    try {
        Connection con = new Conexion().crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, unidades.getCodUnidad());
        ps.execute();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
        return false;
    }
}

}
    