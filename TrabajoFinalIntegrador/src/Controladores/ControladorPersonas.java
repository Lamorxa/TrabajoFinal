/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.awt.event.ActionListener;
import Vistas.Vistaadministrador;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import modelos.Personas;
import modelos.PersonasDAO;
import raven.toast.Notifications;
/**
 *
 * @author LamorxaXD
 */
public class ControladorPersonas implements ActionListener{
    private Vistaadministrador views;
    private Personas per;
    private PersonasDAO perDao;
    DefaultTableModel modelo= new DefaultTableModel();

    public ControladorPersonas(Vistaadministrador views, Personas per, PersonasDAO perDao) {
        this.views = views;
        this.per = per;
        this.perDao = perDao;
        this.views.btnaddperso.addActionListener(this);
        this.views.btndelper.addActionListener(this);
        this.views.btnmodper.addActionListener(this);
        this.views.btndelper.addActionListener(this);
        listar();   
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==views.btnaddperso) 
        {
        if (views.txtapematpersona.getText().equals ("" )||
            views.txtdnipersona.getText().equals("")||
            views.txtnombrepersona.getText().equals("")||
            views.txtapepatpersona.getText().equals("")||
            views.txtcelusuario.getText().equals("")||
            views.txtemail.getText().equals("")
                )
        {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT, "Los campos son obligatorios");
        }else   {
            per.setDni(views.txtdnipersona.getText());
            per.setNombres(views.txtnombrepersona.getText());
            per.setApellidoPaterno(views.txtapepatpersona.getText());
            per.setApellidoMaterno(views.txtapematpersona.getText());
            per.setTelefono(views.txtcelusuario.getText());
            per.setCorreoElectronico(views.txtemail.getText());
            per.setIdTipoPersona(views.cbxtipousupersona.getSelectedIndex()+1);
            if(views.txtruc.getText().isEmpty())
            {per.setRucEmpresa(null); 
            }else{
            per.setRucEmpresa(views.txtruc.getText());
            }
            per.setEstado(views.cbxestadopersona.getSelectedItem().toString());
            if (perDao.registrarPersona(per)) {
                limpiarTabla();
                listar();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Agregado correctamente");
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error al agregar");
                   }
                }  
        }
        if (e.getSource()==views.btnmodper) 
        {
        if (views.txtapematpersona.getText().equals ("" )||
            views.txtdnipersona.getText().equals("")||
            views.txtnombrepersona.getText().equals("")||
            views.txtapematpersona.getText().equals("")||
            views.txtapepatpersona.getText().equals("")||
            views.txtcelusuario.getText().equals("")||
            views.txtemail.getText().equals("")
                )
        {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT, "Los campos son obligatorios");
        }else   {
            per.setDni(views.txtdnipersona.getText());
            per.setNombres(views.txtnombrepersona.getText());
            per.setApellidoPaterno(views.txtapepatpersona.getText());
            per.setApellidoMaterno(views.txtapematpersona.getText());
            per.setTelefono(views.txtcelusuario.getText());
            per.setCorreoElectronico(views.txtemail.getText());
            per.setIdTipoPersona(views.cbxtipousupersona.getSelectedIndex()+1);
            if(views.txtruc.getText().isEmpty())
            {per.setRucEmpresa(null); 
            }else{
            per.setRucEmpresa(views.txtruc.getText());
            }
            per.setEstado(views.cbxestadopersona.getSelectedItem().toString());
            if (perDao.modificarPersona(per)) {
                limpiarTabla();
                listar();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Se han aplicado los cambios");
            } else {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error al modificar");
                   }
                }  
        }
        if (e.getSource()==views.btndelper) 
        {
        if (views.txtapematpersona.getText().equals ("" )||
            views.txtdnipersona.getText().equals("")||
            views.txtnombrepersona.getText().equals("")||
            views.txtapematpersona.getText().equals("")||
            views.txtapepatpersona.getText().equals("")||
            views.txtcelusuario.getText().equals("")||
            views.txtemail.getText().equals("")
                )
        {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT, "Los campos son obligatorios");
        }else   {
            per.setDni(views.txtdnipersona.getText());
            per.setNombres(views.txtnombrepersona.getText());
            per.setApellidoPaterno(views.txtapepatpersona.getText());
            per.setApellidoMaterno(views.txtapematpersona.getText());
            per.setTelefono(views.txtcelusuario.getText());
            per.setCorreoElectronico(views.txtemail.getText());
            per.setIdTipoPersona(views.cbxtipousupersona.getSelectedIndex()+1);
            if(views.txtruc.getText().isEmpty())
            {per.setRucEmpresa(null); 
            }else{
            per.setRucEmpresa(views.txtruc.getText());
            }
            per.setEstado(views.cbxestadopersona.getSelectedItem().toString());
            if (perDao.eliminarPersona(per)) {
                limpiarTabla();
                listar();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Se a eliminado correctamente");
            } else {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error al Eliminar");
                   }
                }  
        }



    }
    public void limpiarTabla()    {
        DefaultTableModel modelo = (DefaultTableModel) views.tblpersonas.getModel(); // Asegúrate de ajustar 'tblRutas' con el nombre de tu tabla
    while (modelo.getRowCount() > 0) {
        modelo.removeRow(0);}}
    public void listar()
        { List<Personas> lista= perDao.listarPersonas();
            modelo=(DefaultTableModel) views.tblpersonas.getModel();
            Object [] obj =new Object[9];
            for (int i = 0; i < lista.size(); i++) {
                obj[0] = lista.get(i).getDni();
                obj[1] = lista.get(i).getNombres();
                obj[2] = lista.get(i).getApellidoPaterno();
                obj[3] = lista.get(i).getApellidoMaterno();
                obj[4] = lista.get(i).getTelefono();
                obj[5] = lista.get(i).getCorreoElectronico();
                obj[6] = lista.get(i).getIdTipoPersona();
                obj[7] = lista.get(i).getRucEmpresa();
                obj[8] = lista.get(i).getEstado();
                
               modelo.addRow(obj);
            }
        views.tblpersonas.setModel(modelo);
        }
    
    
}
