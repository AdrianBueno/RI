package uo.ri.amp.business.asserts;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.TipoContrato;
/**
 * @author Adrián
 * @version 1
 * Esta interfaz desacopla los asserts de contrato de una
 * implementación específica.
 *
 */
public interface ContratosAsserts {
	/**Se encarga de de comprobar si se cumplen las condiciones necesarias
	 * para añadir un nuevo contrato en base a los objetos necesarios para ello.
	 * @param contrato clase Contrato
	 * @param tipo clase TipoContrato
	 * @param mecanico clase Mecanico
	 * @param categoria clase CategoriaContrato
	 * @throws BusinessException definida por la implementación.
	 */
	public void addContrato(Contrato contrato,
							TipoContrato tipo,
							Mecanico mecanico,
							CategoriaContrato categoria)
							throws BusinessException;
	/**Se encarga de de comprobar si se cumplen las condiciones necesarias
	 * para actualizar un nuevo contrato
	 * en base a los objetos necesarios para ello.
	 * @param contrato clase Contrato
	 * @param tipo clase TipoContrato
	 * @param categoria clase CategoriaContrato
	 * @throws BusinessException definida por la implementación.
	 */
	public void updateContrato(Contrato contrato,
							   TipoContrato tipo,
							   CategoriaContrato categoria)
							   throws BusinessException;
	/**Se encarga de comprobar si se cumplemen las condiciones necesarias
	 * para eliminar un contrato.
	 * @param contrato clase Contrato, objeto a eliminar
	 * @throws BusinessException definida por la implementaciòn.
	 */
	public void deleteContrato(Contrato contrato) throws BusinessException;
	/**Comprueba si existe un contrato
	 * @param contrato clase Contrato
	 * @throws BusinessException definida por la implementación.
	 */
	public void existContrato(Contrato contrato) throws BusinessException;
	/**Comrpueba si un contrato está activo
	 * @param contrato clase Contrato
	 * @throws BusinessException definida por la implementación.
	 */
	public void activeContrato(Contrato contrato) throws BusinessException;
	/**Comprueba si se cumplen las condiciones para finalizar un contrato
	 * @param contrato clase Contrato
	 * @throws BusinessException definida por la implementación.
	 */
	public void finalizeContrato(Contrato contrato) throws BusinessException;
}
