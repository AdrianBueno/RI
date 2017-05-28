package uo.ri.amp.business.impl.admin.contratos;

import uo.ri.amp.business.asserts.ContratosAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.persistence.CategoriaContratoFinder;
import uo.ri.amp.persistence.ContratoFinder;
import uo.ri.amp.persistence.TipoContratoFinder;

public class UpdateContrato implements Command {

	private Long idContrato;
	private Long idCategoria;
	private Long idTipo;
	private ContratosAsserts asserts = AssertsFactory.getContratosAsserts();
	private Double salario;

	public UpdateContrato(Long idCon, Long idCat, Long idTipo, Double sal) {
		this.idContrato = idCon;
		this.idCategoria = idCat;
		this.idTipo = idTipo;
		this.salario = sal;
	}

	@Override
	public Object execute() throws BusinessException {
		Contrato contrato = ContratoFinder.findContratoById(idContrato);
		TipoContrato tipo = TipoContratoFinder.findTipoContratoById(idTipo);
		CategoriaContrato categoria = 
				CategoriaContratoFinder.findCategoriaContratoById(idCategoria);
		asserts.updateContrato(contrato, tipo, categoria);
		contrato.getTipoContrato().removeContrato(contrato);
		contrato.getCategoriaContrato().removeContrato(contrato);
		tipo.addContrato(contrato);
		categoria.addContrato(contrato);
		contrato.setSalarioBaseAnual(salario);
		return null;
	}

}
