package uo.ri.amp.business.impl.admin.mecanicos;

import uo.ri.amp.business.asserts.MecanicosAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.persistence.util.Jpa;

public class AddMecanico implements Command {
	private MecanicosAsserts asserts = AssertsFactory.getMecanicosAsserts();
	private Mecanico mecanico;
	public AddMecanico(Mecanico mecanico){
		this.mecanico = mecanico;
	}
	@Override
	public Object execute() throws BusinessException {
		asserts.addMecanico(mecanico);
		Jpa.getManager().persist(mecanico);
		return null;
	}

}
