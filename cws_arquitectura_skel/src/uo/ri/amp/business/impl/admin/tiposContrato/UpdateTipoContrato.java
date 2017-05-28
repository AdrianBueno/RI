package uo.ri.amp.business.impl.admin.tiposContrato;

import uo.ri.amp.business.asserts.TiposContratoAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.persistence.TipoContratoFinder;

public class UpdateTipoContrato implements Command {
	private TipoContrato tipo;
	private TiposContratoAsserts asserts;
	private Long id;
	private Integer dias;
	public UpdateTipoContrato(Long id, Integer dias) {
		this.id = id;
		this.dias = dias;
		asserts = AssertsFactory.getTiposContratoAsserts();
	}
	@Override
	public Object execute() throws BusinessException {
		tipo = TipoContratoFinder.findTipoContratoById(id);
		asserts.updateTipoContrato(tipo, dias);
		tipo.setDiasIndemnizacion(dias);
		return null;
	}

}
