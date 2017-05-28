package uo.ri.amp.business.impl.admin.contratos;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.persistence.ContratoFinder;

public class GetContrato implements Command {
	
	private Long idContrato;

	public GetContrato(Long idContrato) {
		this.idContrato = idContrato;
	}

	@Override
	public Object execute() throws BusinessException {
		Contrato contrato = ContratoFinder.findContratoById(idContrato);
		//¿Tengo aquí contexto para hacer un exception en caso de que sea null?
		return contrato;
	}

}
