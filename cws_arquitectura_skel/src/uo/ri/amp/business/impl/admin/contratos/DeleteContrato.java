package uo.ri.amp.business.impl.admin.contratos;

import uo.ri.amp.business.asserts.ContratosAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.persistence.ContratoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class DeleteContrato implements Command {
	private Long idContrato;
	private ContratosAsserts asserts = AssertsFactory.getContratosAsserts();

	public DeleteContrato(Long idContrato) {
		this.idContrato = idContrato;
	}
	//Simplemente buscamos el contrato y probamos las condiciones de borrado
	@Override
	public Object execute() throws BusinessException {
		Contrato contrato = ContratoFinder.findContratoById(idContrato);
		asserts.deleteContrato(contrato);
		Jpa.getManager().remove(contrato);
		return null;
	}

}
