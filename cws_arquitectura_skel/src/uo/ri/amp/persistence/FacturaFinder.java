package uo.ri.amp.persistence;

import uo.ri.amp.common.model.Factura;
import uo.ri.amp.persistence.util.Jpa;
/**
 * Se encarga de acceder a las facturas del modelo de dominio
 * @author Adrián
 *
 */
public class FacturaFinder {
	/**Obtiene una factura a traves de un numero de factura
	 * @param numero identificador 
	 * @return Factura objeto factura-
	 */
	public static Factura findByNumber(Long numero) {	
		return null;
	}
	/**Obtiene una factura a traves de un id
	 * @param numero identificador 
	 * @return Factura objeto factura-
	 */
	public static Factura findById(Long id) {
		return null;
	}
	/**Objtiene el sisguente numero de factura
	 * @return Long con el dato.
	 */
	public static Long getNextInvoiceNumber() {
		return Jpa.getManager()
				.createNamedQuery("Factura.getNextInvoiceNumber",Long.class)
				.getSingleResult();
	}
}
