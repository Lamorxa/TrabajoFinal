package Controladores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.RegistroConsumos;
import modelos.RegistroConsumosDAO;
import Vistas.Vistaadministrador;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ControladorRegistroConsumos implements ActionListener {
    private Vistaadministrador views;
    private RegistroConsumos obj;
    private RegistroConsumosDAO registroConsumosDAO;
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorRegistroConsumos(RegistroConsumos obj, RegistroConsumosDAO registroConsumosDAO, Vistaadministrador views) {
        this.obj = obj;
        this.registroConsumosDAO = registroConsumosDAO;
        this.views = views;
        this.views.btnRegistrarConsumo.addActionListener(this);
        this.views.btnModificarConsumo.addActionListener(this);
        this.views.btnEliminarConsumo.addActionListener(this);
        listarConsumos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Boton Registrar Consumo
        if (e.getSource() == views.btnRegistrarConsumo) {
            // Obtener datos de la vista y validar
            if (views.txtCodTarjetaconsu.getText().equals("") ||
            views.txtCodUnidadconsu.getText().equals(""))
              JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
        else {
                      
            
            double montoConsumo = 1;
            String codTarjeta = views.txtCodTarjetaconsu.getText();
            String codUnidad = views.txtCodUnidadconsu.getText();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime ahora = LocalDateTime.now();
            String fechaHoraFormateada = ahora.format(formato);
            String fechaConsumo = fechaHoraFormateada;
            String estado = views.cbxestadoConsumo.getSelectedItem().toString();

            // Crear objeto de consumo
            RegistroConsumos nuevoConsumo = new RegistroConsumos(montoConsumo, codTarjeta, codUnidad, fechaConsumo, estado);

            // Llamar al método de registro en el DAO
            if (registroConsumosDAO.registrarConsumo(nuevoConsumo)) {
                JOptionPane.showMessageDialog(null, "Consumo Registrado Con Éxito");
                limpiarTabla();
                listarConsumos();
                registroConsumosDAO.actualizarsaldoconsumo(nuevoConsumo);
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar Consumo");
            }
        }
        }
        // Boton Modificar Consumo
        if (e.getSource() == views.btnModificarConsumo) {
            // Obtener datos de la vista y validar
            if (views.txtCodTarjetaconsu.getText().equals("") ||
            views.txtCodUnidadconsu.getText().equals(""))
              JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
        else{
        
            int codConsumo = Integer.parseInt(views.txtCodConsumo.getText());
            double montoConsumo = 1;
            String codTarjeta = views.txtCodConsumo.getText();
            String codUnidad = views.txtCodUnidadconsu.getText();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime ahora = LocalDateTime.now();
            String fechaHoraFormateada = ahora.format(formato);
            String fechaConsumo = fechaHoraFormateada;
            String estado = views.cbxestadoConsumo.getSelectedItem().toString();

            // Crear objeto de consumo
            RegistroConsumos consumoModificado = new RegistroConsumos(codConsumo, montoConsumo, codTarjeta, codUnidad, fechaConsumo, estado);

            // Llamar al método de modificación en el DAO
            if (registroConsumosDAO.modificarConsumos(consumoModificado)) {
                JOptionPane.showMessageDialog(null, "Consumo Modificado Con Éxito");
                limpiarTabla();
                listarConsumos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar Consumo");
            }
        }}

        // Boton Eliminar Consumo
        if (e.getSource() == views.btnEliminarConsumo) {
            // Obtener datos de la vista y validar
            if (views.txtCodTarjetaconsu.getText().equals("") ||
            views.txtCodUnidadconsu.getText().equals(""))
              JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
        else{
            int codConsumo = Integer.parseInt(views.txtCodConsumo.getText());

            // Crear objeto de consumo
            RegistroConsumos consumoEliminar = new RegistroConsumos(codConsumo);

            // Llamar al método de eliminación en el DAO
            if (registroConsumosDAO.eliminarConsumo(consumoEliminar)) {
                JOptionPane.showMessageDialog(null, "Consumo Eliminado Con Éxito");
                limpiarTabla();
                listarConsumos();
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Consumo");
            }
        }
    }}

    // Método para limpiar la tabla
    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    // Método para listar consumos
    public void listarConsumos() {
        List<RegistroConsumos> lista = registroConsumosDAO.listarConsumos();
        modelo = (DefaultTableModel) views.tblConsumos.getModel();
        Object[] obj = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            obj[0] = lista.get(i).getCodConsumo();
            obj[1] = lista.get(i).getMontoConsumo();
            obj[2] = lista.get(i).getCodTarjeta();
            obj[3] = lista.get(i).getCodUnidad();
            obj[4] = lista.get(i).getFechaConsumo();
            obj[5] = lista.get(i).getEstado();
            modelo.addRow(obj);
        }
        views.tblConsumos.setModel(modelo);
    }
}