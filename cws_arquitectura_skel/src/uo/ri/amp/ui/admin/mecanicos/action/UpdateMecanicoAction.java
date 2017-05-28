package uo.ri.amp.ui.admin.mecanicos.action;
import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.input.InputData;
import uo.ri.amp.common.io.output.PrinterData;
import alb.util.log.Logger;
import alb.util.menu.Action;


/**
 * Esta clase se encarga de elaborar una petición de actualización de
 * un mecánico. Para ello usa las interfaces AdminServices, InputData,
 * PrinterData y Logger a las que proporciona una implementación
 * las clases BusinessFactory e IoFactory
 * uo.ri.amp.ui.admin.mecanicos.action UpdateMecanicoAction
 * @version 1 27/12/2014
 * @author Adrián
 */
public class UpdateMecanicoAction implements Action {
	private String feedback = "Mecánico actualizado.";
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
		Long idMecanico = 	input.getMecanicoId();
		String nombre = 	input.getNombre();
		String apellidos = 	input.getApellidos();
		//logic
		service.updateMechanic(idMecanico,nombre,apellidos);
		//output
		printer.print(feedback);
		logger.info(feedback);
	}
}
