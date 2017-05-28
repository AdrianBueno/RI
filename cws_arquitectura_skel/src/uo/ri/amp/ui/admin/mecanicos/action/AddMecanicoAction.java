package uo.ri.amp.ui.admin.mecanicos.action;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.input.InputData;
import uo.ri.amp.common.io.output.PrinterData;
import uo.ri.amp.common.model.Mecanico;
import alb.util.log.Logger;
import alb.util.menu.Action;

/**
 * @author Adrian Garcia Bueno UO232346
 * @version 1
 * Esta clase se encarga de añadir un nuevo mecánico al sistema
 */
public class AddMecanicoAction implements Action {
	private String feedback = "Mecánico añadido.";
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
		String dni = 		input.getDni();
		String nombre = 	input.getNombre();
		String apellidos = 	input.getApellidos();
		//logic
		Mecanico mecanico = new Mecanico(dni,nombre,apellidos);
		service.addMechanic(mecanico);
		//output
		printer.print(feedback);
		logger.info(feedback);
	}
}
