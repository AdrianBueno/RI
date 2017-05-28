package uo.ri.amp.ui.admin.nominas.action;



import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.input.InputData;
import uo.ri.amp.common.io.output.PrinterData;
import alb.util.log.Logger;
import alb.util.menu.Action;

/**
 * @author Adrian Garcia Bueno UO232346
 * @version 1
 * Esta clase se encarga de eliminar la última nómina generada
 * de un mecánico dado.
 */
public class DeleteLastNominaAction implements Action {
	private String feedback = "Última nómina borrada del mecánico: ";
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
		Long idMecanico = input.getMecanicoId();
		//logic
		service.deleteLastNomina(idMecanico);
		//output
		printer.print(feedback+idMecanico);
		logger.info(feedback+idMecanico);
	}

}
