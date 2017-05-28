package uo.ri.amp.business.impl.admin.contratos;

import uo.ri.amp.business.asserts.ContratosAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.persistence.CategoriaContratoFinder;
import uo.ri.amp.persistence.ContratoFinder;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.TipoContratoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class AddContrato implements Command {
	private Contrato contrato;
	private Long idMecanico;
	private Long idTipo;
	private Long idCategoria;
	private ContratosAsserts asserts = AssertsFactory.getContratosAsserts();
	
	public AddContrato(Contrato contrato, Long idMecanico, Long idTipo,
			Long idCategoria) {
		this.contrato = contrato;
		this.idMecanico = idMecanico;
		this.idTipo = idTipo;
		this.idCategoria = idCategoria;
	}
	@Override
	public Object execute() throws BusinessException {
		Mecanico mecanico = MecanicoFinder.findMecanicoById(idMecanico);
		TipoContrato tipo = TipoContratoFinder.findTipoContratoById(idTipo);
		CategoriaContrato categoria=CategoriaContratoFinder
				.findCategoriaContratoById(idCategoria);
		
		asserts.addContrato(contrato, tipo, mecanico, categoria);
		
		mecanico.addContrato(contrato);
		tipo.addContrato(contrato);
		categoria.addContrato(contrato);
		
		//Finalizar contrato existe si existe
		Contrato oldContrato = ContratoFinder.findContratoActive(idMecanico);
		if(oldContrato != null){
			asserts.finalizeContrato(oldContrato);
			oldContrato.finalizeContrato();
		}
		//Hago a contrato persistente.
		Jpa.getManager().persist(contrato);
		return null;
	}

}
