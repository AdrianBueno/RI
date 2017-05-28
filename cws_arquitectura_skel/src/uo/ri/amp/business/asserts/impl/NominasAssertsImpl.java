package uo.ri.amp.business.asserts.impl;

import uo.ri.amp.business.asserts.NominasAsserts;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.Nomina;
/**
 * @author Adrián
 * @version 2
 * Esta case es una implementación genérica de la interfaz 'NominasAsserts'
 * Puede ser sustituida por otra implementación fácilmente.
 */
public class NominasAssertsImpl implements NominasAsserts {

	@Override
	public void addNomina(Nomina nomina) throws BusinessException {
		if(nomina == null)
			throw new BusinessException("Error al crear la Nómina");
		//No uso AssertsExist porque tienen objetivos diferentes.
	}

	@Override
	public void deleteNomina(Nomina nomina) throws BusinessException {
		AssertsExist.NominaExist(nomina);
		
	}

	@Override
	public void existNomina(Nomina nomina) throws BusinessException {
		AssertsExist.NominaExist(nomina);
	}

}
