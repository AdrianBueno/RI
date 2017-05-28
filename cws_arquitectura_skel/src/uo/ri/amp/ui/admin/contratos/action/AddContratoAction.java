/*
 * AddContratoAction.java 3
 * Adri�n Garc�a Bueno 
 * uo232346@uniovi.es
 */
package uo.ri.amp.ui.admin.contratos.action;

import java.util.Date;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.factories.IoFactory;
import uo.ri.amp.common.io.input.InputData;
import uo.ri.amp.common.io.output.PrinterData;
import uo.ri.amp.common.model.Contrato;
import alb.util.log.Logger;
import alb.util.menu.Action;

/**
 * Esta clase implementa una acci�n sobre la interfaz de servicio
 * de administrador.
 * uo.ri.amp.ui.admin.contratos.action AddContratoAction
 * @version 3 20/12/2014
 * @author Adri�n
 */
public class AddContratoAction implements Action {
	private String feedback = "Contrato a�adido.";
	private Contrato contrato;
	private AdminService service = BusinessFactory.getAdminService();
	private InputData input = IoFactory.getInputData();
	private PrinterData printer = IoFactory.getPrinterData();
	private Logger logger = IoFactory.getLogger();
	
	@Override
	public void execute() throws Exception {
		//input
		Double salario =	input.getSalarioAnual();
		Date fechaInicio = 	input.getFechaInicio();
		Date fechaFin = 	input.getFechaFin();
		Long idMecanico = 	input.getMecanicoId();
		Long idTipo = 		input.getTipoContratoId();
		Long idCategoria = input.getCategoriaContratoId();
		contrato = new Contrato(salario,fechaInicio,fechaFin);
		//logic
		service.addContrato(contrato, idMecanico, idTipo, idCategoria);
		//output
		printer.print(feedback);
		logger.info(feedback);
	}
}
