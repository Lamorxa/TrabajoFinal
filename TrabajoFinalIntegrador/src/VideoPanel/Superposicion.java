package VideoPanel;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Superposicion extends JWindow {
    private PanelSuperpuesto encima;
    private final List<Name> names;

    public Superposicion(JFrame frame, List<Name> names) {
        super(frame);
        this.names = names;
        init();
    }

    private void init() {
        encima = new PanelSuperpuesto();
        setBackground(new Color(25, 66, 80, 60));
        setLayout(new BorderLayout());
        add(encima);
    }

    public PanelSuperpuesto getEncima() {
        return encima;
    }

    public void setEncima(PanelSuperpuesto encima) {
        this.encima = encima;
    }


    public class PanelSuperpuesto extends JPanel {
        private JTextPane textTitulo;
        private Login panelLogin;

        public PanelSuperpuesto() {
            init();
        }

        private void init() {
            textTitulo = new JTextPane();
            setOpaque(false);
            setLayout(new MigLayout("fill,insets 180 30 10 10", "fill", "[grow 0][]"));
            createLogin();
            JPanel panel = new JPanel(new MigLayout("wrap", "", "[]30[]"));
            panel.setOpaque(false);
            textTitulo.setOpaque(false);
            textTitulo.setEditable(false);
            textTitulo.putClientProperty(FlatClientProperties.STYLE, "font:bold +40; border:0,0,0,0");
            panel.add(textTitulo);
            add(panel, "width 55%!");
        }

        public void setIndex(int index) {
            Name name = names.get(index);
            textTitulo.setText(name.getTitulo());
        }

        private void createLogin() {
            panelLogin = new Login();
            add(panelLogin, "pos 45% 0al,w 0");
            //add(panelLogin, "pos 45% 0al,w 0");
        }
    }
}
