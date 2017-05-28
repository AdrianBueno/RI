package uo.ri.amp.business.impl.admin.categoriasContrato;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.persistence.util.Jpa;

public class AddCategoriaContrato implements Command {
	private CategoriaContrato categoria;
	public AddCategoriaContrato(CategoriaContrato categoria) {
		this.categoria = categoria;
	}
	@Override
	public Object execute() throws BusinessException {
		if(categoria == null)
			throw new BusinessException("La categoria no es válida");
		Jpa.getManager().persist(categoria);
		return null;
	}

}
