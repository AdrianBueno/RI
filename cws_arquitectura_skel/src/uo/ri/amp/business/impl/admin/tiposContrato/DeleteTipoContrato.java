package uo.ri.amp.business.impl.admin.tiposContrato;

import uo.ri.amp.business.asserts.TiposContratoAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.persistence.TipoContratoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class DeleteTipoContrato implements Command {
	private TiposContratoAsserts asserts;
	private Long idTipo;
	public DeleteTipoContrato(Long idTipo) {
		this.idTipo = idTipo;
		asserts = AssertsFactory.getTiposContratoAsserts();
	}
	@Override
	public Object execute() throws BusinessException {
		TipoContrato tipo = TipoContratoFinder.findTipoContratoById(idTipo);
		asserts.deleteTipoContrato(tipo);
		Jpa.getManager().remove(tipo);
		return null;
	}

}
