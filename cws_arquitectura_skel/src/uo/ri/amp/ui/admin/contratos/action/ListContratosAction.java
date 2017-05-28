package uo.ri.amp.ui.admin.contratos.action;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.input.InputData;
import uo.ri.amp.common.io.output.PrinterData;
import uo.ri.amp.common.model.Contrato;
import alb.util.log.Logger;
import alb.util.menu.Action;

/**
 * 
 * @author Adrian Garcia Bueno UO232346
 * @version 1
 * Esta clase permite listar todos los contratos de un mecánico dado.
 * Debe reflejar cláramente cuál es el contrato en vigor actualmente.
 * Se debe reflejar cuántas nóminas se han percibido con cada contrato.
 */
public class ListContratosAction implements Action {
	private String feedback = "Listados contratos de: ";
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
		Long id = input.getMecanicoId();
		//logic
		List<Contrato> contratos = service.listContratosByMecanico(id);
		//output
		printer.printContratos(contratos);
		printer.print(feedback +id);
		logger.info(feedback+id);
	}
}
