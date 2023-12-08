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

import modelos.Tarjetas;
import modelos.TarjetaDAO;
public class ControladorTarjetas implements ActionListener{
    
    private Tarjetas tar=new Tarjetas();
    private TarjetaDAO tardao=new TarjetaDAO();
    private Vistaadministrador views=new Vistaadministrador();
    DefaultTableModel modelo= new DefaultTableModel();
    public ControladorTarjetas (Tarjetas tar, TarjetaDAO tardao, Vistaadministrador views) {
        this.tar = tar;
        this.tardao = tardao;
        this.views = views;
        this.views.btnaddtar.addActionListener(this);
        this.views.btndeltar.addActionListener(this);
        this.views.btnmodtar.addActionListener(this);
        this.views.btndeltar.addActionListener(this);
       /* listar();*/   
    } 

  
    private void listar() {
       List<Tarjetas> lista = tardao.listarTarjetas(); // Suponiendo que 'rutaDAO' es una instancia de tu clase 'RutaDAO'
    DefaultTableModel modelo = (DefaultTableModel) views.tbltarjetas.getModel(); // Asegúrate de tener 'tblRutas' definido en tu vista
    Object[] obj = new Object[6]; // Ajusta el tamaño del objeto de acuerdo a los atributos de la clase Rutas
    for (int i = 0; i < lista.size(); i++) {
        obj[0] = lista.get(i).getCodTarjeta();
        obj[1] = lista.get(i).getSaldo();
        obj[2] = lista.get(i).getDni();
        obj[3] = lista.get(i).getFechaCreacion();
        obj[4] = lista.get(i).getFechaCaducidad();
        obj[5] = lista.get(i).getEstado();
        modelo.addRow(obj);
    }
    views.tbltarjetas.setModel(modelo);  
}

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == views.btnaddtar) {
    if (views.txtcodtarjeta.getText().equals("") ||
            views.txtdnipersonatarjeta.getText().equals("") ||
            views.txtsaldo.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
    } else {
        tar.setCodTarjeta(views.txtcodtarjeta.getText());
        tar.setDni(views.txtdnipersonatarjeta.getText());
        tar.setSaldo(Double.parseDouble(views.txtsaldo.getText()));
        tar.setFechaCaducidad(String.valueOf(views.jdcfechacaducTarjeta.getText()));
        tar.setFechaCreacion(String.valueOf(views.jdcfechacreacionTarjeta.getText()));
        tar.setEstado(views.cbxEstadotarjeta.getSelectedItem().toString());

        if (tardao.registrarTarjeta(tar)) {
            JOptionPane.showMessageDialog(null, "Empresa modificada con exito");
            limpiarTabla();
            listar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar la Empresa");
        }
    }
         }
    
    
    
    
    }
    public void limpiarTabla()    {
        DefaultTableModel modelo = (DefaultTableModel) views.tbltarjetas.getModel(); // Asegúrate de ajustar 'tblRutas' con el nombre de tu tabla
    while (modelo.getRowCount() > 0) {
        modelo.removeRow(0);}}
}