package uo.ri.amp.business.impl.admin.contratos;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.persistence.ContratoFinder;

public class ListContratos implements Command {

	@Override
	public Object execute() throws BusinessException {
		return ContratoFinder.findContratosActive();
	}

}
