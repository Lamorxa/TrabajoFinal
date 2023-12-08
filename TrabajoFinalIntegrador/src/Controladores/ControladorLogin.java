/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.Frmlogin;
import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.UsuarioDAO;
import modelos.Usuarios;

/**
 *
 * @author LamorxaXD
 */
public class ControladorLogin implements ActionListener{
 
    private Usuarios us;
    private UsuarioDAO UsDao;
    private Frmlogin views;

    public ControladorLogin(Usuarios us, UsuarioDAO UsDao, Frmlogin views) {
        this.us = us;
        this.UsDao = UsDao;
        this.views = views;
        this.views.btnIngresar.addActionListener(this);
        this.views.btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==views.btnIngresar) {
           if (views.txtUsuario.getText().equals ("" )||String.valueOf(views.txtContrasena.getPassword()).equals("")) 
           {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
           }
           else{
           String usuario=views.txtUsuario.getText();
           String contra=String.valueOf(views.txtContrasena.getPassword());
           us=UsDao.login(usuario, contra);
           if(us.getUser()!=null)
           {
               int tipusu=UsDao.obtenerTipoUsuario(us);
               switch (tipusu) {
                   case 1:
               Vistaadministrador vistaadmin =new Vistaadministrador();
               vistaadmin.setVisible(true);
               this.views.dispose();
                       break;
                       case 2:
                           VistaConductor vistaconduc =new VistaConductor();
                           vistaconduc.setVisible(true);
                           this.views.dispose();
                           
                       break;
                       case 3:
                           VistaUsuario vistusu=new VistaUsuario();
                           vistusu.setVisible(true);
                           this.views.dispose();
                       
                       break;
                   default:
                       throw new AssertionError();
               }
               
           }else{
               JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos");
           }
           }
        }else{
        int pregunta=JOptionPane.showConfirmDialog(null, "esta seguro que desea salir?", "Confiermacion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (pregunta==0) {
                System.exit(0);
                
            }
        }
    
    
    }
    
    
    
}
