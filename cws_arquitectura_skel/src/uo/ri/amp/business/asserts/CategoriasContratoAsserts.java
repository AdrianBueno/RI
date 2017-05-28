package uo.ri.amp.business.asserts;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.CategoriaContrato;
/**
 * @author Adri�n
 * @version 1
 * Esta interfaz desacopla los asserts de categorias de contrato de una
 * implementaci�n espec�fica.
 *
 */
public interface CategoriasContratoAsserts {
	/**Si la categor�a de contrato enviada por par�metro no existe
	 * lanzar� una excepci�n.
	 * @param cat el objeto CategoriaContrato
	 * @throws BusinessException En caso de que el par�metro no exista.
	 */
	public void existCategoriaContrato(CategoriaContrato cat)
										throws BusinessException;

}
