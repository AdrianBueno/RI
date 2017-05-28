package uo.ri.amp.business.impl.admin.mecanicos;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.persistence.MecanicoFinder;

public class GetMecanico implements Command {

	private Long idMecanico;

	public GetMecanico(Long id) {
		this.idMecanico = id;
	}

	@Override
	public Object execute() throws BusinessException {
		Mecanico mecanico = MecanicoFinder.findMecanicoById(idMecanico);
		return mecanico;
	}

}
