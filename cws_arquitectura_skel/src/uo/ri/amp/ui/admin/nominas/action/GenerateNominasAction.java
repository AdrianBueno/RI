package uo.ri.amp.ui.admin.nominas.action;


import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.output.PrinterData;
import alb.util.log.Logger;
import alb.util.menu.Action;

/**
 * 
 * @author Adrian Garcia Bueno UO232346
 * @version 1
 * Esta clase generar� las n�minas del mes anterior al actual
 * Genera las n�minas de los empleados con contrato en vigor
 * y que no la tengan generada, Asumento que la duraci�n ser� de multiplos 1 mes
 *
 */
public class GenerateNominasAction implements Action {
	private String feedback = "N�mero de n�minas generadas: ";
	private AdminService service = BusinessFactory.getAdminService();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
			//Nothing here
		//logic
		service.generateNominas();
		//output
		printer.print(feedback);
		logger.info(feedback);
	}

}
