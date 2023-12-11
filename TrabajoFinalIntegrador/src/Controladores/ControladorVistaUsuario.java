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
import Vistas.*;
import raven.toast.Notifications;

/**
 *
 * @author LamorxaXD
 */
public class ControladorVistaUsuario implements ActionListener {

    private RegistroRecargasDAO registroRecargasDAO;
    private RegistroRecargas registroRecargas;
    private VistaUsuario views;
    private String dni;
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorVistaUsuario(RegistroRecargasDAO registroRecargasDAO, RegistroRecargas registroRecargas, VistaUsuario views, String dni) {
        this.registroRecargasDAO = registroRecargasDAO;
        this.registroRecargas = registroRecargas;
        this.views = views;
        this.dni = dni;
        this.views.btnRegistrarRecarga.addActionListener(this);
        listarRecargaspordni(dni);
        
    }
    
    
    
    

    private void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    private void listarRecargaspordni(String dni) {
        List<RegistroRecargas> lista = registroRecargasDAO.listarRecargasPorDni(dni);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarRecarga) {
            System.out.println("Controladores.ControladorVistaUsuario.actionPerformed()");
            if (views.cbxCodTarjetaRecarga.getSelectedItem().equals("")
                    || views.txtmontorecarga.getText().equals("")) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT, "Los campos son obligatorios");
            } else {
                registroRecargas.setCodRecarga(1);
                registroRecargas.setCodTarjeta(views.cbxCodTarjetaRecarga.getSelectedItem().toString());
                registroRecargas.setMontoRecarga(Double.parseDouble(views.txtmontorecarga.getText()));
                registroRecargas.setEstado("activo");

                if (registroRecargasDAO.registrarRecarga(registroRecargas)) {
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Registrado corectamente");
                    limpiarTabla();
                    listarRecargaspordni(dni);
                    registroRecargasDAO.actualizarsaldoconsumo(registroRecargas);
                } else {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error al registrar");
                }
            }
        }
    }

}
