package uo.ri.amp.business.asserts;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
/**
 * @author Adrián
 * @version 2
 * Esta interfaz desacopla los asserts de Mecanicos
 *  de una implementación específica.
 */
public interface MecanicosAsserts {
	/**Comrpueba si se cumplen las condiciones para añadir un nuevo mecánico.
	 * @param mecanico clase Mecanico
	 * @throws BusinessException definida por la implementación.
	 */
	public void addMecanico(Mecanico mecanico) throws BusinessException;
	/**Comrpueba si se cumplen las condiciones para
	 *  actualizar un nuevo mecánico.
	 * @param mecanico clase Mecanico
	 * @throws BusinessException definida por la implementación.
	 */
	public void updateMecanico(Mecanico mecanico) throws BusinessException;
	/**Comprueba si se cumplen las condiciones para borrar un mecánico.
	 * @param mecanico clase Mecanico
	 * @throws BusinessException definida por la implementación.
	 */
	public void deleteMecanico(Mecanico mecanico) throws BusinessException;
	/**Comprueba si se cumplen las condiciones para llevar a cabo la acción
	 * de obtener el total acumulado.
	 * @param mecanico clase Mecanico
	 * @param contrato clase Contrato
	 * @throws BusinessException definida por la implementación.
	 */
	public void getTotalAcumulado(Mecanico mecanico, Contrato contrato)
									throws BusinessException;
	/**Comprueba si existe un mecanico 
	 * @param mecanico clase Mecanico
	 * @throws BusinessException definida por la implementación.
	 */
	public void existMecanico(Mecanico mecanico) throws BusinessException;
}
