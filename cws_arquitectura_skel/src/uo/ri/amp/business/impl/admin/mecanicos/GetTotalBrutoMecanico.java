package uo.ri.amp.business.impl.admin.mecanicos;

import alb.util.date.DateUtil;
import uo.ri.amp.business.asserts.MecanicosAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.persistence.ContratoFinder;
import uo.ri.amp.persistence.MecanicoFinder;

public class GetTotalBrutoMecanico implements Command {
	private Long idMecanico;
	private MecanicosAsserts asserts = AssertsFactory.getMecanicosAsserts();
	public GetTotalBrutoMecanico(Long idMecanico){
		this.idMecanico = idMecanico;
	}
	public Object execute() throws BusinessException {
		Mecanico mecanico = MecanicoFinder.findMecanicoById(idMecanico);
		Contrato contrato = ContratoFinder.findContratoActive(idMecanico);
		asserts.getTotalAcumulado(mecanico, contrato);
		return contrato.getSalarioBrutoAnual(DateUtil.today());
	}

}
