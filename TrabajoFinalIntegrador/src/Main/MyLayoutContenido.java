
package Main;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author abela
 */
public class MyLayoutContenido extends JPanel{
    public MyLayoutContenido(){
        init();
    }
    
    public void init(){
        setOpaque(false);
        setSize(UIScale.scale(new Dimension(1245, 610)));
        setLayout(new MigLayout("wrap,fillx,insets 60 360 160 360", "[fill]"));
        JTextField txtNombreAdmi = new JTextField();
        JTextField txtApePatAdmi = new JTextField();
        JTextField txtApeMatAdmi = new JTextField();
        JTextField txtDniAdmi = new JTextField();
        JTextField txtCelularAdmi = new JTextField();
        JTextField txtEmailAdmi = new JTextField();
        JTextField txtRucAdmi = new JTextField();
        JButton btnAgregarAdmi = new JButton("Agregar");
        JButton btnCancelarAdmi = new JButton("Cancelar");
        txtNombreAdmi.putClientProperty(FlatClientProperties.STYLE,"" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        txtApePatAdmi.putClientProperty(FlatClientProperties.STYLE,"" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0;" +
                "showRevealButton:true");
        txtApeMatAdmi.putClientProperty(FlatClientProperties.STYLE,"" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0;" +
                "showRevealButton:true");
        txtDniAdmi.putClientProperty(FlatClientProperties.STYLE,"" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0;" +
                "showRevealButton:true");
        txtCelularAdmi.putClientProperty(FlatClientProperties.STYLE,"" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0;" +
                "showRevealButton:true");
        txtEmailAdmi.putClientProperty(FlatClientProperties.STYLE,"" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0;" +
                "showRevealButton:true");
        txtRucAdmi.putClientProperty(FlatClientProperties.STYLE,"" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0;" +
                "showRevealButton:true");
        btnAgregarAdmi.putClientProperty(FlatClientProperties.STYLE,"" +
                "background:$Component.accentColor;" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");
        btnCancelarAdmi.putClientProperty(FlatClientProperties.STYLE,"" +
                "background:$Component.accentColor;" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");
        txtNombreAdmi.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nombre");
        txtApePatAdmi.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Apellido Paterno");
        txtApeMatAdmi.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Apellido Materno");
        txtDniAdmi.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DNI");
        txtCelularAdmi.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Celular");
        txtEmailAdmi.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Email");
        txtRucAdmi.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "RUC");

        add(new JLabel("Nombre"), "gapy 20");
        add(txtNombreAdmi);
        add(new JLabel("Apellidos"), "gapy 20");
        add(txtApePatAdmi);
        add(txtApeMatAdmi);
        add(new JLabel("DNI"), "gapy 20");
        add(txtDniAdmi);
        add(new JLabel("Celular"), "gapy 20");
        add(txtCelularAdmi);
        add(new JLabel("Email"), "gapy 20");
        add(txtEmailAdmi);
        add(new JLabel("RUC"), "gapy 20");
        add(txtRucAdmi);
        add(btnAgregarAdmi, "gapy 20");
        add(btnCancelarAdmi, "gapy 20");  
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
}
