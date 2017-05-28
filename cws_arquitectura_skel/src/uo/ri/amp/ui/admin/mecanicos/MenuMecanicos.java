package uo.ri.amp.ui.admin.mecanicos;

import uo.ri.amp.ui.admin.mecanicos.action.AddMecanicoAction;
import uo.ri.amp.ui.admin.mecanicos.action.DeleteMecanicoAction;
import uo.ri.amp.ui.admin.mecanicos.action.ListAllMecanicosAction;
import uo.ri.amp.ui.admin.mecanicos.action.ListMecanicosAction;
import uo.ri.amp.ui.admin.mecanicos.action.UpdateMecanicoAction;
import alb.util.menu.BaseMenu;

public class MenuMecanicos extends BaseMenu {

	public MenuMecanicos(){
		menuOptions = new Object[][] { 
				{ "Menú Mecanicos", null },
				{ "Añadir Mecánico.", 			AddMecanicoAction.class },
				{ "Actualizar Mecánico.", 			UpdateMecanicoAction.class },
				{ "Borrar Mecánico.", 			DeleteMecanicoAction.class },
				{ "Listar Mécanicos.", 			ListMecanicosAction.class },
				{ "Listar todos los Mecánicos.",ListAllMecanicosAction.class }
			};
	}
}
