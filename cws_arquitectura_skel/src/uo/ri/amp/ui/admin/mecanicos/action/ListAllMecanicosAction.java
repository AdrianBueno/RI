package uo.ri.amp.ui.admin.mecanicos.action;


import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.output.PrinterData;
import uo.ri.amp.common.model.Mecanico;
import alb.util.log.Logger;
import alb.util.menu.Action;

/**
 * 
 * @author Adrian Garcia Bueno UO232346
 * @version 1
 * Esta clase se encarga de listar todos los mecánicos del sistema.
 */
public class ListAllMecanicosAction implements Action {
	private String feedback = "Listados todos los mecánicos.";
	private AdminService service = BusinessFactory.getAdminService();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
			//nothing here
		//logic
		List<Mecanico> mecanicos = service.ListAllMecanicos();
		//output
		printer.printMecanicos(mecanicos);
		printer.print(feedback);
		logger.info(feedback);
	}

}
