package uo.ri.amp.business.asserts.impl;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.common.model.types.ContratoStatus;
import uo.ri.amp.common.properties.ExceptionStr;
import uo.ri.amp.persistence.CategoriaContratoFinder;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.TipoContratoFinder;
/**
 * @author Adrián Garcia bueno UO232346
 * @version 2
 * Clase obsoleta, sin dependencias a ella en la arquitectura
 * En esta clase se externalizan todos los asserts de la capa de negocio,
 * de esta forma se ahorra en buena medida repetir codigo,
 * y perder tiempo en modificarlo en varios sitios.
 * Esta clase se usaba en versiones anteriores y está obsoleta
 */
@Deprecated
public class BusinessAsserts {
	private BusinessAsserts(){};
	private String errorExist = ExceptionStr.getStr("EXC.EXIST");
	private String errorDelete = ExceptionStr.getStr("EXC.DELETE");
	private String errorActive = ExceptionStr.getStr("EXC.ACTIVE");
	private String errorValue = ExceptionStr.getStr("EXC.VALUE");
	
	public void assertExist(Object object) throws BusinessException{
		if(object == null)
			throw new BusinessException(errorExist);
	}
	
	//Mecanicos
	/**Determina si el Dni de un mecánico ya existe
	 * En caso contrario lanza una excepción
	 * @param mecanico a determinar
	 * @throws BusinessException si el dni ya pertenece a un mecanico.
	 */
	public void assertExistDni(Mecanico mecanico) throws BusinessException{
		assertExist(mecanico);
		if(MecanicoFinder.findMecanicoByDni(mecanico.getDni()) != null)
			throw new BusinessException(errorValue);
	}
	/**Determina si un mecanico se puede borrar
	 * En caso contrario lanza una excepción
	 * @param mecanico a determinar
	 * @throws BusinessException si el mecanico tiene dependencias.
	 */
	public void assertDelete(Mecanico mecanico) throws BusinessException{
		assertExist(mecanico);
		if(mecanico.getIntervenciones().size() > 0
				|| mecanico.getAverias().size() > 0
				|| mecanico.getContratos().size() > 0)
			throw new BusinessException(errorDelete);
	}
	
	//Contrato
	public void assertActive(Contrato contrato) throws BusinessException{
		assertExist(contrato);
		if(contrato.getEstado() == ContratoStatus.EXTINTO)
			throw new BusinessException(errorActive);
	}
	/**Determina si se puede borrar un contrato
	 * @param contrato a determinar
	 * @throws BusinessException si el contrato tiene dependencias
	 */
	public void assertDelete(Contrato contrato) throws BusinessException{
		assertExist(contrato);
		if(contrato.getMecanico().getAverias().size() > 0 
				|| contrato.getMecanico().getIntervenciones().size() > 0 
				|| contrato.getNominas().size() > 0)
			throw new BusinessException(errorDelete);
	}
	
	//TipoContrato
	/**Determina si ya existe el nombre de un tipo de contrato en el sistema.
	 * @param tipo a determinar
	 * @throws BusinessException si el nombre ya está siendo usado.
	 */
	public void assertExistNombre(TipoContrato tipo) throws BusinessException{
		assertExist(tipo);
		if(TipoContratoFinder.findTipoContratoByName(tipo.getNombre()) != null)
			throw new BusinessException(errorValue);
	}
	/**Determian si un tipo de contrato dado se puede borrar
	 * @param tipo a determinar
	 * @throws BusinessException si existen contratos de este tipo de contrato
	 */
	public void assertDelete(TipoContrato tipo) throws BusinessException{
		assertExist(tipo);
		if(tipo.getContratos().size() > 0)
			throw new BusinessException(errorDelete);
	}
	
	//Categorias

	/**Determina si existe el nombre de una categoria de contrato
	 * @param categoria a determinar
	 * @throws BusinessException si el nombre ya está siendo usado.
	 */
	public void assertExistNombre(CategoriaContrato categoria)
	throws BusinessException{
		assertExist(categoria);
		String name = categoria.getNombre();
		if(CategoriaContratoFinder.findCategoriaContratoByName(name) != null)
			throw new BusinessException(errorValue);
	}
	/**Determina si se puede borrar una categoria
	 * @param categoriaContrato a determinar
	 * @throws BusinessException si la categoria tiene dependencias
	 */
	public void assertDelete(CategoriaContrato categoriaContrato)
	throws BusinessException{
		if(categoriaContrato.getContratos().size() > 0)
			throw new BusinessException(errorDelete);
	}

}
