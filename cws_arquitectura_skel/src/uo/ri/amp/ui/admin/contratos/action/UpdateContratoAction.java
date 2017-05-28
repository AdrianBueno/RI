package uo.ri.amp.ui.admin.contratos.action;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.input.InputData;
import uo.ri.amp.common.io.output.PrinterData;
import alb.util.log.Logger;
import alb.util.menu.Action;

/**
 * 
 * @author Adrian Garcia Bueno UO232346 
 * @version 1
 * Esta clase permite actualizar un contrato existente asignado ya un mecánico
 * con el objeto de subsanar errores cometidos en el alta u otro caso excepcional.
 */
public class UpdateContratoAction implements Action {
	private String feedback = "Contrato actualizado.";
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
		Long idContrato = 	input.getContratoId();
		Long idCategoria = 	input.getCategoriaContratoId();
		Long idTipo = 		input.getTipoContratoId();
		Double salario = 	input.getSalarioAnual();
		//logic
		service.updateContrato(idContrato,idCategoria, idTipo,salario);
		//output
		printer.print(feedback);
		logger.info(feedback);
	}
}
