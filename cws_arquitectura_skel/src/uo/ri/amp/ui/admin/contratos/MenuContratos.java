package uo.ri.amp.ui.admin.contratos;

import uo.ri.amp.ui.admin.contratos.action.AddContratoAction;
import uo.ri.amp.ui.admin.contratos.action.DeleteContratoAction;
import uo.ri.amp.ui.admin.contratos.action.EndContratoAction;
import uo.ri.amp.ui.admin.contratos.action.ListContratosAction;
import uo.ri.amp.ui.admin.contratos.action.UpdateContratoAction;
import alb.util.menu.BaseMenu;

public class MenuContratos extends BaseMenu {

	public MenuContratos() {
		menuOptions = new Object[][] { 
				{ "Menú Contratos", null },
				{ "Añadir Contrato.", 			AddContratoAction.class },
				{ "Actualizar Contrato.", 			UpdateContratoAction.class },
				{ "Borrar Contrato.", 			DeleteContratoAction.class },
				{ "Finalizar Contrato.", 			EndContratoAction.class },
				{ "Listar Contratos.", 			ListContratosAction.class }
			};
	}
	
}
