package uo.ri.amp.business.asserts.impl;

import uo.ri.amp.business.asserts.NominasAsserts;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.Nomina;
/**
 * @author Adri�n
 * @version 2
 * Esta case es una implementaci�n gen�rica de la interfaz 'NominasAsserts'
 * Puede ser sustituida por otra implementaci�n f�cilmente.
 */
public class NominasAssertsImpl implements NominasAsserts {

	@Override
	public void addNomina(Nomina nomina) throws BusinessException {
		if(nomina == null)
			throw new BusinessException("Error al crear la N�mina");
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
