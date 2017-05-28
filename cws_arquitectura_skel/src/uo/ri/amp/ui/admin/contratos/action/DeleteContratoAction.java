/*
 * DeleteContratoAction.java
 * Adrián García Bueno
 * uo232346@uniovi.es
 */
package uo.ri.amp.ui.admin.contratos.action;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.input.InputData;
import uo.ri.amp.common.io.output.PrinterData;
import alb.util.log.Logger;
import alb.util.menu.Action;


/**
 * Esta clase implementa una acción sobre la interfaz de servicio
 * de administrador.
 * uo.ri.amp.ui.admin.contratos.action DeleteContratoAction
 * @version 3 20/12/2014
 * @author Adrián
 */
public class DeleteContratoAction implements Action {
	private String feedback = "Contrato eliminado.";
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
		Long idContrato = input.getContratoId();
		//logic
		service.deleteContrato(idContrato);
		//output
		printer.print(feedback);
		logger.info(feedback);
	}
	

}
