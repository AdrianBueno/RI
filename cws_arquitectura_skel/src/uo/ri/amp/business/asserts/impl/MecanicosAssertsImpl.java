package uo.ri.amp.business.asserts.impl;

import uo.ri.amp.business.asserts.MecanicosAsserts;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.persistence.MecanicoFinder;

/**
 * @author Adrian
 * @version 1
 * Esta case es una implementación genérica de la interfaz 'MecanicosAsserts'
 * Puede ser sustituida por otra implementación fácilmente.
 */
public class MecanicosAssertsImpl implements MecanicosAsserts {
	private String errorDni = "Este dni ya pertenece a otro mecánico";
	private String errorDelete = 
			"El mecánico no puede ser borrado porque tiene dependencias";
	@Override
	public void addMecanico(Mecanico mecanico) throws BusinessException {
		AssertsExist.MecanicoExist(mecanico);
		String dni = mecanico.getDni();
		if(MecanicoFinder.findMecanicoByDni(dni) != null)
			throw new BusinessException(errorDni);
	}

	@Override
	public void updateMecanico(Mecanico mecanico) throws BusinessException {
		AssertsExist.MecanicoExist(mecanico);
	}

	@Override
	public void deleteMecanico(Mecanico mecanico) throws BusinessException {
		AssertsExist.MecanicoExist(mecanico);
		if(mecanico.getIntervenciones().size() > 0
				|| mecanico.getAverias().size() > 0
				|| mecanico.getContratos().size() > 0)
			throw new BusinessException(errorDelete);
	}

	@Override
	public void getTotalAcumulado(Mecanico mecanico, Contrato contrato)
			throws BusinessException {
		AssertsExist.MecanicoExist(mecanico);
		AssertsExist.ContratoExist(contrato);
	}

	@Override
	public void existMecanico(Mecanico mecanico) throws BusinessException {
		AssertsExist.MecanicoExist(mecanico);
	}

}
