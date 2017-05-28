package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.categoriasContrato.MenuCategoriasContrato;
import uo.ri.amp.ui.admin.contratos.MenuContratos;
import uo.ri.amp.ui.admin.mecanicos.MenuMecanicos;
import uo.ri.amp.ui.admin.nominas.MenuNominas;
import uo.ri.amp.ui.admin.repuestos.MenuRepuestos;
import uo.ri.amp.ui.admin.tiposContrato.MenuTiposContrato;
import uo.ri.amp.ui.admin.tiposVehiculo.MenuTiposVehiculo;
import alb.util.menu.BaseMenu;

public class MainMenuAdmin extends BaseMenu {
	public MainMenuAdmin() {
		menuOptions = new Object[][] { 
			{ "Menú Administrador", null },
			{ "Gestionar Mecánicos.", 			MenuMecanicos.class }, 
			{ "Gestionar Contratos.", 			MenuContratos.class },
			{ "Gestionar Categorias de Contrato.", 			MenuCategoriasContrato.class },
			{ "Gestionar Tipos de Contrato.", 			MenuTiposContrato.class },
			{ "Gestionar Nominas.", 			MenuNominas.class },
			{ "Gestionar Repuestos.", 			MenuRepuestos.class },
			{ "Gestionar Tipos de Vehiculo.", 	MenuTiposVehiculo.class }
		};
	}
}
