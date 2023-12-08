
package Controladores;

import Vistas.Vistaadministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.EmpresaTransporte;
import modelos.EmpresaTransporteDAO;

/**
 *
 * @author LamorxaXD
 */
public class ControladorEmpresaTransporte implements ActionListener{
    
    private EmpresaTransporte obj;
    private EmpresaTransporteDAO objDAO;
    private Vistaadministrador views;
    DefaultTableModel modelo= new DefaultTableModel();

    public ControladorEmpresaTransporte(EmpresaTransporte obj, EmpresaTransporteDAO objDAO, Vistaadministrador vobj) {
        this.obj = obj;
        this.objDAO = objDAO;
        this.views = vobj;
        this.views.btnaddunidad.addActionListener(this);
        this.views.btnmodemp.addActionListener(this);
        this.views.btndelemp.addActionListener(this);
        listar();
    }
    
    public void limpiarTabla()    {
        DefaultTableModel modelo = (DefaultTableModel) views.tblEmpresastrans.getModel(); // Asegúrate de ajustar 'tblRutas' con el nombre de tu tabla
    while (modelo.getRowCount() > 0) {
        modelo.removeRow(0);}}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnaddunidad) {
    if (views.txtcolorempresa.getText().equals("") ||
            views.txtnombreempresa.getText().equals("") ||
            views.txtrucempresa.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
    } else {
        obj.setColor(views.txtcolorempresa.getText());
        obj.setNombreEmpresa(views.txtnombreempresa.getText());
        obj.setRucEmpresa(views.txtrucempresa.getText());
        obj.setEstado(views.cbxEstadoTranporte.getSelectedItem().toString());

        if (objDAO.registrarEmpresa(obj)) {
            JOptionPane.showMessageDialog(null, "Empresa modificada con exito");
            limpiarTabla();
            listar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar la Empresa");
        }
    }}
    
    if (e.getSource() == views.btnmodemp) {
    if (views.txtcolorempresa.getText().equals("") ||
            views.txtnombreempresa.getText().equals("") ||
            views.txtrucempresa.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
    } else {
        obj.setColor(views.txtcolorempresa.getText());
        obj.setNombreEmpresa(views.txtnombreempresa.getText());
        obj.setRucEmpresa(views.txtrucempresa.getText());
        obj.setEstado(views.cbxEstadoTranporte.getSelectedItem().toString());

        if (objDAO.modificarEmpresa(obj)) {
            JOptionPane.showMessageDialog(null, "Empresa modificada con éxito");
            limpiarTabla();
            listar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar la Empresa");
        }
    }}
    if (e.getSource() == views.btndelemp) {
    if (views.txtcolorempresa.getText().equals("") ||
            views.txtnombreempresa.getText().equals("") ||
            views.txtrucempresa.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
    } else {
        obj.setColor(views.txtcolorempresa.getText());
        obj.setNombreEmpresa(views.txtnombreempresa.getText());
        obj.setRucEmpresa(views.txtrucempresa.getText());
        obj.setEstado(views.cbxEstadoTranporte.getSelectedItem().toString());

        if (objDAO.eliminarEmpresa(obj)) {
            JOptionPane.showMessageDialog(null, "Empresa Eliminada con éxito");
            limpiarTabla();
            listar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al Eliminar la Empresa");
        }
    }}
    
    
    
    }
        public void listar() {
    List<EmpresaTransporte> lista = objDAO.listarEmpresas(); // Asegúrate de tener 'empresaDAO' definido en tu clase
    DefaultTableModel modelo = (DefaultTableModel) views.tblEmpresastrans.getModel(); // Asegúrate de tener 'tblempresas' definido en tu vista
    Object[] obj = new Object[4]; // Ajusta el tamaño del objeto de acuerdo a los atributos de la clase Empresas

    for (int i = 0; i < lista.size(); i++) {
        obj[0] = lista.get(i).getRucEmpresa();
        obj[1] = lista.get(i).getNombreEmpresa();
        obj[2] = lista.get(i).getColor();
        obj[3] = lista.get(i).getEstado();
        modelo.addRow(obj);
    }

    views.tblEmpresastrans.setModel(modelo); // Asegúrate de setear el modelo al JTable correspondiente en tu vista
}}
        
        
        

    
    
    
    
    
    
    
    
    
    

