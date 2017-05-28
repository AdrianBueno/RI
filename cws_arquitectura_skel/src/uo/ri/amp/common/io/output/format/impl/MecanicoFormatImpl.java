package uo.ri.amp.common.io.output.format.impl;

import uo.ri.amp.common.io.output.format.MecanicoFormat;
import uo.ri.amp.common.model.Mecanico;

public class MecanicoFormatImpl extends MecanicoFormat {

	public MecanicoFormatImpl(Mecanico mecanico) {
		super(mecanico);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getFormattedData() {
		StringBuilder sb = new StringBuilder();
		sb.append("MECANICO: " + mecanico.getId()+
				" DNI: "+mecanico.getDni()+"\n");
		sb.append("Nombre: "+mecanico.getNombre()+
				" Apellidos: "+mecanico.getApellidos()+"\n");
		return sb.toString();
	}
	
}
