package Vistas;

import Controladores.ControladorLogin;
import VideoPanel.Login;
//import VideoPanel.Registro;
import VideoPanel.VideoLogeo;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.util.UIScale;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import modelos.UsuarioDAO;
import modelos.Usuarios;

public class Frmlogin extends JFrame {
    Usuarios us= new Usuarios();
    UsuarioDAO usDao= new UsuarioDAO();
    public  JButton btnIngresar;
    public JButton btnCancelar;
     public JTextField txtUsuario;
    public JPasswordField txtContrasena;
    public JCheckBox chRecuerdame ;
    private boolean atributo;

    private VideoLogeo video;
    public Login login=new Login();
    public Frmlogin(){
                

        init();
        
        //ControladorLogin control =new ControladorLogin(us, usDao, this); 
        
    }
    public void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(UIScale.scale(new Dimension(800,450)));
        setLocationRelativeTo(null);
        
        setContentPane(login);
        //setContentPane(new Registro());
        btnIngresar = login.getCmdLogin();
        btnCancelar=login.getBtnCancelar();
        txtContrasena=login.getTxtContrasena();
        txtUsuario=login.getTxtUsuario();
                
        video = new VideoLogeo();
        setContentPane(video);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                video.initSuperpos(Frmlogin.this);
                video.play(0);

            }

            @Override
            public void windowClosing(WindowEvent e) {
                video.stop();
            }
        });
        Timer timer = new Timer(6000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acciones a realizar cada 6 segundos
                setAtributo (login.isEstado());
                verificarAtributo();
            }
        });

        // Inicia el temporizador para que se repita continuamente
        timer.setRepeats(true);
        timer.start();
    }

    public static void main(String[] args){
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("Temas");
        FlatMacDarkLaf.setup();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN,14));
        EventQueue.invokeLater(() -> new Frmlogin().setVisible(true));
    }
private void verificarAtributo() {
        // Lógica para verificar el atributo cada 6 segundos
        if (atributo) {
            System.out.println("El atributo es verdadero");
        } else {
            System.out.println("El atributo es falso");
        }
    }

    public void setAtributo(boolean atributo) {
        this.atributo = atributo;
    }

}