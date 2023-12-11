/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import conexion.Conexion;
import java.sql.SQLException;

/**
 *
 * @author LamorxaXD
 */
public class Rellenarcombo {

    public void rellenar(String tabla, String valor, JComboBox combo, Conexion conexion) {
        String query = "SELECT " + valor + " FROM " + tabla;
        conexion.crearConexion();
        ResultSet rs = conexion.consultarRegistros(query);

        try {
            while (rs.next()) {
                combo.addItem(rs.getString(valor));
            }
        } catch (SQLException e) {
            System.out.println("Error al rellenar el combo: " + e.getMessage());
        } finally {
            try {
                rs.close();
                conexion.cierraConsultas();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar el conjunto de resultados: " + ex.getMessage());
            }
        }
    }

    public void rellenarTarjetasEnComboBox(String dni, JComboBox<String> combo) {
        String sql = "SELECT * FROM tarjetas WHERE Dni = ?";
        Conexion cn = new Conexion();

        try (Connection con = cn.crearConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Asignar el valor del parámetro
            ps.setString(1, dni);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String numerotarjeta = rs.getString("CodTarjeta");
                    combo.addItem(numerotarjeta);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al rellenar tarjetas en ComboBox: " + e.getMessage());
        } finally {
            cn.cierraConsultas();
        }
    }

}
