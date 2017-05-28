package uo.ri.amp.common.io.output.format.impl;

import uo.ri.amp.common.io.output.format.TipoContratoFormat;
import uo.ri.amp.common.model.TipoContrato;

public class TipoContratoFormatImpl extends TipoContratoFormat {

	public TipoContratoFormatImpl(TipoContrato tipo) {
		super(tipo);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getFormattedData() {
		StringBuilder sb = new StringBuilder();
		sb.append("TIPO CONTRATO ID: "+tipo.getId()+
				" Nombre: "+tipo.getNombre()+"\n");
		sb.append("Dias Indemnización: "+tipo.getDiasIndemnizacion()+"\n");
		return sb.toString();
	}

}
