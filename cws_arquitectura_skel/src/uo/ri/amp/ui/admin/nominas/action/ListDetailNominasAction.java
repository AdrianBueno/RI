package uo.ri.amp.ui.admin.nominas.action;

import java.util.Calendar;

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
 * Esta clase mostrar� las n�minas de un mec�nico dado detalladamente
 * Se Presentar�n los datos.
 * mes, total bruto, total neto y desglose por conceptos.
 */
public class ListDetailNominasAction implements Action {
	private String feedback = "N�mina detallada";
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	@Override
	public void execute() throws Exception {
		//input
		Long idMecanico = input.getMecanicoId();
		Integer a�o = input.getYearNomina();
		Integer mes = input.getMonthNomina();
		//logic
		Calendar calendar = Calendar.getInstance();
		calendar.set(a�o, mes, 1);
		Nomina nomina = service.getNomina(idMecanico, calendar.getTime());
		//output
		printer.printNominaDetail(nomina);
		printer.print(feedback);
		logger.info(feedback);
	}
}
