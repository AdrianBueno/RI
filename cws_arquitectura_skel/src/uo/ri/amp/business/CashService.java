package uo.ri.amp.business;

import java.util.List;
import java.util.Map;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.Averia;
import uo.ri.amp.common.model.Factura;
import uo.ri.amp.common.model.MedioPago;

public interface CashService {

	Factura createInvoiceFor(List<Long> idsAveria) throws BusinessException;
	Factura findInvoice(Long numeroFactura) throws BusinessException;
	List<MedioPago> findPayMethodsForInvoice(Long idFactura)
			throws BusinessException;
	void settleInvoice(Long idFactura, Map<Long, Double> cargos) 
			throws BusinessException;

	List<Averia> findRepairsByClient(String dni) throws BusinessException;
	
	// resto de métodos que faltan...

}
