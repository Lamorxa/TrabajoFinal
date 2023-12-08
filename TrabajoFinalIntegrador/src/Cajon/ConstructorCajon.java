/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cajon;

import Vistas.Vistaadministrador;
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

public class ConstructorCajon extends SimpleDrawerBuilder{

    private Vistaadministrador main;
    
    public ConstructorCajon(Vistaadministrador main) {
        this.main = main;
    }
    
    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData()
            .setTitle("Administrador")
            .setDescription("Bienvenido estimado");
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {
            {"~Administración~"},
            {"Administrar", "Personas", "Usuarios"},
            {"Movimientos", "Tarjetas", "Recargas", "Consumos"},
            {"Rutas"},
            {"Transporte", "Empresa", "Unidades"},
            {"~Informes~"},
            {"Reportes"}
                
        };
        String iconos[] = {
            "user.svg",
            "pago.svg",
            "ruta.svg",
            "transporte.svg",
            "reportes.svg"
            
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
                         System.out.println("Menu " + i + " " + s);
                         main.pnlPersonas.setVisible(true);
                         main.pnlUsuarios.setVisible(false);
                         main.pnlTarjetas.setVisible(false);
                         main.pnlRecargas.setVisible(false);
                         main.pnlConsumos.setVisible(false);
                         main.pnlRutas.setVisible(false);
                         main.pnlEmpresas.setVisible(false);
                         main.pnlUnidades.setVisible(false);
                         main.pnlReportes.setVisible(false);
                    }
                    if (i == 0 && s == 2) {
                         System.out.println("Menu " + i + " " + s);
                         main.pnlPersonas.setVisible(false);
                         main.pnlUsuarios.setVisible(true);
                         main.pnlTarjetas.setVisible(false);
                         main.pnlRecargas.setVisible(false);
                         main.pnlConsumos.setVisible(false);
                         main.pnlRutas.setVisible(false);
                         main.pnlEmpresas.setVisible(false);
                         main.pnlUnidades.setVisible(false);
                         main.pnlReportes.setVisible(false);
                         
                    }
                    if (i == 1 && s == 1) {
                         System.out.println("Menu " + i + " " + s);
                         main.pnlPersonas.setVisible(false);
                         main.pnlUsuarios.setVisible(false);
                         main.pnlTarjetas.setVisible(true);
                         main.pnlRecargas.setVisible(false);
                         main.pnlConsumos.setVisible(false);
                         main.pnlRutas.setVisible(false);
                         main.pnlEmpresas.setVisible(false);
                         main.pnlUnidades.setVisible(false);
                         main.pnlReportes.setVisible(false);
                    }
                    if (i == 1 && s == 2) {
                         System.out.println("Menu " + i + " " + s);
                         main.pnlPersonas.setVisible(false);
                         main.pnlUsuarios.setVisible(false);
                         main.pnlTarjetas.setVisible(false);
                         main.pnlRecargas.setVisible(true);
                         main.pnlConsumos.setVisible(false);
                         main.pnlRutas.setVisible(false);
                         main.pnlEmpresas.setVisible(false);
                         main.pnlUnidades.setVisible(false);
                         main.pnlReportes.setVisible(false);
                    }
                    if (i == 1 && s == 3) {
                         System.out.println("Menu " + i + " " + s);
                         main.pnlPersonas.setVisible(false);
                         main.pnlUsuarios.setVisible(false);
                         main.pnlTarjetas.setVisible(false);
                         main.pnlRecargas.setVisible(false);
                         main.pnlConsumos.setVisible(true);
                         main.pnlRutas.setVisible(false);
                         main.pnlEmpresas.setVisible(false);
                         main.pnlUnidades.setVisible(false);
                         main.pnlReportes.setVisible(false);
                    }
                    if (i == 2) {
                         System.out.println("Menu " + i + " " + s);
                         main.pnlPersonas.setVisible(false);
                         main.pnlUsuarios.setVisible(false);
                         main.pnlTarjetas.setVisible(false);
                         main.pnlRecargas.setVisible(false);
                         main.pnlConsumos.setVisible(false);
                         main.pnlRutas.setVisible(true);
                         main.pnlEmpresas.setVisible(false);
                         main.pnlUnidades.setVisible(false);
                         main.pnlReportes.setVisible(false);
                    }
                    if (i == 3 && s == 1) {
                         System.out.println("Menu " + i + " " + s);
                         main.pnlPersonas.setVisible(false);
                         main.pnlUsuarios.setVisible(false);
                         main.pnlTarjetas.setVisible(false);
                         main.pnlRecargas.setVisible(false);
                         main.pnlConsumos.setVisible(false);
                         main.pnlRutas.setVisible(false);
                         main.pnlEmpresas.setVisible(true);
                         main.pnlUnidades.setVisible(false);
                         main.pnlReportes.setVisible(false);
                    }
                    if (i == 3 && s == 2) {
                         System.out.println("Menu " + i + " " + s);
                         main.pnlPersonas.setVisible(false);
                         main.pnlUsuarios.setVisible(false);
                         main.pnlTarjetas.setVisible(false);
                         main.pnlRecargas.setVisible(false);
                         main.pnlConsumos.setVisible(false);
                         main.pnlRutas.setVisible(false);
                         main.pnlEmpresas.setVisible(false);
                         main.pnlUnidades.setVisible(true);
                         main.pnlReportes.setVisible(false);
                    }
                    if (i == 4) {
                         System.out.println("Menu " + i + " " + s);
                         main.pnlPersonas.setVisible(false);
                         main.pnlUsuarios.setVisible(false);
                         main.pnlTarjetas.setVisible(false);
                         main.pnlRecargas.setVisible(false);
                         main.pnlConsumos.setVisible(false);
                         main.pnlRutas.setVisible(false);
                         main.pnlEmpresas.setVisible(false);
                         main.pnlUnidades.setVisible(false);
                         main.pnlReportes.setVisible(true);
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
