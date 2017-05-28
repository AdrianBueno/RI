package uo.ri.amp.common.io.output.format;

import uo.ri.amp.common.model.TipoContrato;


public abstract class TipoContratoFormat extends TipoContrato {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected TipoContrato tipo;
	public TipoContratoFormat(TipoContrato tipo){
		this.tipo = tipo;
	}
	public abstract String getFormattedData();
}
