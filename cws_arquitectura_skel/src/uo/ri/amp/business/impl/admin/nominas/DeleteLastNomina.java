package uo.ri.amp.business.impl.admin.nominas;

import uo.ri.amp.business.asserts.ContratosAsserts;
import uo.ri.amp.business.asserts.MecanicosAsserts;
import uo.ri.amp.business.asserts.NominasAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.NominaFinder;
import uo.ri.amp.persistence.util.Jpa;

public class DeleteLastNomina implements Command {

	private Long idMecanico;
	private NominasAsserts asserts = AssertsFactory.getNominasAsserts();
	private MecanicosAsserts assertsM = AssertsFactory.getMecanicosAsserts();
	private ContratosAsserts assertsC = AssertsFactory.getContratosAsserts();
	public DeleteLastNomina(Long idMecanico) {
		this.idMecanico = idMecanico;
	}

	@Override
	public Object execute() throws BusinessException {
		Mecanico mecanico = MecanicoFinder.findMecanicoById(idMecanico);
		assertsM.existMecanico(mecanico);
		Contrato contrato = mecanico.getLastContrato();
		assertsC.existContrato(contrato);
		Long idC = contrato.getId();
		Nomina nomina = NominaFinder.findLastNominaByIdContrato(idC);
		asserts.deleteNomina(nomina);
		Jpa.getManager().remove(nomina);
		return null;
	}
}
