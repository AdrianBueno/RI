package uo.ri.amp.common.io.output.format.impl;

import uo.ri.amp.common.io.output.format.CategoriaContratoFormat;
import uo.ri.amp.common.model.CategoriaContrato;

public class CategoriaContratoFormatImpl extends CategoriaContratoFormat {

	public CategoriaContratoFormatImpl(CategoriaContrato categoria) {
		super(categoria);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getFormattedData() {
		StringBuilder sb = new StringBuilder();
		sb.append("CATEGORIA CONTRATO ID: "+categoria.getId()+
				" NOMBRE: "+categoria.getNombre()+"\n");
		sb.append("Importe Trienios: "+categoria.getImporteTrienios()+
				" Plus Productividad: "+categoria.getPlusProductividad()+"\n");
		return sb.toString();
	}

}
