package uo.ri.amp.common.io.output.format;

import uo.ri.amp.common.model.CategoriaContrato;



public abstract class CategoriaContratoFormat extends CategoriaContrato {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected CategoriaContrato categoria;

	public CategoriaContratoFormat(CategoriaContrato categoria){
		this.categoria = categoria;
	}
	
	public abstract String getFormattedData();
}
