package uo.ri.amp.ui.admin.nominas.action;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.input.InputData;
import uo.ri.amp.common.io.output.PrinterData;
import uo.ri.amp.common.model.Nomina;
import alb.util.log.Logger;
import alb.util.menu.Action;

/**
 * @author Adrian Garcia Bueno UO232346
 * @version 1
 * Lista todas las nóminas de un mecánico dado
 * Presentará los datos:
 * Mes, total neto percibido.
 */
public class ListGeneralNominasAction implements Action {
	private String feedback = "Nóminas listadas: ";
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
		Long idMecanico = input.getMecanicoId();
		//logic
		List<Nomina> nominas = service.listNominasByMecanico(idMecanico);
		//output
		printer.printNominas(nominas);
		printer.print(feedback+nominas.size());
		logger.info(feedback+nominas.size());
	}

}
