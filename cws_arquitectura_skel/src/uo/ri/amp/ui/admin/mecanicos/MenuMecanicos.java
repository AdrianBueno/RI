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
				{ "Men� Mecanicos", null },
				{ "A�adir Mec�nico.", 			AddMecanicoAction.class },
				{ "Actualizar Mec�nico.", 			UpdateMecanicoAction.class },
				{ "Borrar Mec�nico.", 			DeleteMecanicoAction.class },
				{ "Listar M�canicos.", 			ListMecanicosAction.class },
				{ "Listar todos los Mec�nicos.",ListAllMecanicosAction.class }
			};
	}
}
