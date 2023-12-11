/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.Vistaadministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelos.Rutas;
import modelos.RutasDAO;
import raven.toast.Notifications;

/**
 *
 * @author LamorxaXD
 */
public class ControladorRutas implements ActionListener{
    private Rutas obj;
    private RutasDAO objDAO;
    private Vistaadministrador views;
    DefaultTableModel modelo= new DefaultTableModel();
    public ControladorRutas(Rutas obj, RutasDAO objDAO, Vistaadministrador vobj) {
        this.obj = obj;
        this.objDAO = objDAO;
        this.views = vobj;
        this.views.btnRegrut.addActionListener(this);
        this.views.btndeluni.addActionListener(this);
        this.views.btnModRut.addActionListener(this); 
        listarRutas();
    } 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnModRut) {
    if (views.txtidrutman.getText().equals("") ||
            views.txtmontoruta.getText().equals("") ||
            views.txtnombreruta.getText().equals("")) {
        Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT, "Los campos son obligatorios");
    } else {
        obj.setNombreRuta(views.txtnombreruta.getText());
        obj.setIdRuta(Integer.parseInt(views.txtidrutman.getText()));
        obj.setMontoRuta(Double.parseDouble(views.txtmontoruta.getText()));
        obj.setEstado(views.cbxEstadoRuta.getSelectedItem().toString());

        if (objDAO.modificar(obj)) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Se han aplicado los cambios");
            limpiarTabla();
            listarRutas();
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error al modificar");
        }
    }
        }
   if (e.getSource()==views.btnRegrut)
        {   
            if (views.txtidrutman.getText().equals ("" )||
            views.txtmontoruta.getText().equals("")||
            views.txtnombreruta.getText().equals(""))
            {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT, "Los campos son obligatorios");
            }else   {
            obj.setNombreRuta(views.txtnombreruta.getText());
            obj.setIdRuta(Integer.parseInt(views.txtidrutman.getText()));
            obj.setMontoRuta(Double.parseDouble(views.txtmontoruta.getText()));
            obj.setEstado(views.cbxEstadoRuta.getSelectedItem().toString());
            if(objDAO.registrar(obj))
            {
                limpiarTabla();
                listarRutas();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Registrado correctamente");
            }else {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error al registrar");
                   }
            }   
        }
if (e.getSource() == views.btndeluni) {
    if (views.txtidrutman.getText().equals("") ||
            views.txtmontoruta.getText().equals("") ||
            views.txtnombreruta.getText().equals("")) {
        Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT, "Los campos son obligatorios");
    } else {
        obj.setIdRuta(Integer.parseInt(views.txtidrutman.getText()));

        if (objDAO.eliminar(obj)) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Se a eliminado correctamente");
            limpiarTabla();
            listarRutas();
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error al Eliminar");
        }
    }
}

    
    }
     public void limpiarTabla()    {
        DefaultTableModel modelo = (DefaultTableModel) views.tblrutas.getModel(); // Asegúrate de ajustar 'tblRutas' con el nombre de tu tabla
    while (modelo.getRowCount() > 0) {
        modelo.removeRow(0);}}
    public void listarRutas() {
    List<Rutas> lista = objDAO.listarRutas(); // Suponiendo que 'rutaDAO' es una instancia de tu clase 'RutaDAO'
    DefaultTableModel modelo = (DefaultTableModel) views.tblrutas.getModel(); // Asegúrate de tener 'tblRutas' definido en tu vista
    Object[] obj = new Object[4]; // Ajusta el tamaño del objeto de acuerdo a los atributos de la clase Rutas

    for (int i = 0; i < lista.size(); i++) {
        obj[0] = lista.get(i).getIdRuta();
        obj[1] = lista.get(i).getNombreRuta();
        obj[2] = lista.get(i).getMontoRuta();
        obj[3] = lista.get(i).getEstado();
        modelo.addRow(obj);
    }

    views.tblrutas.setModel(modelo); // Asegúrate de setear el modelo al JTable correspondiente en tu vista
}
     
    }
    
    
    


