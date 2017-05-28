package uo.ri.amp.business.impl.admin.tiposContrato;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.persistence.TipoContratoFinder;

public class GetTipoContrato implements Command {

	private Long idTipo;

	public GetTipoContrato(Long idTipo) {
		this.idTipo = idTipo;
	}

	@Override
	public Object execute() throws BusinessException {
		return TipoContratoFinder.findTipoContratoById(idTipo);
	}

}
