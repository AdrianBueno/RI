package uo.ri.amp.business.asserts.impl;

import uo.ri.amp.business.asserts.TiposContratoAsserts;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.persistence.TipoContratoFinder;

/**
 * @author Adrian
 * @version 1
 * Esta case es una implementación genérica de la interfaz 
 * 'TiposContratoAsserts'
 * Puede ser sustituida por otra implementación fácilmente
 */
public class TiposContratoAssertsImpl implements TiposContratoAsserts {
	private String errorName = 
			"Este nombre ya pertenece a otro tipo de contrato";
	private String errorDelete = 
			"El tipo de contrato no puede ser eliminado"
			+ " porque tiene dependencias";
	private String errorDias = "Los dias de indemnización debe ser un valor"
			+ "mayor que 0 y menor que 365";
	@Override
	public void addTipoContrato(TipoContrato tipo) throws BusinessException {
		String name = tipo.getNombre();
		if(TipoContratoFinder.findTipoContratoByName(name) != null)
			throw new BusinessException(errorName);
		Integer dias = tipo.getDiasIndemnizacion();
		if(dias == null ||dias <= 0 || dias > 365)
			throw new BusinessException(errorDias);
	}

	@Override
	public void updateTipoContrato(TipoContrato tipo,Integer dias)throws BusinessException {
		AssertsExist.TipoExist(tipo);
		if(dias == null || dias <= 0 || dias > 365)
			throw new BusinessException(errorDias);
	}

	@Override
	public void deleteTipoContrato(TipoContrato tipo)throws BusinessException {
		AssertsExist.TipoExist(tipo);
		if(tipo.getContratos().size() > 0)
			throw new BusinessException(errorDelete);
	}

	@Override
	public void existTipoContrato(TipoContrato tipo)throws BusinessException {
		AssertsExist.TipoExist(tipo);
	}

}
