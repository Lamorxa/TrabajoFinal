/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.Vistaadministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelos.Unidades;
import modelos.UnidadDAO;

/**
 *
 * @author LamorxaXD
 */
public class ControladorUnidades implements ActionListener{
     private Vistaadministrador views;
    private Unidades uni;
    private UnidadDAO unidao;
    DefaultTableModel modelo= new DefaultTableModel();

    public ControladorUnidades (Vistaadministrador views, Unidades uni, UnidadDAO unidao) {
        this.views = views;
        this.uni = uni;
        this.unidao = unidao;
        this.views.btnaddunidad.addActionListener(this);
        this.views.btndeluni.addActionListener(this);
        this.views.btnmodunidad.addActionListener(this);
       
        
        listar();
        
    }
    
    
    
    public void limpiarTabla()    {
        DefaultTableModel modelo = (DefaultTableModel) views.tblunidades.getModel(); // Asegúrate de ajustar 'tblRutas' con el nombre de tu tabla
    while (modelo.getRowCount() > 0) {
        modelo.removeRow(0);}}
    public void listar()
        { List<Unidades> lista= unidao.listarUnidades();
            modelo=(DefaultTableModel) views.tblunidades.getModel();
            Object [] obj =new Object[5];
            for (int i = 0; i < lista.size(); i++) {
                obj[0] = lista.get(i).getCodUnidad();
                obj[1] = lista.get(i).getDni();
                obj[2] = lista.get(i).getIdRuta();
                obj[3] = lista.get(i).getCodSoat();
                obj[4] = lista.get(i).getEstado();
              
                
               modelo.addRow(obj);
            }
        views.tblunidades.setModel(modelo);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == views.btnaddunidad) {
    if (views.txtCodUnidad.getText().equals("") ||
            views.txtCodSoat.getText().equals("") ||
            views.txtIdRutaUnidad.getText().equals("")
            ||views.txtDniunidad.getText().equals("")
            ) {
        JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
    } else {
        uni.setCodUnidad(views.txtCodUnidad.getText());
        uni.setDni(views.txtDniunidad.getText());        
        uni.setIdRuta(Integer.parseInt(views.txtIdRutaUnidad.getText()));
        uni.setCodSoat(Integer.parseInt(views.txtCodSoat.getText()));
        uni.setEstado(views.cbxEstadoUnidad.getSelectedItem().toString());

        if (unidao.registrarUnidad(uni)) {
            JOptionPane.showMessageDialog(null, "Unidad Registrada con éxito");
            limpiarTabla();
            listar();   
        } else {
            JOptionPane.showMessageDialog(null, "Error al Registrar la Unidad");
        }
        }
        }
         if (e.getSource() == views.btnmodunidad) {
    if (views.txtCodUnidad.getText().equals("") ||
            views.txtCodSoat.getText().equals("") ||
            views.txtIdRutaUnidad.getText().equals("")
            ||views.txtDniunidad.getText().equals("")
            ) {
        JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
    } else {
        uni.setCodUnidad(views.txtCodUnidad.getText());
        uni.setDni(views.txtDniunidad.getText());        
        uni.setIdRuta(Integer.parseInt(views.txtIdRutaUnidad.getText()));
        uni.setCodSoat(Integer.parseInt(views.txtCodSoat.getText()));
        uni.setEstado(views.cbxEstadoUnidad.getSelectedItem().toString());

        if (unidao.modificarUnidad(uni)) {
            JOptionPane.showMessageDialog(null, "Unidad modificada con éxito");
            limpiarTabla();
            listar();   
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar la Unidad");
        }
        }
        }
         if (e.getSource() == views.btndeluni) {
    if (views.txtCodUnidad.getText().equals("") ||
            views.txtCodSoat.getText().equals("") ||
            views.txtIdRutaUnidad.getText().equals("")
            ||views.txtDniunidad.getText().equals("")
            ) {
        JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
    } else {
        uni.setCodUnidad(views.txtCodUnidad.getText());
        uni.setDni(views.txtDniunidad.getText());        
        uni.setIdRuta(Integer.parseInt(views.txtIdRutaUnidad.getText()));
        uni.setCodSoat(Integer.parseInt(views.txtCodSoat.getText()));
        uni.setEstado(views.cbxEstadoUnidad.getSelectedItem().toString());

        if (unidao.eliminarUnidad(uni)) {
            JOptionPane.showMessageDialog(null, "Unidad eliminada con éxito");
            limpiarTabla();
            listar();   
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminada la Unidad");
        }
        }
        }
        
    }
    
    
    
    
}
