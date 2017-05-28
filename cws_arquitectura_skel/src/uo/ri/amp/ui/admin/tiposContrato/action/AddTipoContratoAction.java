package uo.ri.amp.ui.admin.tiposContrato.action;


import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.input.InputData;
import uo.ri.amp.common.io.output.PrinterData;
import uo.ri.amp.common.model.TipoContrato;
import alb.util.log.Logger;
import alb.util.menu.Action;

/**
 * @author Adri�n Garc�a Bueno UO232346
 * @version 2
 * Esta clase se encarga de a�adir un tipo de contrato
 * son necesarios los datos:
 * nombre y el n�mero de dias de indemnizaci�n por su finalizaci�n
 */
public class AddTipoContratoAction implements Action {
	private String feedback = "Tipo de contrato a�adido.";
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
		String name = input.getNombre();
		Integer dias = input.getDiasIndemnizacion();
		//logic
		TipoContrato tipo = new TipoContrato(name, dias);
		service.addTipoContrato(tipo);
		//output
		printer.print(feedback);
		logger.info(feedback);
	}	
}

