package uo.ri.amp.business.impl.admin.categoriasContrato;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.persistence.CategoriaContratoFinder;

public class GetCategoriaContratoById implements Command {

	private Long idCategoria;
	public GetCategoriaContratoById(Long idCategoriaContrato) {
		this.idCategoria = idCategoriaContrato;
	}

	@Override
	public Object execute() throws BusinessException {
		CategoriaContrato cat;
		cat = CategoriaContratoFinder.findCategoriaContratoById(idCategoria);
		return cat;
	}

}
