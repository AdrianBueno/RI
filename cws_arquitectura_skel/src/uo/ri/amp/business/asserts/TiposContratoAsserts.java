package uo.ri.amp.business.asserts;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.TipoContrato;
/**
 * @author Adrián
 * @version 1
 * Esta interfaz desacopla los asserts de tipos de contrato de
 * una implementación específica.
 */
public interface TiposContratoAsserts {
	/**Comprueba si se puede añadir un tipo de contrato
	 * @param tipo clase TipoContrato
	 * @throws BusinessException definida por la implementación.
	 */
	public void addTipoContrato(TipoContrato tipo)throws BusinessException;
	/**Comprueba si se puede modificar un tipo de contrato.
	 * @param tipo clase TipoContrato
	 * @param dias dias de indemnización nuevos.
	 * @throws BusinessException definida por la implementación.
	 */
	public void updateTipoContrato(TipoContrato tipo,Integer dias)
	throws BusinessException;
	/**Comprueba si se puede borrar un tipo de contrato.
	 * @param tipo TipoContrato
	 * @throws BusinessException definida por la implementación.
	 */
	public void deleteTipoContrato(TipoContrato tipo)throws BusinessException;
	/**Se encarga de comprobar si existe un tipo de contrato
	 * @param tipo clase TipoContrato
	 * @throws BusinessException definida por la implementación.
	 */
	public void existTipoContrato(TipoContrato tipo)throws BusinessException;
}
