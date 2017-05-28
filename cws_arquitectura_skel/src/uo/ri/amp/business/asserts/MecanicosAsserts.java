package uo.ri.amp.business.asserts;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
/**
 * @author Adri�n
 * @version 2
 * Esta interfaz desacopla los asserts de Mecanicos
 *  de una implementaci�n espec�fica.
 */
public interface MecanicosAsserts {
	/**Comrpueba si se cumplen las condiciones para a�adir un nuevo mec�nico.
	 * @param mecanico clase Mecanico
	 * @throws BusinessException definida por la implementaci�n.
	 */
	public void addMecanico(Mecanico mecanico) throws BusinessException;
	/**Comrpueba si se cumplen las condiciones para
	 *  actualizar un nuevo mec�nico.
	 * @param mecanico clase Mecanico
	 * @throws BusinessException definida por la implementaci�n.
	 */
	public void updateMecanico(Mecanico mecanico) throws BusinessException;
	/**Comprueba si se cumplen las condiciones para borrar un mec�nico.
	 * @param mecanico clase Mecanico
	 * @throws BusinessException definida por la implementaci�n.
	 */
	public void deleteMecanico(Mecanico mecanico) throws BusinessException;
	/**Comprueba si se cumplen las condiciones para llevar a cabo la acci�n
	 * de obtener el total acumulado.
	 * @param mecanico clase Mecanico
	 * @param contrato clase Contrato
	 * @throws BusinessException definida por la implementaci�n.
	 */
	public void getTotalAcumulado(Mecanico mecanico, Contrato contrato)
									throws BusinessException;
	/**Comprueba si existe un mecanico 
	 * @param mecanico clase Mecanico
	 * @throws BusinessException definida por la implementaci�n.
	 */
	public void existMecanico(Mecanico mecanico) throws BusinessException;
}
