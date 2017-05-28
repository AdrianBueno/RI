package uo.ri.amp.business.impl.admin.mecanicos;

import uo.ri.amp.business.asserts.TiposContratoAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.TipoContratoFinder;

public class ListMecanicosByTipoContrato implements Command {

	private Long idTipo;
	private TiposContratoAsserts asserts;
	public ListMecanicosByTipoContrato(Long idTipoContrato) {
		this.idTipo = idTipoContrato;
		asserts = AssertsFactory.getTiposContratoAsserts();
	}

	@Override
	public Object execute() throws BusinessException {
		TipoContrato tipo = TipoContratoFinder.findTipoContratoById(idTipo);
		asserts.existTipoContrato(tipo);
		return MecanicoFinder.findMecanicosByTipoContrato(tipo.getId());
	}

}
