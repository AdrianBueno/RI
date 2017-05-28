package uo.ri.amp.business.asserts;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.Nomina;
/**
 * @author Adrian
 * @version 1
 * Esta interfaz desacopla los asserts de Nominas de
 * una implementación específica.
 */
public interface NominasAsserts {
	/**Comprueba si se puede añadir una nomina
	 * @param nomina clase Nomina
	 * @throws BusinessException definida por la implementación.
	 */
	public void addNomina(Nomina nomina) throws BusinessException;
	/**Comprueba si se puede borrar una nomina
	 * @param nomina clase Nomina 
	 * @throws BusinessException definida por la implementación.
	 */
	public void deleteNomina(Nomina nomina) throws BusinessException;
	/**Comprueba si existe una nomina
	 * @param nomina clase Nomina
	 * @throws BusinessException definida por la implementación.
	 */
	public void existNomina(Nomina nomina) throws BusinessException;
}
