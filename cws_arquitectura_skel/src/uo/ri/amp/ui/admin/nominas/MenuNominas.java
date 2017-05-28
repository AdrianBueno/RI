package uo.ri.amp.ui.admin.nominas;

import uo.ri.amp.ui.admin.nominas.action.DeleteLastNominaAction;
import uo.ri.amp.ui.admin.nominas.action.GenerateNominasAction;
import uo.ri.amp.ui.admin.nominas.action.ListDetailNominasAction;
import uo.ri.amp.ui.admin.nominas.action.ListGeneralNominasAction;
import alb.util.menu.BaseMenu;

public class MenuNominas extends BaseMenu {
	public MenuNominas() {
		menuOptions = new Object[][] {
				{"Menu N�minas",null},
				{"Generar N�minas", GenerateNominasAction.class},
				{"Borrar �ltima nomina de mecanico", DeleteLastNominaAction.class},
				{"Listar nominas de mecanico", ListGeneralNominasAction.class},
				{"Listar nomina detalladamente", ListDetailNominasAction.class}
		};
	}
	
}
