/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.RegistroRecargas;
import modelos.RegistroRecargasDAO;
import Vistas.Vistaadministrador;
import raven.toast.Notifications;

public class ControladorRegistroRecargas implements ActionListener {
    private Vistaadministrador views;
    private RegistroRecargasDAO registroRecargasDAO;
    private RegistroRecargas registroRecargas;
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorRegistroRecargas(RegistroRecargasDAO registroRecargasDAO,RegistroRecargas registroRecargas, Vistaadministrador views) {
        this.registroRecargasDAO = registroRecargasDAO;
        this.views = views;
        this.registroRecargas=registroRecargas;
        this.views.btnRegistrarRecarga.addActionListener(this);
        this.views.btnModificarRecarga.addActionListener(this);
        this.views.btnEliminarRecarga.addActionListener(this);
        listarRecargas();
    }
@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == views.btnRegistrarRecarga) {
        if (views.cbxtarjetasrecarga.getSelectedItem().equals("") ||
            views.txtmontorecarga.getText().equals("")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT, "Los campos son obligatorios");
        } else {
            registroRecargas.setCodRecarga(Integer.parseInt(views.txtcodrecarga.getText()));
            registroRecargas.setCodTarjeta(views.cbxtarjetasrecarga.getSelectedItem().toString());
            registroRecargas.setMontoRecarga(Double.parseDouble(views.txtmontorecarga.getText()));
            registroRecargas.setEstado(views.cbxestadoRecarga.getSelectedItem().toString());

            if (registroRecargasDAO.registrarRecarga(registroRecargas)) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Registrado corectamente");
                limpiarTabla();
                registroRecargasDAO.actualizarsaldoconsumo(registroRecargas);
                listarRecargas();
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error al registrar");
            }
        }
    }

    if (e.getSource() == views.btnModificarRecarga) {
        if (views.cbxtarjetasrecarga.getSelectedItem().equals("") ||
            views.txtmontorecarga.getText().equals("") ||
            views.txtcodrecarga.getText().equals("")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT, "Los campos son obligatorios");
        } else {
            registroRecargas.setCodRecarga(Integer.parseInt(views.txtcodrecarga.getText()));
            registroRecargas.setCodTarjeta(views.cbxtarjetasrecarga.getSelectedItem().toString());
            registroRecargas.setMontoRecarga(Double.parseDouble(views.txtmontorecarga.getText()));
            registroRecargas.setEstado(views.cbxestadoRecarga.getSelectedItem().toString());
          
            if (registroRecargasDAO.modificarRecargas(registroRecargas)) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Se han aplicado los cambios");
                limpiarTabla();
                listarRecargas();
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error al modificar");
            }
        }
    }

    if (e.getSource() == views.btnEliminarRecarga) {
        if (views.cbxtarjetasrecarga.getSelectedItem().equals("") ||
            views.txtmontorecarga.getText().equals("")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT, "Los campos son obligatorios");
        } else {
            registroRecargas.setCodRecarga(Integer.parseInt(views.txtcodrecarga.getText()));
            registroRecargas.setCodTarjeta(views.cbxtarjetasrecarga.getSelectedItem().toString());
            registroRecargas.setMontoRecarga(Double.parseDouble(views.txtmontorecarga.getText()));
            registroRecargas.setEstado(views.cbxestadoRecarga.getSelectedItem().toString());
          
            if (registroRecargasDAO.eliminarRecarga(registroRecargas)) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Se a eliminado correctamente");
                limpiarTabla();
                listarRecargas();
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error al Eliminar");
            }
        }
    }
}

            

      

   
    private void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    private void listarRecargas() {
        List<RegistroRecargas> lista = registroRecargasDAO.listarRecargas();
        modelo = (DefaultTableModel) views.tblRecargas.getModel();
        Object[] obj = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            obj[0] = lista.get(i).getCodRecarga();
            obj[1] = lista.get(i).getMontoRecarga();
            obj[2] = lista.get(i).getCodTarjeta();
            obj[3] = lista.get(i).getFechaRecarga();
            obj[4] = lista.get(i).getEstado();
            modelo.addRow(obj);
        }
        views.tblRecargas.setModel(modelo);
    }
}