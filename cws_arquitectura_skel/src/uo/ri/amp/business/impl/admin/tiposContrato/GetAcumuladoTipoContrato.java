package uo.ri.amp.business.impl.admin.tiposContrato;

import java.util.List;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.persistence.ContratoFinder;
import uo.ri.amp.persistence.MecanicoFinder;

public class GetAcumuladoTipoContrato implements Command {

	private Long idTipo;
	private List<Mecanico> mecanicos;
	public GetAcumuladoTipoContrato(Long idTipo) {
		this.idTipo = idTipo;
	}

	@Override
	public Object execute() throws BusinessException {
		 mecanicos = MecanicoFinder.findMecanicosByTipoContrato(idTipo);
		 Double acum = 0.0;
		 for(Mecanico mecanico :mecanicos){
			 Contrato contrato = ContratoFinder.findContratoActive(mecanico.getId());
			 if(contrato != null)
				 acum += getBrutoNominas(contrato);
		 }
		return acum;
	}
	private Double getBrutoNominas(Contrato contrato){
		Double acum=0.0;
		for(Nomina nomina : contrato.getNominas()){
			 acum += nomina.getSalarioBruto();
		 }
		return acum;
	}

}
