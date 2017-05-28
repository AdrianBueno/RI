package uo.ri.amp.business.impl.admin.nominas;

import uo.ri.amp.business.asserts.NominasAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.persistence.NominaFinder;

public class GetNomina implements Command {
	private NominasAsserts asserts = AssertsFactory.getNominasAsserts();
	private Long idNomina;
	
	public GetNomina(Long idNomina) {
		this.idNomina = idNomina;
	}
	@Override
	public Object execute() throws BusinessException {
		Nomina nomina = NominaFinder.findNominaById(idNomina);
		asserts.existNomina(nomina);
		return nomina;
	}

}
