package VideoPanel;


import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class Registro extends JPanel {
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmarPassword;
    private ButtonGroup groupGender;
    private JButton cmdRegistrar;
    public Registro(){
        init();
    }

    private void init(){
        //setLayout(new MigLayout("fill,insets 20","[center]", "[center]"));
        JPanel panel = new JPanel();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtUsuario = new JTextField();
        txtPassword = new JPasswordField();
        txtConfirmarPassword = new JPasswordField();
        cmdRegistrar = new JButton();

        JPanel panel1 = new JPanel(new MigLayout("wrap,fillx,insets 35 45 30 45", "[fill,360]"));
        //toy agregando todavia
        JLabel lbTitle = new JLabel("Registrate ahora");

        add(panel);

        setOpaque(false);
    }

}
