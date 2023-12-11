package Vistas;

import Cajon.ConstructorCajon;
import Controladores.ControladorEmpresaTransporte;
import Controladores.ControladorPersonas;
import Controladores.ControladorRutas;
import Controladores.*;
import Controladores.ControladorUnidades;
import Controladores.ControladorUsuarios;
import Controladores.Rellenarcombo;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import conexion.Conexion;
import java.sql.Connection;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import modelos.*;
import modelos.EmpresaTransporteDAO;
import modelos.Personas;
import modelos.PersonasDAO;
import modelos.Rutas;
import modelos.RutasDAO;
import modelos.TarjetaDAO;
import modelos.Tarjetas;
import modelos.UnidadDAO;
import modelos.Unidades;
import modelos.UsuarioDAO;
import modelos.Usuarios;
import net.miginfocom.swing.MigLayout;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.management.Notification;
import javax.swing.JFileChooser;
import raven.toast.Notifications;
import raven.toast.ToastClientProperties;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class Vistaadministrador extends javax.swing.JFrame {

    UsuarioDAO usDao = new UsuarioDAO();
    Usuarios us = new Usuarios();
    Rutas rut = new Rutas();
    RutasDAO rutdao = new RutasDAO();
    EmpresaTransporte emtrans = new EmpresaTransporte();
    EmpresaTransporteDAO emtransdao = new EmpresaTransporteDAO();
    Personas person = new Personas();
    PersonasDAO persondao = new PersonasDAO();
    Tarjetas tarj = new Tarjetas();
    TarjetaDAO tarjdao = new TarjetaDAO();
    Unidades unidad = new Unidades();
    UnidadDAO unidadesDAO = new UnidadDAO();
    RegistroConsumos consu = new RegistroConsumos();
    RegistroConsumosDAO conconsu = new RegistroConsumosDAO();
    RegistroRecargas recar = new RegistroRecargas();
    RegistroRecargasDAO conrecar = new RegistroRecargasDAO();
    Rellenarcombo re = new Rellenarcombo();
    Conexion conec = new Conexion();

    public Vistaadministrador() {

        //Centrar objetos tabla
        Notifications.getInstance().setJFrame(this);
        GlassPanePopup.install(this);
        ConstructorCajon constructorCajon = new ConstructorCajon(this);
        Drawer.getInstance().setDrawerBuilder(constructorCajon);
        initComponents();
        init();

        // Controladordebugtarje a=new Controladordebugtarje( this);
        ControladorUsuarios users = new ControladorUsuarios(us, usDao, this);
        ControladorRutas rutas = new ControladorRutas(rut, rutdao, this);
        ControladorEmpresaTransporte empresas = new ControladorEmpresaTransporte(emtrans, emtransdao, this);
        ControladorPersonas personas = new ControladorPersonas(this, person, persondao);
        ControladorUnidades unidades = new ControladorUnidades(this, unidad, unidadesDAO);
        ControladorRegistroConsumos consss = new ControladorRegistroConsumos(consu, conconsu, this);
        ControladorRegistroRecargas con = new ControladorRegistroRecargas(conrecar, recar, this);
        re.rellenar("tarjetas", "CodTarjeta",cbxtarjetasrecarga,conec);
        listarTarjetas();
        this.setLocationRelativeTo(null);
        btnRegrut.setVisible(false);
        btncancelper.setVisible(false);
        btndeluni.setVisible(false);
        btnCancelarManRut.setVisible(false);
        btnelirut.setVisible(false);

        btnCancelarManRut1.setVisible(false);
        btnModRut.setVisible(false);
        btnCancelarManRut2.setVisible(false);
        btncancelusu.setVisible(false);
        btncancelusu1.setVisible(false);
        btncancelusu2.setVisible(false);
        btnmoduser.setVisible(false);
        btndeluser.setVisible(false);
        btnadduser.setVisible(false);
        btnaddunidad.setVisible(false);
        btnmodunidad.setVisible(false);
        btndeluni.setVisible(false);
        btncanuni.setVisible(false);
        btncanuni1.setVisible(false);
        btncanuni2.setVisible(false);
        btnaddperso.setVisible(false);
        btndelper.setVisible(false);
        btnmodper.setVisible(false);
        btncancelper1.setVisible(false);
        btncancelper2.setVisible(false);
        btnmodrut.setVisible(false);
        btndelrut.setVisible(false);
        btnactdelemp.setVisible(false);
        btnactmodemp.setVisible(false);
        btnactaddper.setVisible(true);
        btnactmodper.setVisible(false);
        btnactdelper.setVisible(false);
        btnactadduser.setVisible(true);
        btnactdeluser.setVisible(false);
        btnactmoduser.setVisible(false);

        /*btnaddtar.setVisible(false);
        btnmodtar.setVisible(false);
        btndeltar.setVisible(false);
        btncanTar.setVisible(false);
        btncanTar1.setVisible(false);
        btncanTar2.setVisible(false);
         */
        btnaddemp.setVisible(false);
        btndelemp.setVisible(false);
        btnmodemp.setVisible(false);
        btncantrans.setVisible(false);
        btncantrans1.setVisible(false);
        btncantrans2.setVisible(false);
        btnactmodiunidad.setVisible(false);
        btnactdelunidad.setVisible(false);

    }

    private void listarTarjetas() {
        try {
            List<Tarjetas> lista = tarjdao.listarTarjetas();
            DefaultTableModel modelo = (DefaultTableModel) tbltarjetas.getModel();
            modelo.setRowCount(0); // Limpiar las filas existentes en la tabla antes de agregar nuevas

            Object[] obj = new Object[6];
            for (int i = 0; i < lista.size(); i++) {
                obj[0] = lista.get(i).getCodTarjeta();
                obj[1] = lista.get(i).getSaldo();
                obj[2] = lista.get(i).getDni();
                obj[3] = lista.get(i).getFechaCreacion();
                obj[4] = lista.get(i).getFechaCaducidad();
                obj[5] = lista.get(i).getEstado();
                modelo.addRow(obj);
            }
            tbltarjetas.setModel(modelo);
        } catch (Exception ex) {
            ex.printStackTrace();
            // Manejar la excepción, mostrar un mensaje de error, etc.
        }
    }

    private void init() {

        tablaPersonas.setLayout(new MigLayout("wrap,fill,insets 15", "[fill]", "[grow 0][fill]"));
        pnlBotonesBusqueda1.setLayout(new MigLayout("", "[200]push[][]", "[]push[][]"));
        pnlPersonaForm.setLayout(new MigLayout("wrap,fill,insets 30 30 30 30", "[][][][]", "[][][][]"));
        //pnlPersonaForm1.setLayout(new MigLayout("wrap,fill,insets 15", "[fill]"));
        //pnlPersonaForm2.setLayout(new MigLayout("wrap,fill,insets 15", "[fill]"));
        //pnlPersonaForm3.setLayout(new MigLayout("wrap,fill,insets 15", "[fill]"));
        //pnlPersonaForm4.setLayout(new MigLayout("wrap,fill,insets 15", "[fill]"));
        pnlBotonesBusqueda2.setLayout(new MigLayout("", "[200]push[][]", ""));
        tablaUsuarios.setLayout(new MigLayout("wrap,fill,insets 15", "[fill]", "[grow 0][fill]"));
        //Place holder panel personas
        txtBuscar1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
        txtnombrepersona.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nombre");
        txtapepatpersona.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Apellido Paterno");
        txtapematpersona.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Apellido Materno");
        txtdnipersona.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DNI");
        txtcelusuario.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Celular");
        txtemail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Correo Electrónico");
        txtruc.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "RUC de empresa");

        //Place holder panel usuarios
        txtBuscar2.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
        txtUserUsuario.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nombre de Usuario");
        txtContraUser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Contraseña");
        txtDniUsers.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DNI");

        //Place holder panel Tarjetas
        txtBuscar3.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
        txtcodtarjeta.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Código de tarjeta");
        txtdnipersonatarjeta.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DNI");

        //Place holder panel Recargas
        txtBuscar4.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
        txtmontorecarga.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Monto de recarga");

        //Place holder panel Consumos}
        txtBuscar5.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
        txtCodTarjetaconsu.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Número de Tarjeta");
        txtCodUnidadconsu.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Unidad");

        //Place holder panel Rutas
        txtBuscar6.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
        txtnombreruta.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nombre de ruta");

        //Place holder panel Empresas
        txtBuscar7.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
        txtnombreempresa.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nombre de la Empresa");
        txtrucempresa.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ruc de empresa");
        txtcolorempresa.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Color");

        //Place holder panel Unidades
        txtBuscar8.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
        txtDniunidad.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DNI");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneles = new raven.crazypanel.CrazyPanel();
        pnlPersonas = new raven.crazypanel.CrazyPanel();
        menuPersonas = new Clases.CrazyPanel();
        btnmenu1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tablaPersonas = new Clases.CrazyPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpersonas = new javax.swing.JTable();
        PersonaBotones = new Clases.CrazyPanel();
        pnlBotonesBusqueda1 = new Clases.CrazyPanel();
        txtBuscar1 = new javax.swing.JTextField();
        btnactaddper = new javax.swing.JButton();
        btnactmodper = new javax.swing.JButton();
        btnactdelper = new javax.swing.JButton();
        pnlPersonaForm = new Clases.CrazyPanel();
        pnlPersonaForm1 = new Clases.CrazyPanel();
        jLabel11 = new javax.swing.JLabel();
        txtnombrepersona = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtapepatpersona = new javax.swing.JTextField();
        txtapematpersona = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        pnlPersonaForm2 = new Clases.CrazyPanel();
        jLabel5 = new javax.swing.JLabel();
        txtdnipersona = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcelusuario = new javax.swing.JTextField();
        pnlPersonaForm3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbxestadopersona = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxtipousupersona = new javax.swing.JComboBox<>();
        btnaddperso = new javax.swing.JButton();
        btncancelper = new javax.swing.JButton();
        pnlPersonaForm4 = new Clases.CrazyPanel();
        jLabel9 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtruc = new javax.swing.JTextField();
        btncancelper1 = new javax.swing.JButton();
        btnmodper = new javax.swing.JButton();
        btndelper = new javax.swing.JButton();
        btncancelper2 = new javax.swing.JButton();
        pnlUsuarios = new raven.crazypanel.CrazyPanel();
        menuUsuarios = new Clases.CrazyPanel();
        btnmenu2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tablaUsuarios = new Clases.CrazyPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblusuarios = new javax.swing.JTable();
        UsuarioBotones = new Clases.CrazyPanel();
        pnlUsuarioForm = new Clases.CrazyPanel();
        pnlUsuarioForm1 = new Clases.CrazyPanel();
        jLabel13 = new javax.swing.JLabel();
        txtIdUser = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtContraUser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUserUsuario = new javax.swing.JTextField();
        pnlUsuarioForm2 = new Clases.CrazyPanel();
        txtDniUsers = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pnlUsuarioForm3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cbxestadoUser = new javax.swing.JComboBox<>();
        pnlUsuarioForm4 = new javax.swing.JPanel();
        btnactadduser = new javax.swing.JButton();
        btnadduser = new javax.swing.JButton();
        btncancelusu = new javax.swing.JButton();
        btnactmoduser = new javax.swing.JButton();
        btnmoduser = new javax.swing.JButton();
        btncancelusu1 = new javax.swing.JButton();
        btndeluser = new javax.swing.JButton();
        btnactdeluser = new javax.swing.JButton();
        btncancelusu2 = new javax.swing.JButton();
        pnlBotonesBusqueda2 = new Clases.CrazyPanel();
        txtBuscar2 = new javax.swing.JTextField();
        pnlTarjetas = new raven.crazypanel.CrazyPanel();
        menuTarjetas = new Clases.CrazyPanel();
        btnmenu3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tablaTarjetas = new Clases.CrazyPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbltarjetas = new javax.swing.JTable();
        TarjetaBotones = new Clases.CrazyPanel();
        pnlTarjetaForm = new Clases.CrazyPanel();
        pnlTarjetaForm1 = new Clases.CrazyPanel();
        jLabel17 = new javax.swing.JLabel();
        txtcodtarjeta = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cbxEstadotarjeta = new javax.swing.JComboBox<>();
        pnlTarjetaForm2 = new Clases.CrazyPanel();
        jLabel19 = new javax.swing.JLabel();
        txtdnipersonatarjeta = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtsaldo = new javax.swing.JTextField();
        pnlTarjeraopc = new javax.swing.JPanel();
        btnactaddtar = new javax.swing.JButton();
        btnaddtar = new javax.swing.JButton();
        btncanctar = new javax.swing.JButton();
        btnactmodtar = new javax.swing.JButton();
        btndeltar = new javax.swing.JButton();
        btncanctar1 = new javax.swing.JButton();
        btnmodtar = new javax.swing.JButton();
        btnactdelltar = new javax.swing.JButton();
        btncanctar2 = new javax.swing.JButton();
        pnlTarjetaForm3 = new Clases.CrazyPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jdcfechacaducTarjeta = new javax.swing.JFormattedTextField();
        jdcfechacreacionTarjeta = new javax.swing.JFormattedTextField();
        pnlBotonesBusqueda3 = new Clases.CrazyPanel();
        txtBuscar3 = new javax.swing.JTextField();
        pnlRecargas = new raven.crazypanel.CrazyPanel();
        menuRecargas = new Clases.CrazyPanel();
        btnmenu4 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        tablaRecargas = new Clases.CrazyPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblRecargas = new javax.swing.JTable();
        RecargaBotones = new Clases.CrazyPanel();
        pnlRecargasForm = new Clases.CrazyPanel();
        pnlRecargasForm1 = new Clases.CrazyPanel();
        jLabel22 = new javax.swing.JLabel();
        txtcodrecarga = new javax.swing.JTextField();
        cbxestadoRecarga = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        pnlRecargasForm2 = new Clases.CrazyPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtmontorecarga = new javax.swing.JTextField();
        cbxtarjetasrecarga = new javax.swing.JComboBox<>();
        pnlTarjeraopc4 = new javax.swing.JPanel();
        btnRegistrarRecarga = new javax.swing.JButton();
        btnModificarRecarga = new javax.swing.JButton();
        btnEliminarRecarga = new javax.swing.JButton();
        btnVerTicket = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtEmailDestino = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        pnlBotonesBusqueda4 = new Clases.CrazyPanel();
        txtBuscar4 = new javax.swing.JTextField();
        pnlConsumos = new raven.crazypanel.CrazyPanel();
        menuConsumos = new Clases.CrazyPanel();
        btnmenu5 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        tablaConsumos = new Clases.CrazyPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblConsumos = new javax.swing.JTable();
        ConsumoBotones = new Clases.CrazyPanel();
        pnlConsumosForm = new Clases.CrazyPanel();
        pnlConsumosForm1 = new Clases.CrazyPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtCodUnidadconsu = new javax.swing.JTextField();
        txtCodTarjetaconsu = new javax.swing.JTextField();
        pnlConsumosForm2 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        pnlConsumosForm3 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        cbxestadoConsumo1 = new javax.swing.JComboBox<>();
        txtCodConsumo = new javax.swing.JTextField();
        btnRegistrarConsumo = new javax.swing.JButton();
        btnModificarConsumo = new javax.swing.JButton();
        btnEliminarConsumo = new javax.swing.JButton();
        pnlConsumosForm4 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        cbxestadoConsumo = new javax.swing.JComboBox<>();
        pnlConsumosForm5 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        cbxestadoConsumo3 = new javax.swing.JComboBox<>();
        pnlBotonesBusqueda5 = new Clases.CrazyPanel();
        txtBuscar5 = new javax.swing.JTextField();
        pnlRutas = new raven.crazypanel.CrazyPanel();
        menuRutas = new Clases.CrazyPanel();
        btnmenu6 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        tablaRutas = new Clases.CrazyPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblrutas = new javax.swing.JTable();
        RutasBotones = new Clases.CrazyPanel();
        pnlRutasForm = new Clases.CrazyPanel();
        pnlPersonaForm6 = new Clases.CrazyPanel();
        jLabel30 = new javax.swing.JLabel();
        txtidrutman = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtnombreruta = new javax.swing.JTextField();
        pnlPersonaForm7 = new Clases.CrazyPanel();
        jLabel33 = new javax.swing.JLabel();
        txtmontoruta = new javax.swing.JTextField();
        cbxEstadoRuta = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        pnlTarjeraopc1 = new javax.swing.JPanel();
        btnAddRut = new javax.swing.JButton();
        btnRegrut = new javax.swing.JButton();
        btnCancelarManRut = new javax.swing.JButton();
        btnmodrut = new javax.swing.JButton();
        btnModRut = new javax.swing.JButton();
        btnCancelarManRut1 = new javax.swing.JButton();
        btndelrut = new javax.swing.JButton();
        btnelirut = new javax.swing.JButton();
        btnCancelarManRut2 = new javax.swing.JButton();
        pnlBotonesBusqueda6 = new Clases.CrazyPanel();
        txtBuscar6 = new javax.swing.JTextField();
        pnlEmpresas = new raven.crazypanel.CrazyPanel();
        menuEmpresas = new Clases.CrazyPanel();
        btnmenu7 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        tablaEmpresas = new Clases.CrazyPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblEmpresastrans = new javax.swing.JTable();
        EmpresasBotones = new Clases.CrazyPanel();
        pnlEmpresasForm = new Clases.CrazyPanel();
        pnlEmpresasForm1 = new Clases.CrazyPanel();
        jLabel36 = new javax.swing.JLabel();
        txtrucempresa = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtnombreempresa = new javax.swing.JTextField();
        pnlEmpresasForm2 = new Clases.CrazyPanel();
        jLabel38 = new javax.swing.JLabel();
        txtcolorempresa = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        cbxEstadoTranporte = new javax.swing.JComboBox<>();
        pnlTarjeraopc3 = new javax.swing.JPanel();
        btnactaddemp = new javax.swing.JButton();
        btnaddemp = new javax.swing.JButton();
        btncantrans = new javax.swing.JButton();
        btnactmodemp = new javax.swing.JButton();
        btnmodemp = new javax.swing.JButton();
        btncantrans1 = new javax.swing.JButton();
        btndelemp = new javax.swing.JButton();
        btnactdelemp = new javax.swing.JButton();
        btncantrans2 = new javax.swing.JButton();
        pnlBotonesBusqueda7 = new Clases.CrazyPanel();
        txtBuscar7 = new javax.swing.JTextField();
        pnlUnidades = new raven.crazypanel.CrazyPanel();
        menuUnidades = new Clases.CrazyPanel();
        btnmenu8 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        tablaUnidades = new Clases.CrazyPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblunidades = new javax.swing.JTable();
        UnidadesBotones = new Clases.CrazyPanel();
        pnlUnidadesForm = new Clases.CrazyPanel();
        pnlUnidadesForm1 = new Clases.CrazyPanel();
        jLabel41 = new javax.swing.JLabel();
        txtCodUnidad = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtCodSoat = new javax.swing.JTextField();
        pnlUnidadesForm2 = new Clases.CrazyPanel();
        jLabel43 = new javax.swing.JLabel();
        txtDniunidad = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtIdRutaUnidad = new javax.swing.JTextField();
        pnlUnidadesForm3 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        cbxEstadoUnidad = new javax.swing.JComboBox<>();
        pnlTarjeraopc2 = new javax.swing.JPanel();
        btnactaddunidad = new javax.swing.JButton();
        btnaddunidad = new javax.swing.JButton();
        btncanuni = new javax.swing.JButton();
        btnactmodiunidad = new javax.swing.JButton();
        btnmodunidad = new javax.swing.JButton();
        btncanuni1 = new javax.swing.JButton();
        btndeluni = new javax.swing.JButton();
        btnactdelunidad = new javax.swing.JButton();
        btncanuni2 = new javax.swing.JButton();
        pnlBotonesBusqueda8 = new Clases.CrazyPanel();
        txtBuscar8 = new javax.swing.JTextField();
        pnlReportes = new raven.crazypanel.CrazyPanel();
        menuUnidades1 = new Clases.CrazyPanel();
        btnmenu9 = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        tablaUnidades1 = new Clases.CrazyPanel();
        pnlUnidadesForm5 = new Clases.CrazyPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jdcFinal = new com.toedter.calendar.JDateChooser();
        jdcInicial = new com.toedter.calendar.JDateChooser();
        txtRutas = new javax.swing.JTextField();
        txtTransportistas = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        btnReporte1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        pnlUnidadesForm6 = new Clases.CrazyPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jdcFinalP = new com.toedter.calendar.JDateChooser();
        jdcInicialP = new com.toedter.calendar.JDateChooser();
        txtMontoFinal = new javax.swing.JTextField();
        txtMontoInicial = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        btnReporte2 = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        pnlUnidadesForm7 = new Clases.CrazyPanel();
        jLabel64 = new javax.swing.JLabel();
        jdcFinalF = new com.toedter.calendar.JDateChooser();
        jdcInicialF = new com.toedter.calendar.JDateChooser();
        jLabel67 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        btnReporte3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frame"); // NOI18N

        paneles.setLayout(new java.awt.CardLayout(30, 20));

        pnlPersonas.setLayout(new java.awt.BorderLayout());

        menuPersonas.setAlignmentX(1.0F);
        menuPersonas.setPreferredSize(new java.awt.Dimension(100, 80));

        btnmenu1.setBackground(new java.awt.Color(30, 30, 30));
        btnmenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icono/menu.png"))); // NOI18N
        btnmenu1.setPreferredSize(new java.awt.Dimension(120, 123));
        btnmenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenu1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Personas");
        jLabel1.setAlignmentX(1.0F);
        jLabel1.setPreferredSize(new java.awt.Dimension(262, 40));

        javax.swing.GroupLayout menuPersonasLayout = new javax.swing.GroupLayout(menuPersonas);
        menuPersonas.setLayout(menuPersonasLayout);
        menuPersonasLayout.setHorizontalGroup(
            menuPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPersonasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPersonasLayout.setVerticalGroup(
            menuPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPersonasLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(menuPersonasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPersonas.add(menuPersonas, java.awt.BorderLayout.PAGE_START);

        tablaPersonas.setPreferredSize(new java.awt.Dimension(1245, 530));

        tblpersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "A. Paterno", "A. Materno", "Celular", "Email", "Tipo Usuario", "RUC Empresa", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblpersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpersonasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpersonas);

        PersonaBotones.setEnabled(false);
        PersonaBotones.setPreferredSize(new java.awt.Dimension(900, 216));
        PersonaBotones.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                PersonaBotonesComponentAdded(evt);
            }
        });
        PersonaBotones.setLayout(new java.awt.BorderLayout());

        txtBuscar1.setMinimumSize(new java.awt.Dimension(650, 30));
        txtBuscar1.setPreferredSize(new java.awt.Dimension(450, 30));
        txtBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar1ActionPerformed(evt);
            }
        });

        btnactaddper.setText("Agregar");
        btnactaddper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnactaddperMouseClicked(evt);
            }
        });
        btnactaddper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactaddperActionPerformed(evt);
            }
        });

        btnactmodper.setText("Editar");
        btnactmodper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactmodperActionPerformed(evt);
            }
        });

        btnactdelper.setText("Eliminar");
        btnactdelper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactdelperActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesBusqueda1Layout = new javax.swing.GroupLayout(pnlBotonesBusqueda1);
        pnlBotonesBusqueda1.setLayout(pnlBotonesBusqueda1Layout);
        pnlBotonesBusqueda1Layout.setHorizontalGroup(
            pnlBotonesBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesBusqueda1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237)
                .addComponent(btnactaddper)
                .addGap(141, 141, 141)
                .addComponent(btnactmodper)
                .addGap(143, 143, 143)
                .addComponent(btnactdelper))
        );
        pnlBotonesBusqueda1Layout.setVerticalGroup(
            pnlBotonesBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlBotonesBusqueda1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(pnlBotonesBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnactaddper)
                    .addGroup(pnlBotonesBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnactdelper)
                        .addComponent(btnactmodper))))
        );

        PersonaBotones.add(pnlBotonesBusqueda1, java.awt.BorderLayout.PAGE_START);

        pnlPersonaForm.setMinimumSize(new java.awt.Dimension(1220, 200));
        pnlPersonaForm.setPreferredSize(new java.awt.Dimension(1217, 146));
        pnlPersonaForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPersonaForm1.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlPersonaForm1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("Nombre");
        pnlPersonaForm1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtnombrepersona.setEnabled(false);
        txtnombrepersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombrepersonaKeyTyped(evt);
            }
        });
        pnlPersonaForm1.add(txtnombrepersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 280, -1));

        jLabel12.setText("Apellido Materno");
        pnlPersonaForm1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, -1));

        txtapepatpersona.setEnabled(false);
        txtapepatpersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapepatpersonaActionPerformed(evt);
            }
        });
        txtapepatpersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapepatpersonaKeyTyped(evt);
            }
        });
        pnlPersonaForm1.add(txtapepatpersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 280, -1));

        txtapematpersona.setEnabled(false);
        txtapematpersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapematpersonaKeyTyped(evt);
            }
        });
        pnlPersonaForm1.add(txtapematpersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 280, -1));

        jLabel46.setText("Apellido Paterno");
        pnlPersonaForm1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, -1));

        pnlPersonaForm.add(pnlPersonaForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 160));

        pnlPersonaForm2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("DNI");
        pnlPersonaForm2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtdnipersona.setEnabled(false);
        txtdnipersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdnipersonaActionPerformed(evt);
            }
        });
        txtdnipersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdnipersonaKeyTyped(evt);
            }
        });
        pnlPersonaForm2.add(txtdnipersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, -1));

        jLabel6.setText("Celular");
        pnlPersonaForm2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txtcelusuario.setEnabled(false);
        pnlPersonaForm2.add(txtcelusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 150, -1));

        pnlPersonaForm.add(pnlPersonaForm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 220, 160));

        pnlPersonaForm3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Estado");
        pnlPersonaForm3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 101, -1));

        cbxestadopersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));
        cbxestadopersona.setToolTipText("");
        cbxestadopersona.setEnabled(false);
        pnlPersonaForm3.add(cbxestadopersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 186, -1));

        jLabel3.setText("Tipo de Usuario");
        pnlPersonaForm3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 132, -1));

        cbxtipousupersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Pasajero", "Conductor" }));
        cbxtipousupersona.setEnabled(false);
        pnlPersonaForm3.add(cbxtipousupersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 186, -1));

        btnaddperso.setText("Añadir");
        btnaddperso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddpersoActionPerformed(evt);
            }
        });
        pnlPersonaForm3.add(btnaddperso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        btncancelper.setText("Cancelar");
        btncancelper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelperActionPerformed(evt);
            }
        });
        pnlPersonaForm3.add(btncancelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        pnlPersonaForm.add(pnlPersonaForm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 230, 160));

        pnlPersonaForm4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Email");
        pnlPersonaForm4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtemail.setEnabled(false);
        pnlPersonaForm4.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 300, -1));

        jLabel10.setText("RUC de Empresa");
        pnlPersonaForm4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txtruc.setEnabled(false);
        pnlPersonaForm4.add(txtruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 300, -1));

        btncancelper1.setText("Cancelar");
        btncancelper1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelper1ActionPerformed(evt);
            }
        });
        pnlPersonaForm4.add(btncancelper1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        btnmodper.setText("Modificar");
        pnlPersonaForm4.add(btnmodper, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btndelper.setText("Eliminar");
        pnlPersonaForm4.add(btndelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        btncancelper2.setText("Cancelar");
        btncancelper2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelper2ActionPerformed(evt);
            }
        });
        pnlPersonaForm4.add(btncancelper2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        pnlPersonaForm.add(pnlPersonaForm4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 390, 160));

        PersonaBotones.add(pnlPersonaForm, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout tablaPersonasLayout = new javax.swing.GroupLayout(tablaPersonas);
        tablaPersonas.setLayout(tablaPersonasLayout);
        tablaPersonasLayout.setHorizontalGroup(
            tablaPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablaPersonasLayout.createSequentialGroup()
                .addComponent(PersonaBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 1263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(tablaPersonasLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tablaPersonasLayout.setVerticalGroup(
            tablaPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablaPersonasLayout.createSequentialGroup()
                .addComponent(PersonaBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlPersonas.add(tablaPersonas, java.awt.BorderLayout.CENTER);

        paneles.add(pnlPersonas, "card2");

        pnlUsuarios.setLayout(new java.awt.BorderLayout());

        menuUsuarios.setAlignmentX(1.0F);
        menuUsuarios.setPreferredSize(new java.awt.Dimension(100, 80));

        btnmenu2.setBackground(new java.awt.Color(30, 30, 30));
        btnmenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icono/menu.png"))); // NOI18N
        btnmenu2.setPreferredSize(new java.awt.Dimension(120, 123));
        btnmenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenu2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuarios");
        jLabel4.setAlignmentX(1.0F);
        jLabel4.setPreferredSize(new java.awt.Dimension(262, 40));

        javax.swing.GroupLayout menuUsuariosLayout = new javax.swing.GroupLayout(menuUsuarios);
        menuUsuarios.setLayout(menuUsuariosLayout);
        menuUsuariosLayout.setHorizontalGroup(
            menuUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(918, Short.MAX_VALUE))
        );
        menuUsuariosLayout.setVerticalGroup(
            menuUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuUsuariosLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(menuUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlUsuarios.add(menuUsuarios, java.awt.BorderLayout.PAGE_START);

        tablaUsuarios.setPreferredSize(new java.awt.Dimension(1245, 530));

        tblusuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Usuario", "DNI", "Usuario", "Contraseña", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblusuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblusuariosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblusuarios);

        UsuarioBotones.setEnabled(false);
        UsuarioBotones.setPreferredSize(new java.awt.Dimension(900, 216));
        UsuarioBotones.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                UsuarioBotonesComponentAdded(evt);
            }
        });
        UsuarioBotones.setLayout(new java.awt.BorderLayout());

        pnlUsuarioForm.setMinimumSize(new java.awt.Dimension(1220, 200));
        pnlUsuarioForm.setPreferredSize(new java.awt.Dimension(1217, 146));
        pnlUsuarioForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlUsuarioForm1.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlUsuarioForm1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("Id Usuario");
        pnlUsuarioForm1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtIdUser.setEnabled(false);
        txtIdUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUserActionPerformed(evt);
            }
        });
        pnlUsuarioForm1.add(txtIdUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 280, -1));

        jLabel14.setText("Usuario");
        pnlUsuarioForm1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, -1));

        txtContraUser.setEnabled(false);
        txtContraUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraUserActionPerformed(evt);
            }
        });
        pnlUsuarioForm1.add(txtContraUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 280, -1));

        jLabel8.setText("Contraseña");
        pnlUsuarioForm1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, -1));

        txtUserUsuario.setEnabled(false);
        txtUserUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserUsuarioActionPerformed(evt);
            }
        });
        pnlUsuarioForm1.add(txtUserUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 280, -1));

        pnlUsuarioForm.add(pnlUsuarioForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 160));

        pnlUsuarioForm2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDniUsers.setEnabled(false);
        pnlUsuarioForm2.add(txtDniUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, -1));

        jLabel15.setText("DNI");
        pnlUsuarioForm2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        pnlUsuarioForm.add(pnlUsuarioForm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 220, 160));

        pnlUsuarioForm3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setText("Estado");
        pnlUsuarioForm3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 14, 101, -1));

        cbxestadoUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));
        cbxestadoUser.setEnabled(false);
        pnlUsuarioForm3.add(cbxestadoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 36, 186, -1));

        pnlUsuarioForm.add(pnlUsuarioForm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 220, 150));

        btnactadduser.setText("Agregar");
        btnactadduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactadduserActionPerformed(evt);
            }
        });

        btnadduser.setText("Agregar");
        btnadduser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnadduserMouseClicked(evt);
            }
        });
        btnadduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadduserActionPerformed(evt);
            }
        });

        btncancelusu.setText("Cancelar");
        btncancelusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelusuActionPerformed(evt);
            }
        });

        btnactmoduser.setText("Modificar");
        btnactmoduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactmoduserActionPerformed(evt);
            }
        });

        btnmoduser.setText("Modificar");
        btnmoduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmoduserActionPerformed(evt);
            }
        });

        btncancelusu1.setText("Cancelar");
        btncancelusu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelusu1ActionPerformed(evt);
            }
        });

        btndeluser.setText("Eliminar");

        btnactdeluser.setText("Eliminar");
        btnactdeluser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactdeluserActionPerformed(evt);
            }
        });

        btncancelusu2.setText("Cancelar");
        btncancelusu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelusu2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUsuarioForm4Layout = new javax.swing.GroupLayout(pnlUsuarioForm4);
        pnlUsuarioForm4.setLayout(pnlUsuarioForm4Layout);
        pnlUsuarioForm4Layout.setHorizontalGroup(
            pnlUsuarioForm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioForm4Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnactadduser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioForm4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnactmoduser)
                .addGap(67, 67, 67))
            .addGroup(pnlUsuarioForm4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlUsuarioForm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUsuarioForm4Layout.createSequentialGroup()
                        .addComponent(btnmoduser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncancelusu1))
                    .addGroup(pnlUsuarioForm4Layout.createSequentialGroup()
                        .addComponent(btnadduser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncancelusu))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioForm4Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnactdeluser)
                        .addGap(49, 49, 49))
                    .addGroup(pnlUsuarioForm4Layout.createSequentialGroup()
                        .addComponent(btndeluser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncancelusu2)))
                .addGap(18, 18, 18))
        );
        pnlUsuarioForm4Layout.setVerticalGroup(
            pnlUsuarioForm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioForm4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnactadduser)
                .addGap(4, 4, 4)
                .addGroup(pnlUsuarioForm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadduser)
                    .addComponent(btncancelusu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnactmoduser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUsuarioForm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmoduser)
                    .addComponent(btncancelusu1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnactdeluser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUsuarioForm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndeluser)
                    .addComponent(btncancelusu2))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pnlUsuarioForm.add(pnlUsuarioForm4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 220, 200));

        UsuarioBotones.add(pnlUsuarioForm, java.awt.BorderLayout.CENTER);

        pnlBotonesBusqueda2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar2.setMinimumSize(new java.awt.Dimension(650, 30));
        txtBuscar2.setPreferredSize(new java.awt.Dimension(450, 30));
        txtBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar2ActionPerformed(evt);
            }
        });
        pnlBotonesBusqueda2.add(txtBuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 574, -1));

        UsuarioBotones.add(pnlBotonesBusqueda2, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout tablaUsuariosLayout = new javax.swing.GroupLayout(tablaUsuarios);
        tablaUsuarios.setLayout(tablaUsuariosLayout);
        tablaUsuariosLayout.setHorizontalGroup(
            tablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UsuarioBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
            .addGroup(tablaUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tablaUsuariosLayout.setVerticalGroup(
            tablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablaUsuariosLayout.createSequentialGroup()
                .addComponent(UsuarioBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlUsuarios.add(tablaUsuarios, java.awt.BorderLayout.CENTER);

        paneles.add(pnlUsuarios, "card2");

        pnlTarjetas.setLayout(new java.awt.BorderLayout());

        menuTarjetas.setAlignmentX(1.0F);
        menuTarjetas.setPreferredSize(new java.awt.Dimension(100, 80));

        btnmenu3.setBackground(new java.awt.Color(30, 30, 30));
        btnmenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icono/menu.png"))); // NOI18N
        btnmenu3.setPreferredSize(new java.awt.Dimension(120, 123));
        btnmenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenu3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tarjetas");
        jLabel2.setAlignmentX(1.0F);
        jLabel2.setPreferredSize(new java.awt.Dimension(262, 40));

        javax.swing.GroupLayout menuTarjetasLayout = new javax.swing.GroupLayout(menuTarjetas);
        menuTarjetas.setLayout(menuTarjetasLayout);
        menuTarjetasLayout.setHorizontalGroup(
            menuTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTarjetasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(900, Short.MAX_VALUE))
        );
        menuTarjetasLayout.setVerticalGroup(
            menuTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuTarjetasLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(menuTarjetasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTarjetas.add(menuTarjetas, java.awt.BorderLayout.PAGE_START);

        tablaTarjetas.setPreferredSize(new java.awt.Dimension(1245, 530));

        tbltarjetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Tarjeta", "Emisión", "Caducidad", "DNI", "Saldo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbltarjetas);

        TarjetaBotones.setEnabled(false);
        TarjetaBotones.setPreferredSize(new java.awt.Dimension(900, 216));
        TarjetaBotones.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                TarjetaBotonesComponentAdded(evt);
            }
        });
        TarjetaBotones.setLayout(new java.awt.BorderLayout());

        pnlTarjetaForm.setMinimumSize(new java.awt.Dimension(1220, 200));
        pnlTarjetaForm.setPreferredSize(new java.awt.Dimension(1217, 146));
        pnlTarjetaForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTarjetaForm1.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlTarjetaForm1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setText("Código de Tarjeta");
        pnlTarjetaForm1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        pnlTarjetaForm1.add(txtcodtarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 280, -1));

        jLabel21.setText("Estado");
        pnlTarjetaForm1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 101, -1));

        cbxEstadotarjeta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Activo", "Inactivo" }));
        pnlTarjetaForm1.add(cbxEstadotarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 186, -1));

        pnlTarjetaForm.add(pnlTarjetaForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 160));

        pnlTarjetaForm2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setText("DNI");
        pnlTarjetaForm2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        pnlTarjetaForm2.add(txtdnipersonatarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, -1));

        jLabel20.setText("Saldo");
        pnlTarjetaForm2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        pnlTarjetaForm2.add(txtsaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, -1));

        pnlTarjetaForm.add(pnlTarjetaForm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 220, 160));

        pnlTarjeraopc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnactaddtar.setText("Agregar");
        btnactaddtar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactaddtarActionPerformed(evt);
            }
        });
        pnlTarjeraopc.add(btnactaddtar, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 6, -1, -1));

        btnaddtar.setText("Agregar");
        btnaddtar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddtarMouseClicked(evt);
            }
        });
        btnaddtar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddtarActionPerformed(evt);
            }
        });
        pnlTarjeraopc.add(btnaddtar, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 33, -1, -1));

        btncanctar.setText("Cancelar");
        btncanctar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncanctarActionPerformed(evt);
            }
        });
        pnlTarjeraopc.add(btncanctar, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 33, -1, -1));

        btnactmodtar.setText("Modificar");
        btnactmodtar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactmodtarActionPerformed(evt);
            }
        });
        pnlTarjeraopc.add(btnactmodtar, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 62, -1, -1));

        btndeltar.setText("Modificar");
        btndeltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeltarActionPerformed(evt);
            }
        });
        pnlTarjeraopc.add(btndeltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 91, -1, -1));

        btncanctar1.setText("Cancelar");
        btncanctar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncanctar1ActionPerformed(evt);
            }
        });
        pnlTarjeraopc.add(btncanctar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 91, -1, -1));

        btnmodtar.setText("Eliminar");
        pnlTarjeraopc.add(btnmodtar, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 149, -1, -1));

        btnactdelltar.setText("Eliminar");
        btnactdelltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactdelltarActionPerformed(evt);
            }
        });
        pnlTarjeraopc.add(btnactdelltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        btncanctar2.setText("Cancelar");
        pnlTarjeraopc.add(btncanctar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 149, -1, -1));

        pnlTarjetaForm.add(pnlTarjeraopc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 220, 180));

        pnlTarjetaForm3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setText("Fecha de Emisión");
        pnlTarjetaForm3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel24.setText("Fecha de Caducidad");
        pnlTarjetaForm3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        pnlTarjetaForm3.add(jdcfechacaducTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 300, -1));
        pnlTarjetaForm3.add(jdcfechacreacionTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 300, -1));

        pnlTarjetaForm.add(pnlTarjetaForm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 340, 160));

        TarjetaBotones.add(pnlTarjetaForm, java.awt.BorderLayout.CENTER);

        txtBuscar3.setMinimumSize(new java.awt.Dimension(650, 30));
        txtBuscar3.setPreferredSize(new java.awt.Dimension(450, 30));
        txtBuscar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesBusqueda3Layout = new javax.swing.GroupLayout(pnlBotonesBusqueda3);
        pnlBotonesBusqueda3.setLayout(pnlBotonesBusqueda3Layout);
        pnlBotonesBusqueda3Layout.setHorizontalGroup(
            pnlBotonesBusqueda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesBusqueda3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(788, Short.MAX_VALUE))
        );
        pnlBotonesBusqueda3Layout.setVerticalGroup(
            pnlBotonesBusqueda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesBusqueda3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TarjetaBotones.add(pnlBotonesBusqueda3, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout tablaTarjetasLayout = new javax.swing.GroupLayout(tablaTarjetas);
        tablaTarjetas.setLayout(tablaTarjetasLayout);
        tablaTarjetasLayout.setHorizontalGroup(
            tablaTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TarjetaBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1245, Short.MAX_VALUE)
            .addGroup(tablaTarjetasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tablaTarjetasLayout.setVerticalGroup(
            tablaTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablaTarjetasLayout.createSequentialGroup()
                .addComponent(TarjetaBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlTarjetas.add(tablaTarjetas, java.awt.BorderLayout.CENTER);

        paneles.add(pnlTarjetas, "card2");

        pnlRecargas.setLayout(new java.awt.BorderLayout());

        menuRecargas.setAlignmentX(1.0F);
        menuRecargas.setPreferredSize(new java.awt.Dimension(100, 80));

        btnmenu4.setBackground(new java.awt.Color(30, 30, 30));
        btnmenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icono/menu.png"))); // NOI18N
        btnmenu4.setPreferredSize(new java.awt.Dimension(120, 123));
        btnmenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenu4ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Recargas");
        jLabel18.setAlignmentX(1.0F);
        jLabel18.setPreferredSize(new java.awt.Dimension(262, 40));

        javax.swing.GroupLayout menuRecargasLayout = new javax.swing.GroupLayout(menuRecargas);
        menuRecargas.setLayout(menuRecargasLayout);
        menuRecargasLayout.setHorizontalGroup(
            menuRecargasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuRecargasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(900, Short.MAX_VALUE))
        );
        menuRecargasLayout.setVerticalGroup(
            menuRecargasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuRecargasLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(menuRecargasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlRecargas.add(menuRecargas, java.awt.BorderLayout.PAGE_START);

        tablaRecargas.setPreferredSize(new java.awt.Dimension(1245, 530));
        tablaRecargas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblRecargas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo de Recarga", "Monto de Recarga", "Tarjeta", "Fecha de Recarga", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblRecargas);

        tablaRecargas.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 244, 1245, 350));

        RecargaBotones.setEnabled(false);
        RecargaBotones.setPreferredSize(new java.awt.Dimension(900, 216));
        RecargaBotones.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                RecargaBotonesComponentAdded(evt);
            }
        });
        RecargaBotones.setLayout(new java.awt.BorderLayout());

        pnlRecargasForm.setMinimumSize(new java.awt.Dimension(1220, 200));
        pnlRecargasForm.setPreferredSize(new java.awt.Dimension(1217, 146));
        pnlRecargasForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlRecargasForm1.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlRecargasForm1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setText("CodRecarga");
        pnlRecargasForm1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        pnlRecargasForm1.add(txtcodrecarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, -1));

        cbxestadoRecarga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));
        pnlRecargasForm1.add(cbxestadoRecarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 186, -1));

        jLabel54.setText("Estado");
        pnlRecargasForm1.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 101, -1));

        pnlRecargasForm.add(pnlRecargasForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 340, 160));

        pnlRecargasForm2.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlRecargasForm2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setText("N\" de Tarjeta");
        pnlRecargasForm2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel53.setText("Monto");
        pnlRecargasForm2.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, -1));

        txtmontorecarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmontorecargaActionPerformed(evt);
            }
        });
        pnlRecargasForm2.add(txtmontorecarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 280, -1));

        pnlRecargasForm2.add(cbxtarjetasrecarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 280, -1));

        pnlRecargasForm.add(pnlRecargasForm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 340, 160));

        pnlTarjeraopc4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrarRecarga.setText("Recargar");
        btnRegistrarRecarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarRecargaMouseClicked(evt);
            }
        });
        btnRegistrarRecarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarRecargaActionPerformed(evt);
            }
        });
        pnlTarjeraopc4.add(btnRegistrarRecarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 33, -1, -1));

        btnModificarRecarga.setText("Modificar");
        btnModificarRecarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarRecargaActionPerformed(evt);
            }
        });
        pnlTarjeraopc4.add(btnModificarRecarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 91, -1, -1));

        btnEliminarRecarga.setText("Eliminar");
        pnlTarjeraopc4.add(btnEliminarRecarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 149, -1, -1));

        pnlRecargasForm.add(pnlTarjeraopc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 220, 180));

        btnVerTicket.setText("Ver Ticket");
        btnVerTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTicketActionPerformed(evt);
            }
        });
        pnlRecargasForm.add(btnVerTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 130, 40));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel66.setText("Enviar ticket a un Email");
        pnlRecargasForm.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 160, 30));

        jLabel56.setText("Email de Destino");
        pnlRecargasForm.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, 150, 30));
        pnlRecargasForm.add(txtEmailDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 180, 40));

        btnEnviar.setText("Enviar Ticket ");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        pnlRecargasForm.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 130, 100, 40));

        RecargaBotones.add(pnlRecargasForm, java.awt.BorderLayout.CENTER);

        pnlBotonesBusqueda4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar4.setMinimumSize(new java.awt.Dimension(650, 30));
        txtBuscar4.setPreferredSize(new java.awt.Dimension(450, 30));
        txtBuscar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar4ActionPerformed(evt);
            }
        });
        pnlBotonesBusqueda4.add(txtBuscar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        RecargaBotones.add(pnlBotonesBusqueda4, java.awt.BorderLayout.PAGE_START);

        tablaRecargas.add(RecargaBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1245, -1));

        pnlRecargas.add(tablaRecargas, java.awt.BorderLayout.CENTER);

        paneles.add(pnlRecargas, "card2");

        pnlConsumos.setLayout(new java.awt.BorderLayout());

        menuConsumos.setAlignmentX(1.0F);
        menuConsumos.setPreferredSize(new java.awt.Dimension(100, 80));

        btnmenu5.setBackground(new java.awt.Color(30, 30, 30));
        btnmenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icono/menu.png"))); // NOI18N
        btnmenu5.setPreferredSize(new java.awt.Dimension(120, 123));
        btnmenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenu5ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Consumos");
        jLabel26.setAlignmentX(1.0F);
        jLabel26.setPreferredSize(new java.awt.Dimension(262, 40));

        javax.swing.GroupLayout menuConsumosLayout = new javax.swing.GroupLayout(menuConsumos);
        menuConsumos.setLayout(menuConsumosLayout);
        menuConsumosLayout.setHorizontalGroup(
            menuConsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuConsumosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(918, Short.MAX_VALUE))
        );
        menuConsumosLayout.setVerticalGroup(
            menuConsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuConsumosLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(menuConsumosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlConsumos.add(menuConsumos, java.awt.BorderLayout.PAGE_START);

        tablaConsumos.setPreferredSize(new java.awt.Dimension(1245, 530));

        tblConsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Consumo", "Monto de Consumo", "Tarjeta", "Unidad", "Fecha de Consumo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblConsumos);

        ConsumoBotones.setEnabled(false);
        ConsumoBotones.setPreferredSize(new java.awt.Dimension(900, 216));
        ConsumoBotones.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                ConsumoBotonesComponentAdded(evt);
            }
        });
        ConsumoBotones.setLayout(new java.awt.BorderLayout());

        pnlConsumosForm.setMinimumSize(new java.awt.Dimension(1220, 200));
        pnlConsumosForm.setPreferredSize(new java.awt.Dimension(1217, 146));
        pnlConsumosForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlConsumosForm1.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlConsumosForm1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setText("N° de Tarjeta");
        pnlConsumosForm1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel28.setText("Unidad");
        pnlConsumosForm1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, -1));

        txtCodUnidadconsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodUnidadconsuActionPerformed(evt);
            }
        });
        pnlConsumosForm1.add(txtCodUnidadconsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 280, -1));
        pnlConsumosForm1.add(txtCodTarjetaconsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 280, -1));

        pnlConsumosForm.add(pnlConsumosForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 340, 160));

        pnlConsumosForm2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setText("CodConsumo");
        pnlConsumosForm2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 14, 101, -1));

        pnlConsumosForm3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setText("Estado");
        pnlConsumosForm3.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 14, 101, -1));

        cbxestadoConsumo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));
        pnlConsumosForm3.add(cbxestadoConsumo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 36, 186, -1));

        pnlConsumosForm2.add(pnlConsumosForm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 220, 160));
        pnlConsumosForm2.add(txtCodConsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 140, -1));

        pnlConsumosForm.add(pnlConsumosForm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 160));

        btnRegistrarConsumo.setText("Registar");
        btnRegistrarConsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarConsumoMouseClicked(evt);
            }
        });
        btnRegistrarConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarConsumoActionPerformed(evt);
            }
        });
        pnlConsumosForm.add(btnRegistrarConsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, -1));

        btnModificarConsumo.setText("Eliminar");
        btnModificarConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarConsumoActionPerformed(evt);
            }
        });
        pnlConsumosForm.add(btnModificarConsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, -1, -1));

        btnEliminarConsumo.setText("Eliminar");
        btnEliminarConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarConsumoActionPerformed(evt);
            }
        });
        pnlConsumosForm.add(btnEliminarConsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 20, -1, -1));

        pnlConsumosForm4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setText("Estado");
        pnlConsumosForm4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 14, 101, -1));

        cbxestadoConsumo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));
        pnlConsumosForm4.add(cbxestadoConsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 36, 186, -1));

        pnlConsumosForm5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setText("Estado");
        pnlConsumosForm5.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 14, 101, -1));

        cbxestadoConsumo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));
        pnlConsumosForm5.add(cbxestadoConsumo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 36, 186, -1));

        pnlConsumosForm4.add(pnlConsumosForm5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 220, 160));

        pnlConsumosForm.add(pnlConsumosForm4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 220, 160));

        ConsumoBotones.add(pnlConsumosForm, java.awt.BorderLayout.CENTER);

        txtBuscar5.setMinimumSize(new java.awt.Dimension(650, 30));
        txtBuscar5.setPreferredSize(new java.awt.Dimension(450, 30));
        txtBuscar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesBusqueda5Layout = new javax.swing.GroupLayout(pnlBotonesBusqueda5);
        pnlBotonesBusqueda5.setLayout(pnlBotonesBusqueda5Layout);
        pnlBotonesBusqueda5Layout.setHorizontalGroup(
            pnlBotonesBusqueda5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesBusqueda5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtBuscar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(806, Short.MAX_VALUE))
        );
        pnlBotonesBusqueda5Layout.setVerticalGroup(
            pnlBotonesBusqueda5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesBusqueda5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtBuscar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        ConsumoBotones.add(pnlBotonesBusqueda5, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout tablaConsumosLayout = new javax.swing.GroupLayout(tablaConsumos);
        tablaConsumos.setLayout(tablaConsumosLayout);
        tablaConsumosLayout.setHorizontalGroup(
            tablaConsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConsumoBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablaConsumosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        tablaConsumosLayout.setVerticalGroup(
            tablaConsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablaConsumosLayout.createSequentialGroup()
                .addComponent(ConsumoBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlConsumos.add(tablaConsumos, java.awt.BorderLayout.CENTER);

        paneles.add(pnlConsumos, "card2");

        pnlRutas.setLayout(new java.awt.BorderLayout());

        menuRutas.setAlignmentX(1.0F);
        menuRutas.setPreferredSize(new java.awt.Dimension(100, 80));

        btnmenu6.setBackground(new java.awt.Color(30, 30, 30));
        btnmenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icono/menu.png"))); // NOI18N
        btnmenu6.setPreferredSize(new java.awt.Dimension(120, 123));
        btnmenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenu6ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Rutas");
        jLabel29.setAlignmentX(1.0F);
        jLabel29.setPreferredSize(new java.awt.Dimension(262, 40));

        javax.swing.GroupLayout menuRutasLayout = new javax.swing.GroupLayout(menuRutas);
        menuRutas.setLayout(menuRutasLayout);
        menuRutasLayout.setHorizontalGroup(
            menuRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuRutasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(918, Short.MAX_VALUE))
        );
        menuRutasLayout.setVerticalGroup(
            menuRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuRutasLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(menuRutasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlRutas.add(menuRutas, java.awt.BorderLayout.PAGE_START);

        tablaRutas.setPreferredSize(new java.awt.Dimension(1245, 530));

        tblrutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID de Ruta", "Nombre de Ruta", "Monto de Ruta", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblrutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblrutasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblrutas);

        RutasBotones.setEnabled(false);
        RutasBotones.setPreferredSize(new java.awt.Dimension(900, 216));
        RutasBotones.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                RutasBotonesComponentAdded(evt);
            }
        });
        RutasBotones.setLayout(new java.awt.BorderLayout());

        pnlRutasForm.setMinimumSize(new java.awt.Dimension(1220, 200));
        pnlRutasForm.setPreferredSize(new java.awt.Dimension(1217, 146));
        pnlRutasForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPersonaForm6.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlPersonaForm6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setText("ID de Ruta");
        pnlPersonaForm6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtidrutman.setEnabled(false);
        pnlPersonaForm6.add(txtidrutman, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 280, -1));

        jLabel32.setText("Nombre de Ruta");
        pnlPersonaForm6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, -1));

        txtnombreruta.setEnabled(false);
        txtnombreruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombrerutaActionPerformed(evt);
            }
        });
        pnlPersonaForm6.add(txtnombreruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 280, -1));

        pnlRutasForm.add(pnlPersonaForm6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 340, 160));

        pnlPersonaForm7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setText("Monto de Ruta");
        pnlPersonaForm7.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtmontoruta.setEnabled(false);
        pnlPersonaForm7.add(txtmontoruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, -1));

        cbxEstadoRuta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));
        cbxEstadoRuta.setEnabled(false);
        pnlPersonaForm7.add(cbxEstadoRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 186, -1));

        jLabel35.setText("Estado");
        pnlPersonaForm7.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 101, -1));

        pnlRutasForm.add(pnlPersonaForm7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 220, 160));

        pnlTarjeraopc1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddRut.setText("Agregar");
        btnAddRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRutActionPerformed(evt);
            }
        });
        pnlTarjeraopc1.add(btnAddRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        btnRegrut.setText("Agregar");
        btnRegrut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegrutMouseClicked(evt);
            }
        });
        btnRegrut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegrutActionPerformed(evt);
            }
        });
        pnlTarjeraopc1.add(btnRegrut, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 33, -1, -1));

        btnCancelarManRut.setText("Cancelar");
        btnCancelarManRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarManRutActionPerformed(evt);
            }
        });
        pnlTarjeraopc1.add(btnCancelarManRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 33, -1, -1));

        btnmodrut.setText("Modificar");
        btnmodrut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodrutActionPerformed(evt);
            }
        });
        pnlTarjeraopc1.add(btnmodrut, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        btnModRut.setText("Modificar");
        btnModRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModRutActionPerformed(evt);
            }
        });
        pnlTarjeraopc1.add(btnModRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 91, -1, -1));

        btnCancelarManRut1.setText("Cancelar");
        btnCancelarManRut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarManRut1ActionPerformed(evt);
            }
        });
        pnlTarjeraopc1.add(btnCancelarManRut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 91, -1, -1));

        btndelrut.setText("Eliminar");
        pnlTarjeraopc1.add(btndelrut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        btnelirut.setText("Eliminar");
        btnelirut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelirutActionPerformed(evt);
            }
        });
        pnlTarjeraopc1.add(btnelirut, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        btnCancelarManRut2.setText("Cancelar");
        btnCancelarManRut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarManRut2ActionPerformed(evt);
            }
        });
        pnlTarjeraopc1.add(btnCancelarManRut2, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 149, -1, -1));

        pnlRutasForm.add(pnlTarjeraopc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 220, 180));

        RutasBotones.add(pnlRutasForm, java.awt.BorderLayout.CENTER);

        txtBuscar6.setMinimumSize(new java.awt.Dimension(650, 30));
        txtBuscar6.setPreferredSize(new java.awt.Dimension(450, 30));
        txtBuscar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesBusqueda6Layout = new javax.swing.GroupLayout(pnlBotonesBusqueda6);
        pnlBotonesBusqueda6.setLayout(pnlBotonesBusqueda6Layout);
        pnlBotonesBusqueda6Layout.setHorizontalGroup(
            pnlBotonesBusqueda6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesBusqueda6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtBuscar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(806, Short.MAX_VALUE))
        );
        pnlBotonesBusqueda6Layout.setVerticalGroup(
            pnlBotonesBusqueda6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesBusqueda6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtBuscar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        RutasBotones.add(pnlBotonesBusqueda6, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout tablaRutasLayout = new javax.swing.GroupLayout(tablaRutas);
        tablaRutas.setLayout(tablaRutasLayout);
        tablaRutasLayout.setHorizontalGroup(
            tablaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RutasBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablaRutasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        tablaRutasLayout.setVerticalGroup(
            tablaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablaRutasLayout.createSequentialGroup()
                .addComponent(RutasBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlRutas.add(tablaRutas, java.awt.BorderLayout.CENTER);

        paneles.add(pnlRutas, "card2");

        pnlEmpresas.setLayout(new java.awt.BorderLayout());

        menuEmpresas.setAlignmentX(1.0F);
        menuEmpresas.setPreferredSize(new java.awt.Dimension(100, 80));

        btnmenu7.setBackground(new java.awt.Color(30, 30, 30));
        btnmenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icono/menu.png"))); // NOI18N
        btnmenu7.setPreferredSize(new java.awt.Dimension(120, 123));
        btnmenu7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenu7ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Empresas");
        jLabel34.setAlignmentX(1.0F);
        jLabel34.setPreferredSize(new java.awt.Dimension(262, 40));

        javax.swing.GroupLayout menuEmpresasLayout = new javax.swing.GroupLayout(menuEmpresas);
        menuEmpresas.setLayout(menuEmpresasLayout);
        menuEmpresasLayout.setHorizontalGroup(
            menuEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEmpresasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(918, Short.MAX_VALUE))
        );
        menuEmpresasLayout.setVerticalGroup(
            menuEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuEmpresasLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(menuEmpresasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlEmpresas.add(menuEmpresas, java.awt.BorderLayout.PAGE_START);

        tablaEmpresas.setPreferredSize(new java.awt.Dimension(1245, 530));

        tblEmpresastrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUC Empresa", "Nombre Empresa", "Color", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblEmpresastrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpresastransMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblEmpresastrans);

        EmpresasBotones.setEnabled(false);
        EmpresasBotones.setPreferredSize(new java.awt.Dimension(900, 216));
        EmpresasBotones.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                EmpresasBotonesComponentAdded(evt);
            }
        });
        EmpresasBotones.setLayout(new java.awt.BorderLayout());

        pnlEmpresasForm.setMinimumSize(new java.awt.Dimension(1220, 200));
        pnlEmpresasForm.setPreferredSize(new java.awt.Dimension(1217, 146));
        pnlEmpresasForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlEmpresasForm1.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlEmpresasForm1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setText("RUC de Empresa");
        pnlEmpresasForm1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtrucempresa.setEnabled(false);
        pnlEmpresasForm1.add(txtrucempresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 280, -1));

        jLabel37.setText("Nombre de Empresa");
        pnlEmpresasForm1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, -1));

        txtnombreempresa.setEnabled(false);
        txtnombreempresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreempresaActionPerformed(evt);
            }
        });
        pnlEmpresasForm1.add(txtnombreempresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 280, -1));

        pnlEmpresasForm.add(pnlEmpresasForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 340, 160));

        pnlEmpresasForm2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setText("Color");
        pnlEmpresasForm2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtcolorempresa.setEnabled(false);
        pnlEmpresasForm2.add(txtcolorempresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        jLabel40.setText("Estado");
        pnlEmpresasForm2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 101, -1));

        cbxEstadoTranporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));
        cbxEstadoTranporte.setEnabled(false);
        pnlEmpresasForm2.add(cbxEstadoTranporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 186, -1));

        pnlEmpresasForm.add(pnlEmpresasForm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 220, 160));

        btnactaddemp.setText("Agregar");
        btnactaddemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactaddempActionPerformed(evt);
            }
        });

        btnaddemp.setText("Agregar");
        btnaddemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddempMouseClicked(evt);
            }
        });
        btnaddemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddempActionPerformed(evt);
            }
        });

        btncantrans.setText("Cancelar");
        btncantrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncantransActionPerformed(evt);
            }
        });

        btnactmodemp.setText("Modificar");
        btnactmodemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactmodempActionPerformed(evt);
            }
        });

        btnmodemp.setText("Modificar");
        btnmodemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodempActionPerformed(evt);
            }
        });

        btncantrans1.setText("Cancelar");
        btncantrans1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncantrans1ActionPerformed(evt);
            }
        });

        btndelemp.setText("Eliminar");

        btnactdelemp.setText("Eliminar");
        btnactdelemp.setEnabled(true);
        btnactdelemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactdelempActionPerformed(evt);
            }
        });

        btncantrans2.setText("Cancelar");
        btncantrans2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncantrans2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTarjeraopc3Layout = new javax.swing.GroupLayout(pnlTarjeraopc3);
        pnlTarjeraopc3.setLayout(pnlTarjeraopc3Layout);
        pnlTarjeraopc3Layout.setHorizontalGroup(
            pnlTarjeraopc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTarjeraopc3Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnactaddemp))
            .addGroup(pnlTarjeraopc3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnaddemp)
                .addGap(23, 23, 23)
                .addComponent(btncantrans))
            .addGroup(pnlTarjeraopc3Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnactmodemp))
            .addGroup(pnlTarjeraopc3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnmodemp)
                .addGap(14, 14, 14)
                .addComponent(btncantrans1))
            .addGroup(pnlTarjeraopc3Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnactdelemp))
            .addGroup(pnlTarjeraopc3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btndelemp)
                .addGap(22, 22, 22)
                .addComponent(btncantrans2))
        );
        pnlTarjeraopc3Layout.setVerticalGroup(
            pnlTarjeraopc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTarjeraopc3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnactaddemp)
                .addGap(4, 4, 4)
                .addGroup(pnlTarjeraopc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnaddemp)
                    .addComponent(btncantrans))
                .addGap(6, 6, 6)
                .addComponent(btnactmodemp)
                .addGap(6, 6, 6)
                .addGroup(pnlTarjeraopc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnmodemp)
                    .addComponent(btncantrans1))
                .addGap(6, 6, 6)
                .addComponent(btnactdelemp)
                .addGap(6, 6, 6)
                .addGroup(pnlTarjeraopc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btndelemp)
                    .addComponent(btncantrans2)))
        );

        pnlEmpresasForm.add(pnlTarjeraopc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, 220, 180));

        EmpresasBotones.add(pnlEmpresasForm, java.awt.BorderLayout.CENTER);

        txtBuscar7.setMinimumSize(new java.awt.Dimension(650, 30));
        txtBuscar7.setPreferredSize(new java.awt.Dimension(450, 30));
        txtBuscar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesBusqueda7Layout = new javax.swing.GroupLayout(pnlBotonesBusqueda7);
        pnlBotonesBusqueda7.setLayout(pnlBotonesBusqueda7Layout);
        pnlBotonesBusqueda7Layout.setHorizontalGroup(
            pnlBotonesBusqueda7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesBusqueda7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtBuscar7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(806, Short.MAX_VALUE))
        );
        pnlBotonesBusqueda7Layout.setVerticalGroup(
            pnlBotonesBusqueda7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesBusqueda7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtBuscar7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        EmpresasBotones.add(pnlBotonesBusqueda7, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout tablaEmpresasLayout = new javax.swing.GroupLayout(tablaEmpresas);
        tablaEmpresas.setLayout(tablaEmpresasLayout);
        tablaEmpresasLayout.setHorizontalGroup(
            tablaEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EmpresasBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablaEmpresasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        tablaEmpresasLayout.setVerticalGroup(
            tablaEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablaEmpresasLayout.createSequentialGroup()
                .addComponent(EmpresasBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlEmpresas.add(tablaEmpresas, java.awt.BorderLayout.CENTER);

        paneles.add(pnlEmpresas, "card2");

        pnlUnidades.setLayout(new java.awt.BorderLayout());

        menuUnidades.setAlignmentX(1.0F);
        menuUnidades.setPreferredSize(new java.awt.Dimension(100, 80));

        btnmenu8.setBackground(new java.awt.Color(30, 30, 30));
        btnmenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icono/menu.png"))); // NOI18N
        btnmenu8.setPreferredSize(new java.awt.Dimension(120, 123));
        btnmenu8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenu8ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Unidades");
        jLabel39.setAlignmentX(1.0F);
        jLabel39.setPreferredSize(new java.awt.Dimension(262, 40));

        javax.swing.GroupLayout menuUnidadesLayout = new javax.swing.GroupLayout(menuUnidades);
        menuUnidades.setLayout(menuUnidadesLayout);
        menuUnidadesLayout.setHorizontalGroup(
            menuUnidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuUnidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuUnidadesLayout.setVerticalGroup(
            menuUnidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuUnidadesLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(menuUnidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlUnidades.add(menuUnidades, java.awt.BorderLayout.PAGE_START);

        tablaUnidades.setPreferredSize(new java.awt.Dimension(1245, 530));

        tblunidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Unidad", "DNI", "ID de Ruta", "Código de SOAT", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblunidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblunidadesMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblunidades);

        UnidadesBotones.setEnabled(false);
        UnidadesBotones.setPreferredSize(new java.awt.Dimension(900, 216));
        UnidadesBotones.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                UnidadesBotonesComponentAdded(evt);
            }
        });
        UnidadesBotones.setLayout(new java.awt.BorderLayout());

        pnlUnidadesForm.setMinimumSize(new java.awt.Dimension(1220, 200));
        pnlUnidadesForm.setPreferredSize(new java.awt.Dimension(1217, 146));
        pnlUnidadesForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlUnidadesForm1.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlUnidadesForm1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setText("Cod de Unidad");
        pnlUnidadesForm1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtCodUnidad.setEnabled(false);
        pnlUnidadesForm1.add(txtCodUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, -1));

        jLabel42.setText("Cod de SOAT");
        pnlUnidadesForm1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, -1));

        txtCodSoat.setEnabled(false);
        txtCodSoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodSoatActionPerformed(evt);
            }
        });
        pnlUnidadesForm1.add(txtCodSoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 190, -1));

        pnlUnidadesForm.add(pnlUnidadesForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 260, 160));

        pnlUnidadesForm2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setText("DNI");
        pnlUnidadesForm2.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtDniunidad.setEnabled(false);
        pnlUnidadesForm2.add(txtDniunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, -1));

        jLabel44.setText("ID de Ruta");
        pnlUnidadesForm2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtIdRutaUnidad.setEnabled(false);
        txtIdRutaUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdRutaUnidadActionPerformed(evt);
            }
        });
        pnlUnidadesForm2.add(txtIdRutaUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, -1));

        pnlUnidadesForm.add(pnlUnidadesForm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 220, 160));

        pnlUnidadesForm3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setText("Estado");
        pnlUnidadesForm3.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 14, 101, -1));

        cbxEstadoUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));
        cbxEstadoUnidad.setEnabled(false);
        pnlUnidadesForm3.add(cbxEstadoUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 36, 186, -1));

        pnlUnidadesForm.add(pnlUnidadesForm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 220, 160));

        btnactaddunidad.setText("Agregar");
        btnactaddunidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactaddunidadActionPerformed(evt);
            }
        });

        btnaddunidad.setText("Agregar");
        btnaddunidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddunidadMouseClicked(evt);
            }
        });
        btnaddunidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddunidadActionPerformed(evt);
            }
        });

        btncanuni.setText("Cancelar");
        btncanuni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncanuniActionPerformed(evt);
            }
        });

        btnactmodiunidad.setText("Modificar");
        btnactmodiunidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactmodiunidadActionPerformed(evt);
            }
        });

        btnmodunidad.setText("Modificar");
        btnmodunidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodunidadActionPerformed(evt);
            }
        });

        btncanuni1.setText("Cancelar");
        btncanuni1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncanuni1ActionPerformed(evt);
            }
        });

        btndeluni.setText("Eliminar");

        btnactdelunidad.setText("Eliminar");
        btnactdelunidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactdelunidadActionPerformed(evt);
            }
        });

        btncanuni2.setText("Cancelar");
        btncanuni2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncanuni2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTarjeraopc2Layout = new javax.swing.GroupLayout(pnlTarjeraopc2);
        pnlTarjeraopc2.setLayout(pnlTarjeraopc2Layout);
        pnlTarjeraopc2Layout.setHorizontalGroup(
            pnlTarjeraopc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTarjeraopc2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlTarjeraopc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTarjeraopc2Layout.createSequentialGroup()
                        .addComponent(btnaddunidad)
                        .addGap(23, 23, 23)
                        .addComponent(btncanuni))
                    .addGroup(pnlTarjeraopc2Layout.createSequentialGroup()
                        .addComponent(btnmodunidad)
                        .addGap(14, 14, 14)
                        .addComponent(btncanuni1))
                    .addGroup(pnlTarjeraopc2Layout.createSequentialGroup()
                        .addComponent(btndeluni)
                        .addGap(22, 22, 22)
                        .addComponent(btncanuni2)))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTarjeraopc2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTarjeraopc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTarjeraopc2Layout.createSequentialGroup()
                        .addComponent(btnactdelunidad)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTarjeraopc2Layout.createSequentialGroup()
                        .addComponent(btnactaddunidad)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTarjeraopc2Layout.createSequentialGroup()
                        .addComponent(btnactmodiunidad)
                        .addGap(71, 71, 71))))
        );
        pnlTarjeraopc2Layout.setVerticalGroup(
            pnlTarjeraopc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTarjeraopc2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnactaddunidad)
                .addGap(4, 4, 4)
                .addGroup(pnlTarjeraopc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnaddunidad)
                    .addComponent(btncanuni))
                .addGap(6, 6, 6)
                .addComponent(btnactmodiunidad)
                .addGap(6, 6, 6)
                .addGroup(pnlTarjeraopc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnmodunidad)
                    .addComponent(btncanuni1))
                .addGap(6, 6, 6)
                .addComponent(btnactdelunidad)
                .addGap(6, 6, 6)
                .addGroup(pnlTarjeraopc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btndeluni)
                    .addComponent(btncanuni2)))
        );

        pnlUnidadesForm.add(pnlTarjeraopc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 220, 180));

        UnidadesBotones.add(pnlUnidadesForm, java.awt.BorderLayout.CENTER);

        txtBuscar8.setMinimumSize(new java.awt.Dimension(650, 30));
        txtBuscar8.setPreferredSize(new java.awt.Dimension(450, 30));
        txtBuscar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesBusqueda8Layout = new javax.swing.GroupLayout(pnlBotonesBusqueda8);
        pnlBotonesBusqueda8.setLayout(pnlBotonesBusqueda8Layout);
        pnlBotonesBusqueda8Layout.setHorizontalGroup(
            pnlBotonesBusqueda8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesBusqueda8Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtBuscar8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(806, Short.MAX_VALUE))
        );
        pnlBotonesBusqueda8Layout.setVerticalGroup(
            pnlBotonesBusqueda8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesBusqueda8Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtBuscar8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        UnidadesBotones.add(pnlBotonesBusqueda8, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout tablaUnidadesLayout = new javax.swing.GroupLayout(tablaUnidades);
        tablaUnidades.setLayout(tablaUnidadesLayout);
        tablaUnidadesLayout.setHorizontalGroup(
            tablaUnidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UnidadesBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablaUnidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );
        tablaUnidadesLayout.setVerticalGroup(
            tablaUnidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablaUnidadesLayout.createSequentialGroup()
                .addComponent(UnidadesBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlUnidades.add(tablaUnidades, java.awt.BorderLayout.CENTER);

        paneles.add(pnlUnidades, "card2");

        pnlReportes.setLayout(new java.awt.BorderLayout());

        menuUnidades1.setAlignmentX(1.0F);
        menuUnidades1.setPreferredSize(new java.awt.Dimension(100, 80));

        btnmenu9.setBackground(new java.awt.Color(30, 30, 30));
        btnmenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icono/menu.png"))); // NOI18N
        btnmenu9.setPreferredSize(new java.awt.Dimension(120, 123));
        btnmenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenu9ActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Reportes");
        jLabel51.setAlignmentX(1.0F);
        jLabel51.setPreferredSize(new java.awt.Dimension(262, 40));

        javax.swing.GroupLayout menuUnidades1Layout = new javax.swing.GroupLayout(menuUnidades1);
        menuUnidades1.setLayout(menuUnidades1Layout);
        menuUnidades1Layout.setHorizontalGroup(
            menuUnidades1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuUnidades1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuUnidades1Layout.setVerticalGroup(
            menuUnidades1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuUnidades1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(menuUnidades1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmenu9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlReportes.add(menuUnidades1, java.awt.BorderLayout.PAGE_START);

        tablaUnidades1.setPreferredSize(new java.awt.Dimension(1245, 530));
        tablaUnidades1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlUnidadesForm5.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlUnidadesForm5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setText("Fecha Inicial:");
        pnlUnidadesForm5.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel55.setText("Rutas");
        pnlUnidadesForm5.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 110, -1));
        pnlUnidadesForm5.add(jdcFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 230, 40));
        pnlUnidadesForm5.add(jdcInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 230, 40));
        pnlUnidadesForm5.add(txtRutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 230, 40));
        pnlUnidadesForm5.add(txtTransportistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 230, 40));

        jLabel57.setText("Fecha Final");
        pnlUnidadesForm5.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, -1));

        jLabel58.setText("Transportistas");
        pnlUnidadesForm5.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 110, -1));

        btnReporte1.setText("GENERAR REPORTE");
        btnReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte1ActionPerformed(evt);
            }
        });
        pnlUnidadesForm5.add(btnReporte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 230, 40));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Reporte Pagos a Transportistas por Rutas");
        pnlUnidadesForm5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 280, 40));

        tablaUnidades1.add(pnlUnidadesForm5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 310, 410));

        pnlUnidadesForm6.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlUnidadesForm6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setText("Fecha Inicial:");
        pnlUnidadesForm6.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel60.setText("Monto Final");
        pnlUnidadesForm6.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 110, -1));
        pnlUnidadesForm6.add(jdcFinalP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 230, 40));
        pnlUnidadesForm6.add(jdcInicialP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 230, 40));
        pnlUnidadesForm6.add(txtMontoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 230, 40));
        pnlUnidadesForm6.add(txtMontoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 230, 40));

        jLabel61.setText("Fecha Final");
        pnlUnidadesForm6.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, -1));

        jLabel62.setText("Monto Inicial");
        pnlUnidadesForm6.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 110, -1));

        btnReporte2.setText("GENERAR REPORTE");
        btnReporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte2ActionPerformed(evt);
            }
        });
        pnlUnidadesForm6.add(btnReporte2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 230, 40));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel63.setText("Reporte Servicios por Pasajeros");
        pnlUnidadesForm6.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 220, 40));

        tablaUnidades1.add(pnlUnidadesForm6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 300, 410));

        pnlUnidadesForm7.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlUnidadesForm7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setText("Fecha Inicial:");
        pnlUnidadesForm7.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        pnlUnidadesForm7.add(jdcFinalF, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 230, 40));
        pnlUnidadesForm7.add(jdcInicialF, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 230, 40));

        jLabel67.setText("Fecha Final");
        pnlUnidadesForm7.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, -1));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel69.setText("Reporte Resumen Servicios por Fechas");
        pnlUnidadesForm7.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 260, 40));

        btnReporte3.setText("GENERAR REPORTE");
        btnReporte3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte3ActionPerformed(evt);
            }
        });
        pnlUnidadesForm7.add(btnReporte3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 230, 40));

        tablaUnidades1.add(pnlUnidadesForm7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 300, 270));

        pnlReportes.add(tablaUnidades1, java.awt.BorderLayout.CENTER);

        paneles.add(pnlReportes, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneles, javax.swing.GroupLayout.PREFERRED_SIZE, 1298, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PersonaBotonesComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_PersonaBotonesComponentAdded

    }//GEN-LAST:event_PersonaBotonesComponentAdded

    private void btnactaddperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactaddperActionPerformed
        txtnombrepersona.setEnabled(true);
        txtdnipersona.setEnabled(true);
        txtnombrepersona.setEnabled(true);
        txtcelusuario.setEnabled(true);
        txtemail.setEnabled(true);
        txtapematpersona.setEnabled(true);
        txtapepatpersona.setEnabled(true);
        cbxestadopersona.setEnabled(true);
        cbxtipousupersona.setEnabled(true);
        txtruc.setEnabled(true);
        btnaddperso.setVisible(true);
        btncancelper.setVisible(true);
        txtnombrepersona.setText("");
        txtdnipersona.setText("");
        txtnombrepersona.setText("");
        txtcelusuario.setText("");
        txtemail.setText("");
        txtapematpersona.setText("");
        txtapepatpersona.setText("");


    }//GEN-LAST:event_btnactaddperActionPerformed

    private void txtBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar1ActionPerformed

    private void btnactdelperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactdelperActionPerformed
        // TODO add your handling code here:
        txtnombrepersona.setEnabled(true);
        txtdnipersona.setEnabled(true);
        txtnombrepersona.setEnabled(true);
        txtcelusuario.setEnabled(true);
        txtemail.setEnabled(true);
        txtapematpersona.setEnabled(true);
        txtapepatpersona.setEnabled(true);
        cbxestadopersona.setEnabled(true);
        cbxtipousupersona.setEnabled(true);
        txtruc.setEnabled(true);
        btndelper.setVisible(true);
        btncancelper2.setVisible(true);

    }//GEN-LAST:event_btnactdelperActionPerformed

    private void btnmenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenu1ActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_btnmenu1ActionPerformed

    private void btnactaddperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnactaddperMouseClicked

    }//GEN-LAST:event_btnactaddperMouseClicked

    private void txtapepatpersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapepatpersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapepatpersonaActionPerformed

    private void btnmenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenu2ActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_btnmenu2ActionPerformed

    private void txtContraUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraUserActionPerformed

    private void txtBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar2ActionPerformed

    private void btnadduserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnadduserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnadduserMouseClicked

    private void btnadduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadduserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnadduserActionPerformed

    private void btnactmoduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactmoduserActionPerformed
        // TODO add your handling code here:
        txtUserUsuario.setEnabled(true);
        txtContraUser.setEnabled(true);
        txtDniUsers.setEnabled(true);
        cbxestadoUser.setEnabled(true);
        btnmoduser.setVisible(true);
        btncancelusu1.setVisible(true);
    }//GEN-LAST:event_btnactmoduserActionPerformed

    private void UsuarioBotonesComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_UsuarioBotonesComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioBotonesComponentAdded

    private void txtIdUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUserActionPerformed

    private void btnmenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenu3ActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_btnmenu3ActionPerformed

    private void txtBuscar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar3ActionPerformed

    private void TarjetaBotonesComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_TarjetaBotonesComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_TarjetaBotonesComponentAdded

    private void btnmenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenu4ActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_btnmenu4ActionPerformed

    private void txtBuscar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar4ActionPerformed

    private void RecargaBotonesComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_RecargaBotonesComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_RecargaBotonesComponentAdded

    private void btnmenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenu5ActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_btnmenu5ActionPerformed

    private void txtCodUnidadconsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodUnidadconsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodUnidadconsuActionPerformed

    private void txtBuscar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar5ActionPerformed

    private void btnRegistrarConsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarConsumoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarConsumoMouseClicked

    private void btnRegistrarConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarConsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarConsumoActionPerformed

    private void btnModificarConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarConsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarConsumoActionPerformed

    private void ConsumoBotonesComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_ConsumoBotonesComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_ConsumoBotonesComponentAdded

    private void btnmenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenu6ActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_btnmenu6ActionPerformed

    private void txtnombrerutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombrerutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombrerutaActionPerformed

    private void txtBuscar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar6ActionPerformed

    private void RutasBotonesComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_RutasBotonesComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_RutasBotonesComponentAdded

    private void btnmenu7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenu7ActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_btnmenu7ActionPerformed

    private void txtnombreempresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreempresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreempresaActionPerformed

    private void txtBuscar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar7ActionPerformed

    private void EmpresasBotonesComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_EmpresasBotonesComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpresasBotonesComponentAdded

    private void btnmenu8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenu8ActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_btnmenu8ActionPerformed

    private void txtCodSoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodSoatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodSoatActionPerformed

    private void txtBuscar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar8ActionPerformed

    private void UnidadesBotonesComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_UnidadesBotonesComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_UnidadesBotonesComponentAdded

    private void btnactmodperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactmodperActionPerformed
        // TODO add your handling code here:
        txtnombrepersona.setEnabled(true);
        txtnombrepersona.setEnabled(true);
        txtcelusuario.setEnabled(true);
        txtemail.setEnabled(true);
        txtapematpersona.setEnabled(true);
        txtapepatpersona.setEnabled(true);
        cbxestadopersona.setEnabled(true);
        cbxtipousupersona.setEnabled(true);
        txtruc.setEnabled(true);
        btnmodper.setVisible(true);
        btncancelper1.setVisible(true);


    }//GEN-LAST:event_btnactmodperActionPerformed

    private void txtUserUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserUsuarioActionPerformed

    private void btnactdeluserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactdeluserActionPerformed
        // TODO add your handling code here:
        txtUserUsuario.setEnabled(true);
        txtContraUser.setEnabled(true);
        txtDniUsers.setEnabled(true);
        cbxestadoUser.setEnabled(true);
        btndeluser.setVisible(true);
        btncancelusu2.setVisible(true);
        txtUserUsuario.setText("");
        txtContraUser.setText("");
        txtDniUsers.setText("");
        txtIdUser.setText("");
    }//GEN-LAST:event_btnactdeluserActionPerformed

    private void btnmoduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmoduserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmoduserActionPerformed

    private void btncancelusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelusuActionPerformed
        // TODO add your handling code here:
        txtUserUsuario.setEnabled(false);
        txtContraUser.setEnabled(false);
        txtDniUsers.setEnabled(false);
        cbxestadoUser.setEnabled(false);
        btnadduser.setVisible(false);
        btncancelusu.setVisible(false);
    }//GEN-LAST:event_btncancelusuActionPerformed

    private void btncancelusu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelusu1ActionPerformed
        // TODO add your handling code here:
        txtUserUsuario.setEnabled(false);
        txtContraUser.setEnabled(false);
        txtDniUsers.setEnabled(false);
        cbxestadoUser.setEnabled(false);
        btnmoduser.setVisible(false);
        btncancelusu1.setVisible(false);
        btnactmoduser.setEnabled(true);
        txtIdUser.setText("");
        txtUserUsuario.setText("");
        txtContraUser.setText("");
        txtDniUsers.setText("");
        btnactadduser.setVisible(true);
        btnactdeluser.setVisible(false);
        btnactmoduser.setVisible(false);
    }//GEN-LAST:event_btncancelusu1ActionPerformed

    private void btnaddtarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddtarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddtarMouseClicked

    private void btnaddtarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddtarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddtarActionPerformed

    private void btncanctarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncanctarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncanctarActionPerformed

    private void btnactmodtarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactmodtarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnactmodtarActionPerformed

    private void btndeltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeltarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndeltarActionPerformed

    private void btncanctar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncanctar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncanctar1ActionPerformed

    private void btnactdelltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactdelltarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnactdelltarActionPerformed

    private void txtdnipersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdnipersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdnipersonaActionPerformed

    private void btnRegrutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegrutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegrutMouseClicked

    private void btnRegrutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegrutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegrutActionPerformed

    private void btnCancelarManRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarManRutActionPerformed
        // TODO add your handling code here:
        txtidrutman.setEnabled(false);
        txtnombreruta.setEnabled(false);
        txtmontoruta.setEnabled(false);
        cbxEstadoRuta.setEnabled(false);
        btnRegrut.setVisible(false);
        btnRegrut.setEnabled(false);
        btnCancelarManRut.setVisible(false);
        btnAddRut.setEnabled(true);
        txtidrutman.setText("");
        txtnombreruta.setText("");
        txtmontoruta.setText("");
        btnModRut.setVisible(false);
        btnAddRut.setVisible(true);
        btnelirut.setVisible(false);

    }//GEN-LAST:event_btnCancelarManRutActionPerformed

    private void btnmodrutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodrutActionPerformed
        // TODO add your handling code here:
        txtidrutman.setEnabled(true);
        txtnombreruta.setEnabled(true);
        txtmontoruta.setEnabled(true);
        cbxEstadoRuta.setEnabled(true);
        btnModRut.setVisible(true);
        btnModRut.setEnabled(true);
        btnCancelarManRut1.setVisible(true);

    }//GEN-LAST:event_btnmodrutActionPerformed

    private void btnModRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModRutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModRutActionPerformed

    private void btnCancelarManRut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarManRut1ActionPerformed
        // TODO add your handling code here:
        txtidrutman.setEnabled(false);
        txtnombreruta.setEnabled(false);
        txtmontoruta.setEnabled(false);
        cbxEstadoRuta.setEnabled(false);
        btnModRut.setVisible(false);
        btnModRut.setEnabled(false);
        btnCancelarManRut1.setVisible(false);
        btnmodrut.setVisible(false);
        btnAddRut.setVisible(true);
        btnelirut.setVisible(false);
        txtidrutman.setText("");
        txtnombreruta.setText("");
        txtmontoruta.setText("");
    }//GEN-LAST:event_btnCancelarManRut1ActionPerformed

    private void btnelirutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelirutActionPerformed
        // TODO add your handling code here:
        txtidrutman.setEnabled(true);
        txtnombreruta.setEnabled(true);
        txtmontoruta.setEnabled(true);
        cbxEstadoRuta.setEnabled(true);
        btndelrut.setVisible(true);
        btnCancelarManRut2.setVisible(true);
    }//GEN-LAST:event_btnelirutActionPerformed

    private void btnaddempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddempMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddempMouseClicked

    private void btnaddempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddempActionPerformed

    private void btncantransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncantransActionPerformed
        // TODO add your handling code here:
        txtnombreempresa.setEnabled(false);
        txtrucempresa.setEnabled(false);
        txtcolorempresa.setEnabled(false);
        cbxEstadoTranporte.setEnabled(false);
        btnaddemp.setVisible(false);
        btncantrans.setVisible(false);

        // Resto del código
        txtnombreempresa.setText("");
        txtrucempresa.setText("");
        txtcolorempresa.setText("");

    }//GEN-LAST:event_btncantransActionPerformed

    private void btnactmodempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactmodempActionPerformed
        // TODO add your handling code here:

        txtnombreempresa.setEnabled(true);
        txtrucempresa.setEnabled(true);
        txtcolorempresa.setEnabled(true);
        cbxEstadoTranporte.setEnabled(true);
        btnmodemp.setVisible(true);
        btncantrans1.setVisible(true);

    }//GEN-LAST:event_btnactmodempActionPerformed

    private void btnmodempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmodempActionPerformed

    private void btncantrans1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncantrans1ActionPerformed
        // TODO add your handling code here:
        txtnombreempresa.setEnabled(false);
        txtrucempresa.setEnabled(false);
        txtcolorempresa.setEnabled(false);
        cbxEstadoTranporte.setEnabled(false);
        btnmodemp.setVisible(false);
        btncantrans1.setVisible(false);

        // Resto del código
        txtnombreempresa.setText("");
        txtrucempresa.setText("");
        txtcolorempresa.setText("");
        btnactdelemp.setVisible(false);
        btnactmodemp.setVisible(false);
        btnactaddemp.setVisible(true);
    }//GEN-LAST:event_btncantrans1ActionPerformed

    private void btnactdelempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactdelempActionPerformed

        // TODO add your handling code here:
        txtnombreempresa.setEnabled(true);
        txtrucempresa.setEnabled(true);
        txtcolorempresa.setEnabled(true);
        cbxEstadoTranporte.setEnabled(true);
        btndelemp.setVisible(true);
        btncantrans2.setVisible(true);

        btnactdelunidad.setEnabled(false);
    }//GEN-LAST:event_btnactdelempActionPerformed

    private void tblEmpresastransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpresastransMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();
            txtrucempresa.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            txtnombreempresa.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            txtcolorempresa.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            cbxEstadoTranporte.setSelectedItem(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3));

            btnactdelemp.setVisible(true);
            btnactmodemp.setVisible(true);
            btnactaddemp.setVisible(false);
        }
    }//GEN-LAST:event_tblEmpresastransMouseClicked

    private void txtIdRutaUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdRutaUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdRutaUnidadActionPerformed

    private void tblrutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblrutasMouseClicked
        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();
            txtidrutman.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            txtnombreruta.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            txtmontoruta.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            cbxEstadoRuta.setSelectedItem(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3));
            btnmodrut.setVisible(true);
            btnelirut.setVisible(true);
            btnAddRut.setVisible(false);
        }
    }//GEN-LAST:event_tblrutasMouseClicked

    private void btnAddRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRutActionPerformed
        txtidrutman.setEnabled(true);
        txtnombreruta.setEnabled(true);
        txtmontoruta.setEnabled(true);
        cbxEstadoRuta.setEnabled(true);
        btnRegrut.setVisible(true);
        btnRegrut.setEnabled(true);
        btnCancelarManRut.setVisible(true);
        txtidrutman.setText("");
        txtnombreruta.setText("");
        txtmontoruta.setText("");
    }//GEN-LAST:event_btnAddRutActionPerformed

    private void btnCancelarManRut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarManRut2ActionPerformed
        // TODO add your handling code here:
        txtidrutman.setText("");
        txtnombreruta.setText("");
        txtmontoruta.setText("");
        txtidrutman.setEnabled(false);
        txtnombreruta.setEnabled(false);
        txtmontoruta.setEnabled(false);
        cbxEstadoRuta.setEnabled(false);
        btndelrut.setVisible(false);
        btnCancelarManRut2.setVisible(false);
        btnelirut.setEnabled(true);
        btnmodrut.setVisible(false);
        btnAddRut.setVisible(true);
        btnelirut.setVisible(false);
    }//GEN-LAST:event_btnCancelarManRut2ActionPerformed

    private void btnactaddempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactaddempActionPerformed
        // TODO add your handling code here:
        txtnombreempresa.setEnabled(true);
        txtrucempresa.setEnabled(true);
        txtcolorempresa.setEnabled(true);
        cbxEstadoTranporte.setEnabled(true);
        btnaddemp.setVisible(true);
        btncantrans.setVisible(true);
        txtnombreempresa.setText("");
        txtrucempresa.setText("");
        txtcolorempresa.setText("");
    }//GEN-LAST:event_btnactaddempActionPerformed

    private void btncantrans2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncantrans2ActionPerformed
        // TODO add your handling code here:
        txtnombreempresa.setEnabled(false);
        txtrucempresa.setEnabled(false);
        txtcolorempresa.setEnabled(false);
        cbxEstadoTranporte.setEnabled(false);
        btndelemp.setVisible(false);
        btncantrans2.setVisible(false);
        btnactdelemp.setVisible(false);
        btnactmodemp.setVisible(false);
        btnactaddemp.setVisible(true);

        // Resto del código
        txtnombreempresa.setText("");
        txtrucempresa.setText("");
        txtcolorempresa.setText("");
    }//GEN-LAST:event_btncantrans2ActionPerformed

    private void tblunidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblunidadesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();
            // Asegúrate de tener los nombres de los elementos correctos para la clase Unidad
            txtCodUnidad.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            txtDniunidad.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            txtIdRutaUnidad.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            txtCodSoat.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
            cbxEstadoUnidad.setSelectedItem(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4));
            btnactmodiunidad.setVisible(true);
            btnactdelunidad.setVisible(true);
            btnactaddunidad.setVisible(false);

        }
    }//GEN-LAST:event_tblunidadesMouseClicked

    private void btnactdelunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactdelunidadActionPerformed

        // TODO add your handling code here:
        txtCodUnidad.setEnabled(true);
        txtDniunidad.setEnabled(true);
        txtIdRutaUnidad.setEnabled(true);
        txtCodSoat.setEnabled(true);
        cbxEstadoUnidad.setEnabled(true);
        btndeluni.setVisible(true);
        btncanuni2.setVisible(true);


    }//GEN-LAST:event_btnactdelunidadActionPerformed

    private void btncanuni1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncanuni1ActionPerformed
        // TODO add your handling code here:
        txtCodUnidad.setEnabled(false);
        txtDniunidad.setEnabled(false);
        txtIdRutaUnidad.setEnabled(false);
        txtCodSoat.setEnabled(false);
        cbxEstadoUnidad.setEnabled(false);
        btnmodunidad.setVisible(false);
        btncanuni1.setVisible(false);
        txtCodUnidad.setText("");
        txtDniunidad.setText("");
        txtIdRutaUnidad.setText("");
        txtCodSoat.setText("");

        btnactmodiunidad.setVisible(false);
        btnactdelunidad.setVisible(false);
        btnactaddunidad.setVisible(true);
    }//GEN-LAST:event_btncanuni1ActionPerformed

    private void btnmodunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodunidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmodunidadActionPerformed

    private void btnactmodiunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactmodiunidadActionPerformed
        // TODO add your handling code here:
        txtCodUnidad.setEnabled(true);
        txtDniunidad.setEnabled(true);
        txtIdRutaUnidad.setEnabled(true);
        txtCodSoat.setEnabled(true);
        cbxEstadoUnidad.setEnabled(true);
        btnmodunidad.setVisible(true);
        btncanuni1.setVisible(true);

    }//GEN-LAST:event_btnactmodiunidadActionPerformed

    private void btncanuniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncanuniActionPerformed
        // TODO add your handling code here:
        txtCodUnidad.setEnabled(false);
        txtDniunidad.setEnabled(false);
        txtIdRutaUnidad.setEnabled(false);
        txtCodSoat.setEnabled(false);
        cbxEstadoUnidad.setEnabled(false);
        btnaddunidad.setVisible(false);
        btncanuni.setVisible(false);
        txtCodUnidad.setText("");
        txtDniunidad.setText("");
        txtIdRutaUnidad.setText("");
        txtCodSoat.setText("");

    }//GEN-LAST:event_btncanuniActionPerformed

    private void btnaddunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddunidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddunidadActionPerformed

    private void btnaddunidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddunidadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddunidadMouseClicked

    private void btnactaddunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactaddunidadActionPerformed
        txtCodUnidad.setEnabled(true);
        txtDniunidad.setEnabled(true);
        txtIdRutaUnidad.setEnabled(true);
        txtCodSoat.setEnabled(true);
        cbxEstadoUnidad.setEnabled(true);
        btnaddunidad.setVisible(true);
        btncanuni.setVisible(true);
        txtCodUnidad.setText("");
        txtDniunidad.setText("");
        txtIdRutaUnidad.setText("");
        txtCodSoat.setText("");

    }//GEN-LAST:event_btnactaddunidadActionPerformed

    private void btncanuni2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncanuni2ActionPerformed
        // TODO add your handling code here:
        txtCodUnidad.setEnabled(false);
        txtDniunidad.setEnabled(false);
        txtIdRutaUnidad.setEnabled(false);
        txtCodSoat.setEnabled(false);
        cbxEstadoUnidad.setEnabled(false);
        btncanuni2.setVisible(false);
        btndeluni.setVisible(false);
        txtCodUnidad.setText("");
        txtDniunidad.setText("");
        txtIdRutaUnidad.setText("");
        txtCodSoat.setText("");
        btnactmodiunidad.setVisible(false);
        btnactdelunidad.setVisible(false);
        btnactaddunidad.setVisible(true);

    }//GEN-LAST:event_btncanuni2ActionPerformed

    private void btncancelper1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelper1ActionPerformed
        // TODO add your handling code here:
        txtnombrepersona.setEnabled(false);
        txtdnipersona.setEnabled(false);
        txtnombrepersona.setEnabled(false);
        txtcelusuario.setEnabled(false);
        txtemail.setEnabled(false);
        txtapematpersona.setEnabled(false);
        txtapepatpersona.setEnabled(false);
        cbxestadopersona.setEnabled(false);
        cbxtipousupersona.setEnabled(false);
        txtruc.setEnabled(false);
        btnmodper.setVisible(false);
        btncancelper1.setVisible(false);
        txtnombrepersona.setText("");
        txtdnipersona.setText("");
        txtnombrepersona.setText("");
        txtcelusuario.setText("");
        txtemail.setText("");
        txtapematpersona.setText("");
        txtapepatpersona.setText("");
        btnactaddper.setVisible(true);
        btnactmodper.setVisible(false);
        btnactdelper.setVisible(false);
    }//GEN-LAST:event_btncancelper1ActionPerformed

    private void btncancelperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelperActionPerformed
        // TODO add your handling code here:
        txtnombrepersona.setEnabled(false);
        txtdnipersona.setEnabled(false);
        txtnombrepersona.setEnabled(false);
        txtcelusuario.setEnabled(false);
        txtemail.setEnabled(false);
        txtapematpersona.setEnabled(false);
        txtapepatpersona.setEnabled(false);
        cbxestadopersona.setEnabled(false);
        cbxtipousupersona.setEnabled(false);
        txtruc.setEnabled(false);
        btnaddperso.setVisible(false);
        btncancelper.setVisible(false);
        txtnombrepersona.setText("");
        txtdnipersona.setText("");
        txtnombrepersona.setText("");
        txtcelusuario.setText("");
        txtemail.setText("");
        txtapematpersona.setText("");
        txtapepatpersona.setText("");
        btnactaddper.setEnabled(true);

    }//GEN-LAST:event_btncancelperActionPerformed

    private void btncancelper2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelper2ActionPerformed
        // TODO add your handling code here:
        txtnombrepersona.setEnabled(false);
        txtdnipersona.setEnabled(false);
        txtnombrepersona.setEnabled(false);
        txtcelusuario.setEnabled(false);
        txtemail.setEnabled(false);
        txtapematpersona.setEnabled(false);
        txtapepatpersona.setEnabled(false);
        cbxestadopersona.setEnabled(false);
        cbxtipousupersona.setEnabled(false);
        txtruc.setEnabled(false);
        btndelper.setVisible(false);
        btncancelper2.setVisible(false);
        txtnombrepersona.setText("");
        txtdnipersona.setText("");
        txtnombrepersona.setText("");
        txtcelusuario.setText("");
        txtemail.setText("");
        txtapematpersona.setText("");
        txtapepatpersona.setText("");
        btnactdelper.setEnabled(true);
        btnactaddper.setVisible(true);
        btnactmodper.setVisible(false);
        btnactdelper.setVisible(false);
    }//GEN-LAST:event_btncancelper2ActionPerformed

    private void tblpersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpersonasMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();
            txtdnipersona.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            txtnombrepersona.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            txtapepatpersona.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            txtapematpersona.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
            txtcelusuario.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString());
            txtemail.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5).toString());
            btnactaddper.setVisible(false);
            btnactmodper.setVisible(true);
            btnactdelper.setVisible(true);

            Object value = receptor.getModel().getValueAt(receptor.getSelectedRow(), 7);
            if (value == null) {
                txtruc.setText("");
            } else {
                txtruc.setText(value.toString());
            }
        }

    }//GEN-LAST:event_tblpersonasMouseClicked

    private void btnactadduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactadduserActionPerformed
        // TODO add your handling code here:
        txtUserUsuario.setEnabled(true);
        txtContraUser.setEnabled(true);
        txtDniUsers.setEnabled(true);
        cbxestadoUser.setEnabled(true);
        btnadduser.setVisible(true);
        btncancelusu.setVisible(true);
        txtUserUsuario.setText("");
        txtContraUser.setText("");
        txtDniUsers.setText("");
        txtIdUser.setText("");

    }//GEN-LAST:event_btnactadduserActionPerformed

    private void btncancelusu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelusu2ActionPerformed
        // TODO add your handling code here:
        txtUserUsuario.setEnabled(false);
        txtContraUser.setEnabled(false);
        txtDniUsers.setEnabled(false);
        cbxestadoUser.setEnabled(false);
        btndeluser.setVisible(false);
        btncancelusu2.setVisible(false);
        txtIdUser.setText("");
        txtUserUsuario.setText("");
        txtContraUser.setText("");
        txtDniUsers.setText("");
        btnactadduser.setVisible(true);
        btnactdeluser.setVisible(false);
        btnactmoduser.setVisible(false);
    }//GEN-LAST:event_btncancelusu2ActionPerformed

    private void tblusuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblusuariosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();
            txtIdUser.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            txtDniUsers.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            txtUserUsuario.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            txtContraUser.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
            cbxestadoUser.setSelectedItem(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4));
            btnactadduser.setVisible(false);
            btnactdeluser.setVisible(true);
            btnactmoduser.setVisible(true);
        }
    }//GEN-LAST:event_tblusuariosMouseClicked

    private void btnactaddtarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactaddtarActionPerformed
        // TODO add your handling code here:
        listarTarjetas();
    }//GEN-LAST:event_btnactaddtarActionPerformed

    private void btnEliminarConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarConsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarConsumoActionPerformed

    private void txtmontorecargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontorecargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontorecargaActionPerformed

    private void btnRegistrarRecargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarRecargaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarRecargaMouseClicked

    private void btnRegistrarRecargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarRecargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarRecargaActionPerformed

    private void btnModificarRecargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarRecargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarRecargaActionPerformed

    private void btnmenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenu9ActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_btnmenu9ActionPerformed

    private void btnReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte1ActionPerformed
        try {

            Conexion con = new Conexion();
            Connection conn = con.crearConexion();
            System.out.println("CONEXION");
            // Compilar el archivo .jasper
            JasperReport jasperReport = JasperCompileManager.compileReport("src\\Reportes\\ReportePT.jrxml");

            System.out.println("PASO LA COMPILACION");
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Date inicial = jdcInicial.getDate();
            Date finall = jdcFinal.getDate();
            LocalDate timedate1 = LocalDate.ofInstant(inicial.toInstant(), ZoneId.systemDefault());
            LocalDate timedate2 = LocalDate.ofInstant(finall.toInstant(), ZoneId.systemDefault());
            String f_inicialFormato = timedate1.format(formatter);
            String f_finalFormato = timedate2.format(formatter);
            System.out.println(f_inicialFormato);
            System.out.println(f_finalFormato);
            
            Map parametros = new HashMap();
            parametros.put("f_inicial", f_inicialFormato);
            parametros.put("f_final", f_finalFormato);
            parametros.put("p_trans", txtTransportistas.getText());
            parametros.put("p_rutas", txtRutas.getText());
            
            //System.out.println(jdcInicial.getDate());
            //System.out.println(jdcFinal.getDate());
            
            // Paso 3: Llenar el informe con datos desde la base de datos.
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conn);
            System.out.println("PASO LA LECTURA");
            // Paso 4: Mostrar el informe (puedes exportarlo a diferentes formatos también).
            JasperViewer.viewReport(jasperPrint);
            System.out.println("PASO LA PARTE DE VIEW");
            // O exportarlo a PDF
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Reporte PDF");
            fileChooser.setSelectedFile(new File("Reporte-Transportistas.pdf"));

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try {
                    JasperExportManager.exportReportToPdfFile(jasperPrint, fileToSave.getAbsolutePath());
                    System.out.println("Exportación exitosa a PDF");
                } catch (JRException e) {
                    e.printStackTrace();
                    System.err.println("Error al exportar a PDF: " + e.getMessage());
                }
            }
            //return jasperPrint;
        } catch (JRException err) {
            err.printStackTrace();
            System.out.println("INGRESO AL CATCH ERROR");
            System.out.println("ERROR.... " + err);
            //return null;
        }
    }//GEN-LAST:event_btnReporte1ActionPerformed

    private void btnReporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte2ActionPerformed
        try {

            Conexion con = new Conexion();
            Connection conn = con.crearConexion();

            // Compilar el archivo .jasper
            JasperReport jasperReport = JasperCompileManager.compileReport("src\\Reportes\\ReporteSP.jrxml");
            //JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\LuisDev\\Downloads\\FinalIntegrador\\FinalIntegrador\\Formatos\\src\\Reportes\\ReporteSP.jrxml");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Date inicial = jdcInicialP.getDate();
            Date finall = jdcFinalP.getDate();
            LocalDate timedate1 = LocalDate.ofInstant(inicial.toInstant(), ZoneId.systemDefault());
            LocalDate timedate2 = LocalDate.ofInstant(finall.toInstant(), ZoneId.systemDefault());
            String f_inicialFormato = timedate1.format(formatter);
            String f_finalFormato = timedate2.format(formatter);
            System.out.println(f_inicialFormato);
            System.out.println(f_finalFormato);
            
            Map parametros = new HashMap();
            parametros.put("f_inicialS", f_inicialFormato);
            parametros.put("f_finalS", f_finalFormato);
            parametros.put("m_inicial", txtMontoInicial.getText());
            parametros.put("m_final", txtMontoFinal.getText());            

            // Paso 3: Llenar el informe con datos desde la base de datos.
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conn);

            // Paso 4: Mostrar el informe (puedes exportarlo a diferentes formatos también).
            JasperViewer.viewReport(jasperPrint);
        
            // O exportarlo a PDF
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Reporte PDF");
            fileChooser.setSelectedFile(new File("Reporte-Pasajeros.pdf"));

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try {
                    JasperExportManager.exportReportToPdfFile(jasperPrint, fileToSave.getAbsolutePath());
                    System.out.println("Exportación exitosa a PDF");
                } catch (JRException e) {
                    e.printStackTrace();
                    System.err.println("Error al exportar a PDF: " + e.getMessage());
                }
            }

            //return jasperPrint;
        } catch (JRException err) {
            err.printStackTrace();
            System.out.println("INGRESO AL CATCH ERROR");
            System.out.println("ERROR.... " + err);
            //return null;
        }
    }//GEN-LAST:event_btnReporte2ActionPerformed

    private void btnReporte3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte3ActionPerformed
        try {

            Conexion con = new Conexion();
            Connection conn = con.crearConexion();

            // Compilar el archivo .jasper
            JasperReport jasperReport = JasperCompileManager.compileReport("src\\Reportes\\ReporteSF.jrxml");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Date inicial = jdcInicialF.getDate();
            Date finall = jdcFinalF.getDate();
            LocalDate timedate1 = LocalDate.ofInstant(inicial.toInstant(), ZoneId.systemDefault());
            LocalDate timedate2 = LocalDate.ofInstant(finall.toInstant(), ZoneId.systemDefault());
            String f_inicialFormato = timedate1.format(formatter);
            String f_finalFormato = timedate2.format(formatter);
            System.out.println(f_inicialFormato);
            System.out.println(f_finalFormato);
            
            Map parametros = new HashMap();
            parametros.put("f_inicialF", f_inicialFormato);
            parametros.put("f_finalF", f_finalFormato);
            
            // Paso 3: Llenar el informe con datos desde la base de datos.
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conn);

            // Paso 4: Mostrar el informe (puedes exportarlo a diferentes formatos también).
            JasperViewer.viewReport(jasperPrint);

            // O exportarlo a PDF
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Reporte PDF");
            fileChooser.setSelectedFile(new File("Reporte-Servicios.pdf"));

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try {
                    JasperExportManager.exportReportToPdfFile(jasperPrint, fileToSave.getAbsolutePath());
                    System.out.println("Exportación exitosa a PDF");
                } catch (JRException e) {
                    e.printStackTrace();
                    System.err.println("Error al exportar a PDF: " + e.getMessage());
                }
            }

            //return jasperPrint;
        } catch (JRException err) {
            err.printStackTrace();
            System.out.println("INGRESO AL CATCH ERROR");
            System.out.println("ERROR.... " + err);
            //return null;
        }
    }//GEN-LAST:event_btnReporte3ActionPerformed

    private void btnVerTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTicketActionPerformed
        try {

            Conexion con = new Conexion();
            Connection conn = con.crearConexion();

            // Compilar el archivo .jasper
            JasperReport jasperReport = JasperCompileManager.compileReport("src\\Reportes\\TicketRecarga.jrxml");

            // Paso 3: Llenar el informe con datos desde la base de datos.
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);

            // Paso 4: Mostrar el informe (puedes exportarlo a diferentes formatos también).
            JasperViewer.viewReport(jasperPrint);

            // O exportarlo a PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "src\\Reportes\\TicketRecarga.pdf");

            //return jasperPrint;
        } catch (JRException err) {
            err.printStackTrace();
            System.out.println("INGRESO AL CATCH ERROR");
            System.out.println("ERROR.... " + err);
            //return null;
        }
    }//GEN-LAST:event_btnVerTicketActionPerformed

    public static void enviarCorreo(String destinatario, String asunto, String cuerpo, String rutaArchivo) {

        // Configuración para el servidor SMTP de Outlook
        String host = "smtp.office365.com";
        String port = "587";
        String username = "luchitozabalaga@outlook.es";
        String password = "Jorgezabalag@90";
        System.out.println(destinatario);
        // Propiedades para la sesión
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Crear una sesión con autenticación
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Crear un mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);

            // Crear el cuerpo del mensaje
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(cuerpo);

            // Crear la parte adjunta para el archivo PDF
            MimeBodyPart attachmentPart = new MimeBodyPart();
            String filePath = rutaArchivo; // Reemplazar con la ruta del archivo PDF
            DataSource source = new FileDataSource(filePath);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName("TicketRecarga.pdf");

            // Combinar las partes del mensaje
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            // Establecer el contenido del mensaje como la combinación de partes
            message.setContent(multipart);

            // Enviar el mensaje
            Transport.send(message);

            JOptionPane.showMessageDialog(null, "Email enviado correctamente!!!");

            System.out.println("Correo enviado correctamente.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        /*enviarCorreo(
            "luchitozabalaga@outlook.es",
            "Ticket de Recarga - EtravelEase",
            "En el archivo pdf encontrara información de la recarga realizada en nuestro sistema EtravelEase",
            "C:\\Users\\LuisDev\\Documents\\TicketRecarga.pdf"
        );*/
        enviarCorreo(
                txtEmailDestino.getText(),
                "Ticket de Recarga - EtravelEase",
                "En el archivo pdf encontrara información de la recarga realizada en nuestro sistema EtravelEase",
                "src\\Reportes\\TicketRecarga.pdf"
        );

    }//GEN-LAST:event_btnEnviarActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnaddpersoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddpersoActionPerformed

    }//GEN-LAST:event_btnaddpersoActionPerformed

    private void txtnombrepersonaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombrepersonaKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        boolean isUpperCase = key >= 65 && key <= 90;
        boolean isLowerCase = key >= 97 && key <= 122;

        if (!(isUpperCase || isLowerCase)) {
            evt.consume(); // Consumir el evento para evitar que se procese
        }
    }//GEN-LAST:event_txtnombrepersonaKeyTyped

    private void txtapepatpersonaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapepatpersonaKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        boolean isUpperCase = key >= 65 && key <= 90;
        boolean isLowerCase = key >= 97 && key <= 122;

        if (!(isUpperCase || isLowerCase)) {
            evt.consume(); // Consumir el evento para evitar que se procese
        }
    }//GEN-LAST:event_txtapepatpersonaKeyTyped

    private void txtapematpersonaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapematpersonaKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        boolean isUpperCase = key >= 65 && key <= 90;
        boolean isLowerCase = key >= 97 && key <= 122;

        if (!(isUpperCase || isLowerCase)) {
            evt.consume(); // Consumir el evento para evitar que se procese
        }
    }//GEN-LAST:event_txtapematpersonaKeyTyped

    private void txtdnipersonaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdnipersonaKeyTyped
        // COD numeros
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;

        if (!(numeros)) {
            evt.consume(); // Consumir el evento para evitar que se procese
        }
        if (txtdnipersona.getText().length() >= 8) {
            evt.consume(); // Consumir el evento para evitar que se procese

        }
    }//GEN-LAST:event_txtdnipersonaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Color color = Color.decode("#5856D6");
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("Temas");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        UIManager.put("Button.background", color);
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vistaadministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Clases.CrazyPanel ConsumoBotones;
    public Clases.CrazyPanel EmpresasBotones;
    public Clases.CrazyPanel PersonaBotones;
    public Clases.CrazyPanel RecargaBotones;
    public Clases.CrazyPanel RutasBotones;
    public Clases.CrazyPanel TarjetaBotones;
    public Clases.CrazyPanel UnidadesBotones;
    public Clases.CrazyPanel UsuarioBotones;
    private javax.swing.JButton btnAddRut;
    private javax.swing.JButton btnCancelarManRut;
    private javax.swing.JButton btnCancelarManRut1;
    private javax.swing.JButton btnCancelarManRut2;
    public javax.swing.JButton btnEliminarConsumo;
    public javax.swing.JButton btnEliminarRecarga;
    private javax.swing.JButton btnEnviar;
    public javax.swing.JButton btnModRut;
    public javax.swing.JButton btnModificarConsumo;
    public javax.swing.JButton btnModificarRecarga;
    public javax.swing.JButton btnRegistrarConsumo;
    public javax.swing.JButton btnRegistrarRecarga;
    public javax.swing.JButton btnRegrut;
    private javax.swing.JButton btnReporte1;
    private javax.swing.JButton btnReporte2;
    private javax.swing.JButton btnReporte3;
    private javax.swing.JButton btnVerTicket;
    private javax.swing.JButton btnactaddemp;
    private javax.swing.JButton btnactaddper;
    private javax.swing.JButton btnactaddtar;
    private javax.swing.JButton btnactaddunidad;
    private javax.swing.JButton btnactadduser;
    private javax.swing.JButton btnactdelemp;
    private javax.swing.JButton btnactdelltar;
    private javax.swing.JButton btnactdelper;
    private javax.swing.JButton btnactdelunidad;
    private javax.swing.JButton btnactdeluser;
    private javax.swing.JButton btnactmodemp;
    private javax.swing.JButton btnactmodiunidad;
    private javax.swing.JButton btnactmodper;
    private javax.swing.JButton btnactmodtar;
    private javax.swing.JButton btnactmoduser;
    public javax.swing.JButton btnaddemp;
    public javax.swing.JButton btnaddperso;
    public javax.swing.JButton btnaddtar;
    public javax.swing.JButton btnaddunidad;
    public javax.swing.JButton btnadduser;
    private javax.swing.JButton btncancelper;
    private javax.swing.JButton btncancelper1;
    private javax.swing.JButton btncancelper2;
    private javax.swing.JButton btncancelusu;
    private javax.swing.JButton btncancelusu1;
    private javax.swing.JButton btncancelusu2;
    private javax.swing.JButton btncanctar;
    private javax.swing.JButton btncanctar1;
    private javax.swing.JButton btncanctar2;
    private javax.swing.JButton btncantrans;
    private javax.swing.JButton btncantrans1;
    private javax.swing.JButton btncantrans2;
    private javax.swing.JButton btncanuni;
    private javax.swing.JButton btncanuni1;
    private javax.swing.JButton btncanuni2;
    public javax.swing.JButton btndelemp;
    public javax.swing.JButton btndelper;
    public javax.swing.JButton btndelrut;
    public javax.swing.JButton btndeltar;
    public javax.swing.JButton btndeluni;
    public javax.swing.JButton btndeluser;
    private javax.swing.JButton btnelirut;
    private javax.swing.JButton btnmenu1;
    private javax.swing.JButton btnmenu2;
    private javax.swing.JButton btnmenu3;
    private javax.swing.JButton btnmenu4;
    private javax.swing.JButton btnmenu5;
    private javax.swing.JButton btnmenu6;
    private javax.swing.JButton btnmenu7;
    private javax.swing.JButton btnmenu8;
    private javax.swing.JButton btnmenu9;
    public javax.swing.JButton btnmodemp;
    public javax.swing.JButton btnmodper;
    private javax.swing.JButton btnmodrut;
    public javax.swing.JButton btnmodtar;
    public javax.swing.JButton btnmodunidad;
    public javax.swing.JButton btnmoduser;
    public javax.swing.JComboBox<String> cbxEstadoRuta;
    public javax.swing.JComboBox<String> cbxEstadoTranporte;
    public javax.swing.JComboBox<String> cbxEstadoUnidad;
    public javax.swing.JComboBox<String> cbxEstadotarjeta;
    public javax.swing.JComboBox<String> cbxestadoConsumo;
    public javax.swing.JComboBox<String> cbxestadoConsumo1;
    public javax.swing.JComboBox<String> cbxestadoConsumo3;
    public javax.swing.JComboBox<String> cbxestadoRecarga;
    public javax.swing.JComboBox<String> cbxestadoUser;
    public javax.swing.JComboBox<String> cbxestadopersona;
    public javax.swing.JComboBox<String> cbxtarjetasrecarga;
    public javax.swing.JComboBox<String> cbxtipousupersona;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private com.toedter.calendar.JDateChooser jdcFinal;
    private com.toedter.calendar.JDateChooser jdcFinalF;
    private com.toedter.calendar.JDateChooser jdcFinalP;
    private com.toedter.calendar.JDateChooser jdcInicial;
    private com.toedter.calendar.JDateChooser jdcInicialF;
    private com.toedter.calendar.JDateChooser jdcInicialP;
    public javax.swing.JFormattedTextField jdcfechacaducTarjeta;
    public javax.swing.JFormattedTextField jdcfechacreacionTarjeta;
    private Clases.CrazyPanel menuConsumos;
    private Clases.CrazyPanel menuEmpresas;
    private Clases.CrazyPanel menuPersonas;
    private Clases.CrazyPanel menuRecargas;
    private Clases.CrazyPanel menuRutas;
    private Clases.CrazyPanel menuTarjetas;
    private Clases.CrazyPanel menuUnidades;
    private Clases.CrazyPanel menuUnidades1;
    private Clases.CrazyPanel menuUsuarios;
    public raven.crazypanel.CrazyPanel paneles;
    private Clases.CrazyPanel pnlBotonesBusqueda1;
    private Clases.CrazyPanel pnlBotonesBusqueda2;
    private Clases.CrazyPanel pnlBotonesBusqueda3;
    private Clases.CrazyPanel pnlBotonesBusqueda4;
    private Clases.CrazyPanel pnlBotonesBusqueda5;
    private Clases.CrazyPanel pnlBotonesBusqueda6;
    private Clases.CrazyPanel pnlBotonesBusqueda7;
    private Clases.CrazyPanel pnlBotonesBusqueda8;
    public raven.crazypanel.CrazyPanel pnlConsumos;
    private Clases.CrazyPanel pnlConsumosForm;
    private Clases.CrazyPanel pnlConsumosForm1;
    private javax.swing.JPanel pnlConsumosForm2;
    private javax.swing.JPanel pnlConsumosForm3;
    private javax.swing.JPanel pnlConsumosForm4;
    private javax.swing.JPanel pnlConsumosForm5;
    public raven.crazypanel.CrazyPanel pnlEmpresas;
    private Clases.CrazyPanel pnlEmpresasForm;
    private Clases.CrazyPanel pnlEmpresasForm1;
    private Clases.CrazyPanel pnlEmpresasForm2;
    private Clases.CrazyPanel pnlPersonaForm;
    private Clases.CrazyPanel pnlPersonaForm1;
    private Clases.CrazyPanel pnlPersonaForm2;
    private javax.swing.JPanel pnlPersonaForm3;
    private Clases.CrazyPanel pnlPersonaForm4;
    private Clases.CrazyPanel pnlPersonaForm6;
    private Clases.CrazyPanel pnlPersonaForm7;
    public raven.crazypanel.CrazyPanel pnlPersonas;
    public raven.crazypanel.CrazyPanel pnlRecargas;
    private Clases.CrazyPanel pnlRecargasForm;
    private Clases.CrazyPanel pnlRecargasForm1;
    private Clases.CrazyPanel pnlRecargasForm2;
    public raven.crazypanel.CrazyPanel pnlReportes;
    public raven.crazypanel.CrazyPanel pnlRutas;
    private Clases.CrazyPanel pnlRutasForm;
    private javax.swing.JPanel pnlTarjeraopc;
    private javax.swing.JPanel pnlTarjeraopc1;
    private javax.swing.JPanel pnlTarjeraopc2;
    private javax.swing.JPanel pnlTarjeraopc3;
    private javax.swing.JPanel pnlTarjeraopc4;
    private Clases.CrazyPanel pnlTarjetaForm;
    private Clases.CrazyPanel pnlTarjetaForm1;
    private Clases.CrazyPanel pnlTarjetaForm2;
    private Clases.CrazyPanel pnlTarjetaForm3;
    public raven.crazypanel.CrazyPanel pnlTarjetas;
    public raven.crazypanel.CrazyPanel pnlUnidades;
    private Clases.CrazyPanel pnlUnidadesForm;
    private Clases.CrazyPanel pnlUnidadesForm1;
    private Clases.CrazyPanel pnlUnidadesForm2;
    private javax.swing.JPanel pnlUnidadesForm3;
    private Clases.CrazyPanel pnlUnidadesForm5;
    private Clases.CrazyPanel pnlUnidadesForm6;
    private Clases.CrazyPanel pnlUnidadesForm7;
    private Clases.CrazyPanel pnlUsuarioForm;
    private Clases.CrazyPanel pnlUsuarioForm1;
    private Clases.CrazyPanel pnlUsuarioForm2;
    private javax.swing.JPanel pnlUsuarioForm3;
    private javax.swing.JPanel pnlUsuarioForm4;
    public raven.crazypanel.CrazyPanel pnlUsuarios;
    public Clases.CrazyPanel tablaConsumos;
    public Clases.CrazyPanel tablaEmpresas;
    public Clases.CrazyPanel tablaPersonas;
    public Clases.CrazyPanel tablaRecargas;
    public Clases.CrazyPanel tablaRutas;
    public Clases.CrazyPanel tablaTarjetas;
    public Clases.CrazyPanel tablaUnidades;
    public Clases.CrazyPanel tablaUnidades1;
    public Clases.CrazyPanel tablaUsuarios;
    public javax.swing.JTable tblConsumos;
    public javax.swing.JTable tblEmpresastrans;
    public javax.swing.JTable tblRecargas;
    public javax.swing.JTable tblpersonas;
    public javax.swing.JTable tblrutas;
    public javax.swing.JTable tbltarjetas;
    public javax.swing.JTable tblunidades;
    public javax.swing.JTable tblusuarios;
    private javax.swing.JTextField txtBuscar1;
    private javax.swing.JTextField txtBuscar2;
    private javax.swing.JTextField txtBuscar3;
    private javax.swing.JTextField txtBuscar4;
    private javax.swing.JTextField txtBuscar5;
    private javax.swing.JTextField txtBuscar6;
    private javax.swing.JTextField txtBuscar7;
    private javax.swing.JTextField txtBuscar8;
    public javax.swing.JTextField txtCodConsumo;
    public javax.swing.JTextField txtCodSoat;
    public javax.swing.JTextField txtCodTarjetaconsu;
    public javax.swing.JTextField txtCodUnidad;
    public javax.swing.JTextField txtCodUnidadconsu;
    public javax.swing.JTextField txtContraUser;
    public javax.swing.JTextField txtDniUsers;
    public javax.swing.JTextField txtDniunidad;
    private javax.swing.JTextField txtEmailDestino;
    public javax.swing.JTextField txtIdRutaUnidad;
    public javax.swing.JTextField txtIdUser;
    private javax.swing.JTextField txtMontoFinal;
    private javax.swing.JTextField txtMontoInicial;
    private javax.swing.JTextField txtRutas;
    private javax.swing.JTextField txtTransportistas;
    public javax.swing.JTextField txtUserUsuario;
    public javax.swing.JTextField txtapematpersona;
    public javax.swing.JTextField txtapepatpersona;
    public javax.swing.JTextField txtcelusuario;
    public javax.swing.JTextField txtcodrecarga;
    public javax.swing.JTextField txtcodtarjeta;
    public javax.swing.JTextField txtcolorempresa;
    public javax.swing.JTextField txtdnipersona;
    public javax.swing.JTextField txtdnipersonatarjeta;
    public javax.swing.JTextField txtemail;
    public javax.swing.JTextField txtidrutman;
    public javax.swing.JTextField txtmontorecarga;
    public javax.swing.JTextField txtmontoruta;
    public javax.swing.JTextField txtnombreempresa;
    public javax.swing.JTextField txtnombrepersona;
    public javax.swing.JTextField txtnombreruta;
    public javax.swing.JTextField txtruc;
    public javax.swing.JTextField txtrucempresa;
    public javax.swing.JTextField txtsaldo;
    // End of variables declaration//GEN-END:variables

}
