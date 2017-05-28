package uo.ri.amp.business.impl.admin.nominas;

import java.util.Date;

import uo.ri.amp.business.asserts.MecanicosAsserts;
import uo.ri.amp.business.asserts.NominasAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.NominaFinder;

public class GetNominaByDate implements Command {

	private Long idMecanico;
	private Date fecha;
	private NominasAsserts asserts = AssertsFactory.getNominasAsserts();
	private MecanicosAsserts assertsM = AssertsFactory.getMecanicosAsserts();
	public GetNominaByDate(Long idMecanico, Date fecha) {
		this.idMecanico = idMecanico;
		this.fecha = fecha;
	}

	@Override
	public Object execute() throws BusinessException {
		Mecanico mecanico = MecanicoFinder.findMecanicoById(idMecanico);
		assertsM.existMecanico(mecanico);
		Nomina nomina;
		nomina = NominaFinder.findNominaByMecanicoAndDate(idMecanico, fecha);
		asserts.existNomina(nomina);
		return nomina;
	}

}
