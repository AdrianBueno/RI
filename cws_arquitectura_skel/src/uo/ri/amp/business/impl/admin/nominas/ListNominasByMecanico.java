package uo.ri.amp.business.impl.admin.nominas;

import uo.ri.amp.business.asserts.MecanicosAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.NominaFinder;

public class ListNominasByMecanico implements Command {

	private Long idMecanico;
	private MecanicosAsserts asserts = AssertsFactory.getMecanicosAsserts();
	public ListNominasByMecanico(Long idMecanico) {
		this.idMecanico = idMecanico;
	}

	@Override
	public Object execute() throws BusinessException {
		Mecanico mecanico = MecanicoFinder.findMecanicoById(idMecanico);
		asserts.existMecanico(mecanico);
		return NominaFinder.findNominasByMecanico(idMecanico);
	}

}
