package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    public static final String URL = "jdbc:mysql://localhost:3306/etravelease";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    
    private Connection conn;
    private PreparedStatement pstm = null;
    private ResultSet respuesta = null;

    public Connection crearConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion Exitosa");
        } catch (Exception e) {
            System.out.println("Error de conexion " + e);
        }   
        return conn;
    }
    
   public int ejecutarSentenciaSQL(String strSentenciaSQL) {
    try {
        if (conn == null) {
            crearConexion(); // Vuelve a intentar establecer la conexión si es nula
        }
        if (conn != null) {
            pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.executeUpdate();
            return 1;
        } else {
            System.out.println("La conexión es nula. Verifica la conexión.");
            return 0;
        }
    } catch (SQLException e) {
        System.out.println("Error en la ejecución de la sentencia SQL: " + e.getMessage());
        return 0;
    }
}

    public ResultSet consultarRegistros(String strSentenciaSQL) {
        try {
            pstm = conn.prepareStatement(strSentenciaSQL);
            respuesta = pstm.executeQuery();
            return respuesta; 
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    
    public void cierraConsultas() {
        try {
            if (respuesta != null) {
                respuesta.close();
                System.out.println("cerrando respuesta...");
            }
            if (pstm != null) {
                pstm.close();
                System.out.println("cerrando ejecucion...");
            }
            if (conn != null) {
                conn.close();
                System.out.println("cerrando conexion...");
            }
            System.out.println("fin de la consulta");
        } catch (SQLException e) {
            System.out.println("Error al cerrar: " + e);
        }
    }

   
}