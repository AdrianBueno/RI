package uo.ri.amp.business.asserts;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.TipoContrato;
/**
 * @author Adri�n
 * @version 1
 * Esta interfaz desacopla los asserts de tipos de contrato de
 * una implementaci�n espec�fica.
 */
public interface TiposContratoAsserts {
	/**Comprueba si se puede a�adir un tipo de contrato
	 * @param tipo clase TipoContrato
	 * @throws BusinessException definida por la implementaci�n.
	 */
	public void addTipoContrato(TipoContrato tipo)throws BusinessException;
	/**Comprueba si se puede modificar un tipo de contrato.
	 * @param tipo clase TipoContrato
	 * @param dias dias de indemnizaci�n nuevos.
	 * @throws BusinessException definida por la implementaci�n.
	 */
	public void updateTipoContrato(TipoContrato tipo,Integer dias)
	throws BusinessException;
	/**Comprueba si se puede borrar un tipo de contrato.
	 * @param tipo TipoContrato
	 * @throws BusinessException definida por la implementaci�n.
	 */
	public void deleteTipoContrato(TipoContrato tipo)throws BusinessException;
	/**Se encarga de comprobar si existe un tipo de contrato
	 * @param tipo clase TipoContrato
	 * @throws BusinessException definida por la implementaci�n.
	 */
	public void existTipoContrato(TipoContrato tipo)throws BusinessException;
}
