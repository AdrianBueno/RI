package uo.ri.amp.business.asserts.impl;

import uo.ri.amp.business.asserts.ContratosAsserts;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.common.model.types.ContratoStatus;
/**
 * @author Adrián
 * @version 2
 * Clase de implementación fuera de la arquitecutra
 * Implementación de la interfaz ContratosAsserts.
 * El objetivo de esta clase es poder desacoplar las condiciones de ciertas
 * acciones de la capa de negocio, actualmente la implementación es muy básica
 * pero podría ser ampliada fácilmente en caso de necesitar funcionalidad 
 * nueva.
 */

public class ContratosAssertsImpl implements ContratosAsserts {
	private String errorDelete = 
			"El contrato no puede ser eliminado porque tiene dependencias";
	@Override
	public void addContrato(Contrato contrato,
							TipoContrato tipo,
							Mecanico mecanico, 
							CategoriaContrato categoria)
							throws BusinessException {
		AssertsExist.ContratoExist(contrato);
		AssertsExist.MecanicoExist(mecanico);
		AssertsExist.TipoExist(tipo);
		AssertsExist.CategoriaExist(categoria);
	}

	@Override
	public void updateContrato(Contrato contrato, TipoContrato tipo,
							   CategoriaContrato categoria) 
							   throws BusinessException {
		AssertsExist.ContratoExist(contrato);
		AssertsExist.TipoExist(tipo);
		AssertsExist.CategoriaExist(categoria);
		activeContrato(contrato);
	}

	@Override
	public void deleteContrato(Contrato contrato) throws BusinessException {
		AssertsExist.ContratoExist(contrato);
		if(contrato.getMecanico().getAverias().size() > 0 
				|| contrato.getMecanico().getIntervenciones().size() > 0 
				|| contrato.getNominas().size() > 0)
			throw new BusinessException(errorDelete);
	}

	@Override
	public void existContrato(Contrato contrato) throws BusinessException {
		AssertsExist.ContratoExist(contrato);
	}

	@Override
	public void activeContrato(Contrato contrato) throws BusinessException {
		AssertsExist.ContratoExist(contrato);
		if(contrato.getEstado() == ContratoStatus.EXTINTO)
			throw new BusinessException("El contrato está extinto");
	}

	@Override
	public void finalizeContrato(Contrato contrato) throws BusinessException {
		AssertsExist.ContratoExist(contrato);
		if(contrato.getEstado() == ContratoStatus.EXTINTO)
			throw new BusinessException("El contrato no se puede finalizar,"
					+ " porque ya estaba finalizado.");
	}

}
