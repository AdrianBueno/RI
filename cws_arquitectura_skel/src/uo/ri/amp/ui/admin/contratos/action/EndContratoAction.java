package uo.ri.amp.ui.admin.contratos.action;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.input.InputData;
import uo.ri.amp.common.io.output.PrinterData;
import uo.ri.amp.common.model.Contrato;
import alb.util.log.Logger;
import alb.util.menu.Action;

/**
 * @author Adrian Garcia Bueno UO232346
 * @version 1
 * Esta clase pone fin a un contrato dado sea cual se su tipo
 * Establecerá la fecha de extinción al final del mes en curso
 * y le calculará su importe de liquidación
 */
public class EndContratoAction implements Action {
	private String feedback = "Contrato finalizado.";
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
		Long idContrato = input.getContratoId();
		//logic
		Contrato contrato = service.finaliceContrato(idContrato);
		//output
		printer.printContrato(contrato);
		printer.print(feedback);
		logger.info(feedback);
	}
}

