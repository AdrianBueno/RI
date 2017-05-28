package uo.ri.amp.ui.admin.tiposContrato.action;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.input.InputData;
import uo.ri.amp.common.io.output.PrinterData;
import uo.ri.amp.common.model.Mecanico;
import alb.util.log.Logger;
import alb.util.menu.Action;


/**
 * @author Adrián García Bueno UO232346
 * @version 2
 * Esta clase se encarga de listar todos los mecánicos por tipo de contrato.
 * Se listarán mecánicos con contrato en activo
 * Al final del listado aparecerá un acumulado del salario bruto
 *  de todos los trabajadores
 * con ese tipo de contrato y el número de trabajadores de ese tipo
 */
//¿Se le pasa tipodecontrato?¿Se listan todos por tipo?
public class ListPerTipoContratoAction implements Action {
	private String feedback = "Listados mecánicos por tipo de contrato.";
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	private List<Mecanico> mecanicos;
	@Override
	public void execute() throws Exception {
		//input
		Long idTipo = input.getTipoContratoId();
		//logic
		double totalAcumulado = service.getAcumuladoTipoContrato(idTipo);
		mecanicos = service.ListMecanicosByTipoContrato(idTipo);
		//output
		printer.printMecanicos(mecanicos);
		if(mecanicos.size() == 0)
			printer.print("No hay mecánicos con este tipo de contrato.");
		printer.print("Salario bruto tipo contrato: "+ totalAcumulado);
		printer.print("Numero de mecanicos: "+ mecanicos.size());
		printer.print(feedback);
		logger.info(feedback);
	}
}
