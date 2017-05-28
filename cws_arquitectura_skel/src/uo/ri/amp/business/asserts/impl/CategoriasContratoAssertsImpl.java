package uo.ri.amp.business.asserts.impl;

import uo.ri.amp.business.asserts.CategoriasContratoAsserts;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.CategoriaContrato;

/**
 * @author Adrian
 * @version 1
 * Esta case es una implementación genérica de la interfaz 
 * 'CategoriasContratoAsserts'
 * Puede ser sustituida por otra implementación fácilmente.
 */
public class CategoriasContratoAssertsImpl implements CategoriasContratoAsserts{

	@Override
	public void existCategoriaContrato(CategoriaContrato cat) 
										throws BusinessException {
		AssertsExist.CategoriaExist(cat);
		
	}

}
