package modelos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LamorxaXD
 */
public class RutasDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrar(Rutas ruta) {
        String sql = "INSERT INTO rutas (NombreRuta, MontoRuta, estado) VALUES (?, ?, ?)";
        try {
            Conexion cn = new Conexion();
            Connection con = cn.crearConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ruta.getNombreRuta());
            ps.setDouble(2, ruta.getMontoRuta());
            ps.setString(3, ruta.getEstado());
            ps.execute();
            cn.cierraConsultas();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public List<Rutas> listarRutas() {
        List<Rutas> rutasLista = new ArrayList<>();
        String sql = "SELECT * FROM rutas";
        try {
            Conexion cn = new Conexion();
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
            return rutasLista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return null;
    }

    public boolean modificar(Rutas ruta) {
        String sql = "UPDATE rutas SET NombreRuta = ?, MontoRuta = ?, estado = ? WHERE IdRuta = ?";
        try {
            Conexion cn = new Conexion();
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
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public boolean eliminar(Rutas ruta) {
        String sql = "UPDATE rutas SET estado = 'inactivo' WHERE IdRuta = ?";
        try {
            Conexion cn = new Conexion();
            Connection con = cn.crearConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ruta.getIdRuta());
            ps.execute();
            cn.cierraConsultas();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public List<Rutas> listarRutasPorDni(String dni) {
        List<Rutas> rutasLista = new ArrayList<>();
        String sql = "SELECT r.* FROM rutas r JOIN unidades u ON r.IdRuta = u.IdRuta WHERE u.Dni = ?";
        Conexion cn = new Conexion();

        try (Connection con = cn.crearConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Rutas ruta = new Rutas();
                    ruta.setIdRuta(rs.getInt("IdRuta"));
                    ruta.setNombreRuta(rs.getString("NombreRuta"));
                    ruta.setMontoRuta(rs.getDouble("MontoRuta"));
                    ruta.setEstado(rs.getString("estado"));
                    rutasLista.add(ruta);
                }
            }

        } catch (SQLException e) {
            // Manejar la excepción de acuerdo a la lógica de tu aplicación
            JOptionPane.showMessageDialog(null, "Error al listar rutas por DNI: " + e.toString());
        } finally {
            cn.cierraConsultas();
        }

        return rutasLista;
    }

}
