
package Controladores;

import Vistas.Vistaadministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.UsuarioDAO;
import modelos.Usuarios;

public class ControladorUsuarios implements ActionListener{
    private Vistaadministrador views;
    private Usuarios us;
    private UsuarioDAO UsDao;
    DefaultTableModel modelo= new DefaultTableModel();
    public ControladorUsuarios(Usuarios us, UsuarioDAO UsDao, Vistaadministrador views) {
        this.us = us;
        this.UsDao = UsDao;
        this.views = views;
        this.views.btnadduser.addActionListener(this);
        this.views.btndeluser.addActionListener(this);
        this.views.btnmoduser.addActionListener(this);
        this.views.btndeluser.addActionListener(this);
        listarusuarios();   
    } 
    @Override
    public void actionPerformed(ActionEvent e) {
        //boton añadirusuario
        if (e.getSource()==views.btnadduser) 
        {
        if (views.txtContraUser.getText().equals ("" )||
            views.txtDniUsers.getText().equals("")||
            views.txtUserUsuario.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
        }else   {
            us.setUser(views.txtUserUsuario.getText());
            us.setContrasena(views.txtContraUser.getText());
            us.setDni(views.txtDniUsers.getText());
            us.setEstado(views.cbxestadoUser.getSelectedItem().toString());
            if (UsDao.registrar(us)) {
                limpiarTabla();
                listarusuarios();
                JOptionPane.showMessageDialog(null, "Usuario Registrado Con Exito");
            } else {
                 JOptionPane.showMessageDialog(null, "Error a resgistrar Usuario");
                   }
                }  
        }//cierra el iff del btnadduser
        //botonModificaruser
        if (e.getSource()==views.btnmoduser) {
            if (views.txtContraUser.getText().equals ("" )||
            views.txtDniUsers.getText().equals("")||
            views.txtUserUsuario.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
        }else   {
            us.setIdUsuario(Integer.parseInt(views.txtIdUser.getText()));
            us.setUser(views.txtUserUsuario.getText());
            us.setContrasena(views.txtContraUser.getText());
            us.setDni(views.txtDniUsers.getText());
            us.setEstado(views.cbxestadoUser.getSelectedItem().toString());
            }
            if (UsDao.modificar(us)) {
                JOptionPane.showMessageDialog(null, "Usuario Modificado Con Exito");
                limpiarTabla();
                listarusuarios();
            } else {
                 JOptionPane.showMessageDialog(null, "Error a Modificar Usuario");
                   }
        }//cierra el if de mod user
        //botonEliminarUsuario
        if (e.getSource()==views.btndeluser) 
             {if (views.txtContraUser.getText().equals ("" )||
            views.txtDniUsers.getText().equals("")||
            views.txtUserUsuario.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
        }else   {
            us.setIdUsuario(Integer.parseInt(views.txtIdUser.getText()));
            us.setUser(views.txtUserUsuario.getText());
            us.setContrasena(views.txtContraUser.getText());
            us.setDni(views.txtDniUsers.getText());
            us.setEstado(views.cbxestadoUser.getSelectedItem().toString());
            } if (UsDao.eliminar(us)) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado Con Exito");
                limpiarTabla();
                listarusuarios();
            } else {
                 JOptionPane.showMessageDialog(null, "Error a Eliminar Usuario");
                   }
                        
             }
    }
    //metodo para limpir la tabla
    public void limpiarTabla()
    {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i=i-1;       
        }
    }
    //metodo para listar usuarios
    public void listarusuarios()
        { List<Usuarios> lista= UsDao.listarUsuarios();
            modelo=(DefaultTableModel) views.tblusuarios.getModel();
            Object [] obj =new Object[5];
            for (int i = 0; i < lista.size(); i++) {
                obj[0] = lista.get(i).getIdUsuario();
                obj[1] = lista.get(i).getDni();
                obj[2] = lista.get(i).getUser();
                obj[3] = lista.get(i).getContrasena();
                obj[4] = lista.get(i).getEstado();
               modelo.addRow(obj);
            }
        views.tblusuarios.setModel(modelo);
        }
}
