package Cajon;

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
public class ConstructorCajonUsuario extends SimpleDrawerBuilder{
    private VistaUsuario main2;
    
    public ConstructorCajonUsuario(VistaUsuario main2) {
        this.main2 = main2;
    }
    
    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData()
            .setTitle("Usuario")
            .setDescription("Bienvenido estimado");
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {
            {"~Administración~"},
            {"Movimientos", "Recargas"},
            {"~Configuración~"},
            {"Proximamente"}
                
        };
        String iconos[] = {
            "pago.svg",
            
        };
        return new SimpleMenuOption()
            .setMenus(menus)
            .setIcons(iconos)
            .setBaseIconPath("Icono")
            .setIconScale(0.35f)
            .addMenuEvent(new MenuEvent() {
                @Override
                public void selected(MenuAction action, int i, int s) {
                   
                    
                    if (i == 0 && s == 1) {
                         main2.pnlRecargas.setVisible(false);
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
