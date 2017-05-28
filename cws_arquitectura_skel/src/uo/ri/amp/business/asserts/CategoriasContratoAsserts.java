package uo.ri.amp.business.asserts;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.CategoriaContrato;
/**
 * @author Adrián
 * @version 1
 * Esta interfaz desacopla los asserts de categorias de contrato de una
 * implementación específica.
 *
 */
public interface CategoriasContratoAsserts {
	/**Si la categoría de contrato enviada por parámetro no existe
	 * lanzará una excepción.
	 * @param cat el objeto CategoriaContrato
	 * @throws BusinessException En caso de que el parámetro no exista.
	 */
	public void existCategoriaContrato(CategoriaContrato cat)
										throws BusinessException;

}
