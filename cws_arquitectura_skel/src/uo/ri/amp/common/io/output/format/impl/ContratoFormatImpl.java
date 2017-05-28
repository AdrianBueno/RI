package uo.ri.amp.common.io.output.format.impl;

import uo.ri.amp.common.io.output.format.ContratoFormat;
import uo.ri.amp.common.model.Contrato;

public class ContratoFormatImpl extends ContratoFormat {
	public ContratoFormatImpl(Contrato contrato) {
		super(contrato);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String getFormattedData() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("CONTRATO: "+contrato.getId()+"\n");
		sb.append("ESTADO: "+contrato.getEstado()+"\n");
		sb.append("Salario anual:     "+contrato.getSalarioBaseAnual()+"\n");
		sb.append("Fecha Inicio:      "+contrato.getFechaInicio()+"\n");
		sb.append("Fecha Fin:         "+contrato.getFechaFin()+"\n");
		if(contrato.getFechaLiquidacion() == null)
			return sb.toString();
		sb.append("Fecha Liquidación: "+contrato.getFechaLiquidacion()+"\n");
		sb.append("Liquidación:       "+contrato.getImporteLiquidacion()+"\n");
		return sb.toString();
	}
	
}
