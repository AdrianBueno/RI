package uo.ri.amp.common.io.output.format;

import uo.ri.amp.common.model.Mecanico;

public abstract class MecanicoFormat extends Mecanico {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Mecanico mecanico;
	public MecanicoFormat(Mecanico mecanico){
		this.mecanico = mecanico;
	}
	public abstract String getFormattedData();

}
