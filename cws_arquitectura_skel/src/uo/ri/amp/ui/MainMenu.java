package uo.ri.amp.ui;

import uo.ri.amp.ui.admin.MainMenuAdmin;
import uo.ri.amp.ui.capataz.MainMenuCapataz;
import uo.ri.amp.ui.mecanico.MainMenuMecanico;
import alb.util.log.Log;
import alb.util.log.LogLevel;
import alb.util.menu.BaseMenu;

public class MainMenu extends BaseMenu {
	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "Menú Principal", null },
			{ "Menú para Administrador.", 			MainMenuAdmin.class }, 
			{ "Menú para Capataz.", 			MainMenuCapataz.class },
			{ "Menú para Mecanicos.", 	MainMenuMecanico.class },
		};
	}
	public static void main(String[] args) {
		//Set log off for final user.
		Log.setLogLevel(LogLevel.OFF);
		new MainMenu().execute();
	}

}
