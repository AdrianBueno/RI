package uo.ri.amp.business.impl.admin.mecanicos;

import uo.ri.amp.business.asserts.MecanicosAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class DeleteMecanico implements Command {
	private MecanicosAsserts asserts = AssertsFactory.getMecanicosAsserts();
	private Long idMecanico;
	public DeleteMecanico(Long idMecanico) {
		this.idMecanico = idMecanico;
	}
	@Override
	public Object execute() throws BusinessException {
		Mecanico mecanico = MecanicoFinder.findMecanicoById(idMecanico);
		asserts.deleteMecanico(mecanico);
		Jpa.getManager().remove(mecanico);
		return null;
	}

}
