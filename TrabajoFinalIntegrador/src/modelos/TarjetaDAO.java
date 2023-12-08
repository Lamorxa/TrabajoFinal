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
public class TarjetaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrarTarjeta(Tarjetas tarjetas) {
        String sql = "INSERT INTO tarjetas (CodTarjeta, Saldo, Dni, FechaCreacion, FechaCaducidad, Estado) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.crearConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tarjetas.getCodTarjeta());
            ps.setDouble(2, tarjetas.getSaldo());
            ps.setString(3, tarjetas.getDni());
            ps.setString(4, tarjetas.getFechaCreacion());
            ps.setString(5, tarjetas.getFechaCaducidad());
            ps.setString(6, tarjetas.getEstado());
            ps.execute();
            cn.cierraConsultas();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public List<Tarjetas> listarTarjetas() {
        List<Tarjetas> tarjetasLista = new ArrayList<>();
        String sql = "SELECT * FROM `tarjetas`";
        try {
            con = cn.crearConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarjetas tarjetas = new Tarjetas();
                tarjetas.setCodTarjeta(rs.getString("CodTarjeta"));
                tarjetas.setSaldo(rs.getDouble("Saldo"));
                tarjetas.setDni(rs.getString("Dni"));
                tarjetas.setFechaCreacion(rs.getString("FechaCreacion"));
                tarjetas.setFechaCaducidad(rs.getString("FechaCaducidad"));
                tarjetas.setEstado(rs.getString("estado"));
                tarjetasLista.add(tarjetas);
            }
            cn.cierraConsultas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return tarjetasLista;
    }

    public boolean modificarTarjeta(Tarjetas tarjetas) {
        String sql = "UPDATE tarjetas SET Saldo=?, Dni=?, FechaCreacion=?, FechaCaducidad=?, Estado=? WHERE CodTarjeta=?";
        try {
            con = cn.crearConexion();
            ps = con.prepareStatement(sql);

            ps.setDouble(1, tarjetas.getSaldo());
            ps.setString(2, tarjetas.getDni());
            ps.setString(3, tarjetas.getFechaCreacion());
            ps.setString(4, tarjetas.getFechaCaducidad());
            ps.setString(5, tarjetas.getEstado());
            ps.setString(6, tarjetas.getCodTarjeta());
            ps.execute();
            cn.cierraConsultas();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public boolean eliminarTarjeta(Tarjetas tarjetas) {
        String sql = "DELETE FROM tarjetas WHERE CodTarjeta = ?";
        try {
            con = cn.crearConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tarjetas.getCodTarjeta());
            ps.execute();
            cn.cierraConsultas();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
}