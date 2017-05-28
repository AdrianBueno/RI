package uo.ri.amp.common.io.output.format;

import uo.ri.amp.common.model.Contrato;
/**
 * @author Adri�n
 * Esta clase se encarga de definir una interfaz para desacoplar el
 * ContratoFormat especifico a usar y que sea sencillo modificarlo
 * sin recompilar lo que est� usando esta clase.
 * 
 * Uso del patr�n decorator para ampliar la funcionalidad de Contrato.
 */
public abstract class ContratoFormat extends Contrato {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Contrato contrato;
	public ContratoFormat(Contrato contrato){
		this.contrato = contrato;
	}
	public abstract String getFormattedData();
}
