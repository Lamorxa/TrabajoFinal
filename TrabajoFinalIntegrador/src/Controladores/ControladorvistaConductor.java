/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelos.EmpresaTransporte;
import modelos.EmpresaTransporteDAO;
import modelos.Personas;
import modelos.RegistroConsumos;
import modelos.RegistroConsumosDAO;
import modelos.RegistroRecargas;
import modelos.RegistroRecargasDAO;
import modelos.Rutas;
import modelos.RutasDAO;
import modelos.UnidadDAO;
import modelos.Unidades;
import modelos.Usuarios;
import raven.toast.Notifications;

/**
 *
 * @author LamorxaXD
 */
public class ControladorvistaConductor {

    private VistaConductor views;
    private RegistroConsumos registroConsumos;
    private RegistroConsumosDAO registroConsumosDAO;
    private Rutas rutas;
    private RutasDAO rutasDAO;
    private EmpresaTransporte empre;
    private EmpresaTransporteDAO empreDAO;
    private Unidades uni;
    private UnidadDAO unidao;
    private Personas personas;
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorvistaConductor() {
    }

    public ControladorvistaConductor(VistaConductor views, RegistroConsumos registroConsumos, RegistroConsumosDAO registroConsumosDAO, Rutas rutas, RutasDAO rutasDAO, EmpresaTransporte empre, EmpresaTransporteDAO empreDAO, Unidades uni, UnidadDAO unidao, Personas personas) {
        this.views = views;
        this.registroConsumos = registroConsumos;
        this.registroConsumosDAO = registroConsumosDAO;
        this.rutas = rutas;
        this.rutasDAO = rutasDAO;
        this.empre = empre;
        this.empreDAO = empreDAO;
        this.uni = uni;
        this.unidao = unidao;
        this.personas = personas;
        listarConsumosporid(personas.getDni());
        listarRutas(personas.getDni());
    }

    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    // Método para listar consumos
    public void listarConsumosporid(String txtdni) {
        List<RegistroConsumos> lista = registroConsumosDAO.listarConsumosOrdenadosPorCampo(txtdni);
        modelo = (DefaultTableModel) views.tblconsumosuser.getModel();
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
        views.tblconsumosuser.setModel(modelo);
    }

    public void listarRutas(String dni) {
        List<Rutas> lista = rutasDAO.listarRutasPorDni(dni); // Suponiendo que 'rutaDAO' es una instancia de tu clase 'RutaDAO'
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
