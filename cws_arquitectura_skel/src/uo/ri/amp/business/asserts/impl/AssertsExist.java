package uo.ri.amp.business.asserts.impl;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.common.model.TipoContrato;
/**
 * @author Adri�n
 * @version 1
 * Clase de implementaci�n fuera de la aquitectura.
 * Clase para centralizar las comprobaciones de existencia desde las clases
 * de AssertsBusiness, visibilidad de paquetes por ello, esta clase
 * es de implementaci�n y solo se deben crear dependencias a ellas desde
 * las clases del mismo paquete que esta.
 * Esta clase fue hecha para evitar el copiar y pegar c�digo.
 */
class AssertsExist {
	private AssertsExist(){}
	public static void ContratoExist(Contrato contrato) 
			throws BusinessException{
		if(contrato == null)
			throw new BusinessException("El contrato no existe");
	}
	public static void MecanicoExist(Mecanico mecanico) 
			throws BusinessException{
		if(mecanico == null)
			throw new BusinessException("El mec�nico no existe");
	}
	public static void TipoExist(TipoContrato tipo) 
			throws BusinessException{
		if(tipo == null)
			throw new BusinessException("El tipo de contrato no existe");
	}
	public static void CategoriaExist(CategoriaContrato cat) 
			throws BusinessException{
		if(cat == null)
			throw new BusinessException("La categor�a de contrato no existe");
	}
	public static void NominaExist(Nomina nomina) 
			throws BusinessException{
		if(nomina == null)
			throw new BusinessException("La n�mina no existe");
	}

}
