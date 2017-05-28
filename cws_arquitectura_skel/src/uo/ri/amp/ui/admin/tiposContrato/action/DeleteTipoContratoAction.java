package uo.ri.amp.ui.admin.tiposContrato.action;


import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.input.InputData;
import uo.ri.amp.common.io.output.PrinterData;
import alb.util.log.Logger;
import alb.util.menu.Action;

/**
 * 
 * @author Adrián García Bueno UO232346
 * @version 2
 * Esta clase se encarga de borrar un tipo de contrato
 * No se pueden borrar tipos que tengan algún contrato asociado.
 */
public class DeleteTipoContratoAction implements Action {
	private String feedback = "Tipo de contrato eliminado.";
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
		Long idTipo = input.getTipoContratoId();
		//logic
		service.deleteTipoContrato(idTipo);
		//output
		printer.print(feedback);
		logger.info(feedback);
	}
}
