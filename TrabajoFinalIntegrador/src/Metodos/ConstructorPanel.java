package Metodos;

import java.awt.Graphics;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import Vistas.Vistaadministrador;

/**
 *
 * @author abela
 */
public class ConstructorPanel extends BasicTabbedPaneUI {
    
    private ConstructorPanel mainp;

    public ConstructorPanel(ConstructorPanel mainp) {
        this.mainp = mainp;
    }
    
    @Override
    protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
        tabPlacement = 0;
        horizRunCount = 0;
        maxTabHeight = 0;
        return 0; // Oculta el área de pestañas
    }

    @Override
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
        // No pinta el área de pestañas
    }
    //main.paneles.calculateTabAreaHeight;
}
