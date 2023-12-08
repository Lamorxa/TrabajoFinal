package Gestor;


import VideoPanel.Superposicion;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import javax.swing.*;
import java.awt.*;

public class FormsGestor {
    private Superposicion superposicion;
    private static FormsGestor instance;

    public static FormsGestor getInstance(){
        if (instance ==null){
            instance = new FormsGestor();
        }
        return instance;
    }

    private FormsGestor(){

    }


    public void initSuperpos(Superposicion superposicion){
        this.superposicion = superposicion;
    }

    public void showForm(JComponent form){
        EventQueue.invokeLater(() -> {
            superposicion.setContentPane(form);
            superposicion.revalidate();
            superposicion.repaint();
            FlatAnimatedLafChange.showSnapshot();

        });
    }
}
