package uo.ri.amp.ui.admin.tiposContrato;

import uo.ri.amp.ui.admin.tiposContrato.action.AddTipoContratoAction;
import uo.ri.amp.ui.admin.tiposContrato.action.DeleteTipoContratoAction;
import uo.ri.amp.ui.admin.tiposContrato.action.ListPerTipoContratoAction;
import uo.ri.amp.ui.admin.tiposContrato.action.ListTipoContratosAction;
import uo.ri.amp.ui.admin.tiposContrato.action.UpdateTipoContratoAction;
import alb.util.menu.BaseMenu;

public class MenuTiposContrato extends BaseMenu {
	public MenuTiposContrato() {
		menuOptions = new Object[][] {
				{"Menu Tipos de contrato", null},
				{"Añadir tipo de contrato", AddTipoContratoAction.class},
				{"Borrar tipo de contrato", DeleteTipoContratoAction.class},
				{"Actualizar tipo de contrato",UpdateTipoContratoAction.class},
				{"Listar por tipo de contrato", ListPerTipoContratoAction.class},
				{"Listar tipos de contrato", ListTipoContratosAction.class}
		};
	}
}
