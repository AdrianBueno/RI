package uo.ri.amp.common.io.output.format;

import uo.ri.amp.common.model.Nomina;



public abstract class NominaFormat extends Nomina {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Nomina nomina;

	public NominaFormat(Nomina nomina){
		this.nomina = nomina;
	}
	
	public abstract String getFormattedData();
}
