package uo.ri.amp.business.impl.admin.tiposContrato;

import uo.ri.amp.business.asserts.TiposContratoAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.persistence.util.Jpa;

public class AddTipoContrato implements Command {

	private TipoContrato tipo;
	private TiposContratoAsserts asserts;
	public AddTipoContrato(TipoContrato tipoContrato) {
		this.tipo = tipoContrato;
		asserts = AssertsFactory.getTiposContratoAsserts();
	}

	@Override
	public Object execute() throws BusinessException {
		asserts.addTipoContrato(tipo);
		Jpa.getManager().persist(tipo);
		return null;
	}

}
