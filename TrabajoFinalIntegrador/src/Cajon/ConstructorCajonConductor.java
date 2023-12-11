
package Cajon;

import Vistas.VistaConductor;
import Vistas.VistaUsuario;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.SimpleMenuOption;

/**
 *
 * @author abela
 */
public class ConstructorCajonConductor extends SimpleDrawerBuilder{
    private VistaConductor main3;
    
    public ConstructorCajonConductor(VistaConductor main3) {
        this.main3 = main3;
    }
    
    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData()
            .setTitle("Conductor")
            .setDescription("Bienvenido estimado");
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {
            {"~Administración~"},
            {"Consumos"},
            {"Rutas"},
            {"~Configuración~"},
            {"Proximamente"}
                
        };
        String iconos[] = {
            "pago.svg",
            "ruta.svg",
            "transporte.svg"
            
        };
        return new SimpleMenuOption()
            .setMenus(menus)
            .setIcons(iconos)
            .setBaseIconPath("Icono")
            .setIconScale(0.35f)
            .addMenuEvent(new MenuEvent() {
                @Override
                public void selected(MenuAction action, int i, int s) {
                   
                    
                    if (i == 0) {
                         System.out.println("Menu " + i + " " + s);
                         main3.pnlConsumos.setVisible(true);
                         main3.pnlRutas.setVisible(false);
                         main3.pnlEmpresas.setVisible(false);
                         main3.pnlUnidades.setVisible(false);
                    }
                    if (i == 1) {
                         System.out.println("Menu " + i + " " + s);
                         main3.pnlConsumos.setVisible(false);
                         main3.pnlRutas.setVisible(true);
                         main3.pnlEmpresas.setVisible(false);
                         main3.pnlUnidades.setVisible(false);
                         
                    }
                   
                    
                }
            });
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData()
            .setTitle("eTravelEasy")
            .setDescription("La mejor experiencia");
    }
}
