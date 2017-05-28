package uo.ri.amp.business.impl.admin.contratos;

import uo.ri.amp.business.asserts.ContratosAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.persistence.ContratoFinder;

public class FinalizeContrato implements Command {
	private Long idContrato;
	private ContratosAsserts asserts = AssertsFactory.getContratosAsserts();
	public FinalizeContrato(Long idContrato) {
		this.idContrato = idContrato;
	}
	//Se busca el contrato y se comprueban sus condiciones de finalización
	@Override
	public Object execute() throws BusinessException {
		Contrato contrato = ContratoFinder.findContratoById(idContrato);
		asserts.finalizeContrato(contrato);
		contrato.finalizeContrato();
		return contrato; //Devuelvo el contrato por si se quiere visualizar
	}

}
