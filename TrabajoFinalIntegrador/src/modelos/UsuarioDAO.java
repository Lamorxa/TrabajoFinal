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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author LamorxaXD
 */
public class UsuarioDAO {
    Conexion cn=new Conexion() ;
    Connection con;
    PreparedStatement ps ;
    ResultSet rs ;
   public Usuarios login(String Usuario, String Contra) {
    String sql = "SELECT * FROM usuarios WHERE User = ? AND Contraseña = ?";
    Usuarios us = new Usuarios();
    Conexion cn = new Conexion();

    try {
        con = cn.crearConexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, Usuario);
        ps.setString(2, Contra);
        rs = ps.executeQuery();
        if (rs.next()) {
            us.setIdUsuario(rs.getInt("IdUsuario"));
            us.setDni(rs.getString("Dni"));
            us.setUser(rs.getString("User"));
            us.setContrasena(rs.getString("Contraseña"));
            us.setEstado(rs.getString("estado"));
        }
        cn.cierraConsultas();
    } catch (SQLException e) {
        System.out.println("Error al iniciar sesión: " + e.toString());
    }
    return us;
}

public boolean registrar(Usuarios us) {
    String sql = "INSERT INTO usuarios (Dni, User, Contraseña, estado) VALUES (?, ?, ?, ?)";
    Conexion cn = new Conexion();

    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, us.getDni());
        ps.setString(2, us.getUser());
        ps.setString(3, us.getContrasena());
        ps.setString(4, us.getEstado());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al registrar usuario: " + e.toString());
        return false;
    }
}

public List<Usuarios> listarUsuarios() {
    List<Usuarios> usuarioslista = new ArrayList<>();
    Conexion cn = new Conexion();
    ResultSet rs = null;
    String sql = "SELECT * FROM usuarios";

    try {
        Connection con = cn.crearConexion();
        rs = cn.consultarRegistros(sql);
        while (rs.next()) {
            Usuarios usuario = new Usuarios();
            usuario.setIdUsuario(rs.getInt("IdUsuario"));
            usuario.setDni(rs.getString("Dni"));
            usuario.setUser(rs.getString("User"));
            usuario.setContrasena(rs.getString("Contraseña"));
            usuario.setEstado(rs.getString("estado"));
            usuarioslista.add(usuario);
        }
        cn.cierraConsultas();
    } catch (SQLException e) {
        System.out.println("Error al listar usuarios: " + e.toString());
    }
    return usuarioslista;
}

public boolean modificar(Usuarios user) {
    String sql = "UPDATE usuarios SET Dni = ?, User = ?, Contraseña = ?, estado = ? WHERE IdUsuario = ?";
    Conexion cn = new Conexion();

    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getDni());
        ps.setString(2, user.getUser());
        ps.setString(3, user.getContrasena());
        ps.setString(4, user.getEstado());
        ps.setInt(5, user.getIdUsuario());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al modificar usuario: " + e.toString());
        return false;
    }
}

public boolean eliminar(Usuarios user) {
    String sql = "DELETE FROM usuarios WHERE IdUsuario = ?";
    Conexion cn = new Conexion();

    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, user.getIdUsuario());
        ps.execute();
        cn.cierraConsultas();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al eliminar usuario: " + e.toString());
        return false;
    }
}
public int obtenerTipoUsuario(Usuarios user) {
    int tipoUsuario = 0;
    String sql = "SELECT personas.IdTipoPersona FROM personas INNER JOIN usuarios ON usuarios.Dni = personas.Dni WHERE usuarios.Dni=?";
    Conexion cn = new Conexion();

    try {
        Connection con = cn.crearConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getDni());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            tipoUsuario = rs.getInt("IdTipoPersona");
        }
        cn.cierraConsultas();
    } catch (SQLException e) {
        System.out.println("Error al obtener tipo de usuario: " + e.toString());
    }
    
    return tipoUsuario;
}
    
}


     
    

