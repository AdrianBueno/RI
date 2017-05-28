package uo.ri.amp.ui.admin.mecanicos.action;

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
 * Esta clase se encarga de eliminar un mec�nico dado del sistema
 * Solo se podr� borrar un mec�nico que:
 * No tenga averias, ni intervenciones, ni contratos, ni ha cobrado n�minas,
 */
public class DeleteMecanicoAction implements Action {
	private String feedback = "Mec�nico eliminado.";
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception{
		//input
		Long id = input.getMecanicoId();
		//logic
		service.deleteMechanic(id);
		//output
		printer.print(feedback);
		logger.info(feedback);
	}
}
