package uo.ri.amp.ui.admin.tiposContrato.action;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.output.PrinterData;
import uo.ri.amp.common.model.TipoContrato;
import alb.util.log.Logger;
import alb.util.menu.Action;

/**
 * 
 * @author Adrián García Bueno UO232346
 * @version 1
 * Esta clase se encarga de listar los tipos de contratos actuales
 */
public class ListTipoContratosAction implements Action {
	private String feedback = "Listados tipos de contrato";
	private AdminService service = BusinessFactory.getAdminService();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
			//nothing here
		//logic
		List<TipoContrato> tipos = service.listTiposContrato();
		//output
		printer.printTiposContrato(tipos);
		printer.print(feedback);
		logger.info(feedback);
	}
}
