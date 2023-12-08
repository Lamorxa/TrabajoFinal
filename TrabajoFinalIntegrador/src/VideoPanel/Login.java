package VideoPanel;

import Gestor.FormsGestor;
import Vistas.Vistaadministrador;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class Login extends JPanel {
    public JTextField txtUsuario = new JTextField();
    public JPasswordField txtContrasena = new JPasswordField();
    public JCheckBox chRecuerdame = new JCheckBox("Recuerdame");
    public JButton cmdLogin = new JButton("Login");
    public JButton btnCancelar = new JButton("Cancelar");
    public boolean estado =false;
    
    public Login(){
        init();
    }

    public void init(){
        setOpaque(false);
        setLayout(new MigLayout("wrap,fillx,insets 60 60 40 60", "[fill]"));
        JLabel title = new JLabel("              Inicia Sesion            ",SwingConstants.CENTER);
        
        
        
        title.putClientProperty(FlatClientProperties.STYLE,"" + "font:bold +10");
        txtUsuario.putClientProperty(FlatClientProperties.STYLE,"" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        txtContrasena.putClientProperty(FlatClientProperties.STYLE,"" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0;" +
                "showRevealButton:true");
        cmdLogin.putClientProperty(FlatClientProperties.STYLE,"" +
                "background:$Component.accentColor;" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");
        
        txtUsuario.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese usuario");
        txtContrasena.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese contraseña");

        add(title);
        add(new JLabel("Usuario"), "gapy 20");
        add(txtUsuario);
        add(new JLabel("Contraseña"), "gapy 20");
        add(txtContrasena);
        add(chRecuerdame);
        add(cmdLogin, "gapy 30");
        add(btnCancelar);
        add(createSignupLabel());
        cmdLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acciones a realizar cuando se presiona el botón
                System.out.println("¡Botón presionado en el panel!");
                
                 Vistaadministrador vistaadmin =new Vistaadministrador();
               vistaadmin.setVisible(true);

            }
        });}
     
    private Component createSignupLabel(){

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.putClientProperty(FlatClientProperties.STYLE, "" +
                "background:null");
        JButton cmdRegister = new JButton("<html><a href=\"#\">Registrate</a></html>");
        cmdRegister.putClientProperty(FlatClientProperties.STYLE, "" +
                "border:3,3,3,3");
        cmdRegister.setContentAreaFilled(false);
        cmdRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdRegister.addActionListener(e -> {
            //FormsGestor.getInstance().showForm(new Registro());
        });
        JLabel label = new JLabel("¿Aún no tienes cuenta?");
        panel.add(label);
        panel.add(cmdRegister);
        panel.setOpaque(false);
        return panel;
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int arc = UIScale.scale(20);
        g2.setColor(getBackground());
        g2.setComposite(AlphaComposite.SrcOver.derive(0.6f));
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));
        g2.dispose();
        super.paintComponent(g);
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public JPasswordField getTxtContrasena() {
        return txtContrasena;
    }

    public void setTxtContrasena(JPasswordField txtContrasena) {
        this.txtContrasena = txtContrasena;
    }

    public JCheckBox getChRecuerdame() {
        return chRecuerdame;
    }

    public void setChRecuerdame(JCheckBox chRecuerdame) {
        this.chRecuerdame = chRecuerdame;
    }

    public JButton getCmdLogin() {
        return cmdLogin;
    }

    public void setCmdLogin(JButton cmdLogin) {
        this.cmdLogin = cmdLogin;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
