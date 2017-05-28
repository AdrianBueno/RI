package uo.ri.amp.business.impl.admin.nominas;

import java.util.Calendar;
import java.util.Date;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.persistence.ContratoFinder;
import uo.ri.amp.persistence.util.Jpa;
import alb.util.date.DateUtil;
/**
 * @author Adrián García Bueno UO232346
 * Uso esta clase para implementar de forma más cómoda el generar nóminas,
 * 
 */
public class GenerateNominas implements Command {
	private Date inicio;
	
	public GenerateNominas(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.today());
		calendar.set(calendar.get(Calendar.YEAR),
				calendar.get(Calendar.MONTH),1);
		inicio = calendar.getTime();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
	}
	@Override
	public Object execute() throws BusinessException {
		for(Contrato contrato : ContratoFinder.findContratosActive()){
			if(contrato.existNomina(inicio) == null){
				Date fecha = DateUtil.today();
				fecha = DateUtil.subDays(fecha, 1);
				fecha = DateUtil.setFirstDayOfMonth(fecha);
				Nomina nomina = contrato.generarNomina(fecha);
				Jpa.getManager().persist(nomina);
			}
		}
		return null;
	}
}
