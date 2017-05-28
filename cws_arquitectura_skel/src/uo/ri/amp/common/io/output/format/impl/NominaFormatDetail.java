package uo.ri.amp.common.io.output.format.impl;

import alb.util.console.Console;
import uo.ri.amp.common.io.output.format.NominaFormat;
import uo.ri.amp.common.model.Nomina;

public class NominaFormatDetail extends NominaFormat {

	public NominaFormatDetail(Nomina nomina) {
		super(nomina);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getFormattedData() {
		StringBuilder sb = new StringBuilder();
		Console.print("\nFecha: "+nomina.getFecha()+"\n");
		sb.append("Detalles --------------------------------\n");
		sb.append("		Bruto: "+nomina.getSalarioBruto()+"\n");
		sb.append("	 	 Neto: "+nomina.getSalarioNeto()+"\n");
		sb.append("Desglose --------------------------------\n");
		sb.append("	 Productividad: "+nomina.getPlusProductividad()+"\n");
		sb.append("		Paga extra: "+nomina.getPagoExtra()+"\n");
		sb.append("	  	  Trienios: "+nomina.getTrienios()+"\n");
		sb.append("		  	  IRPF: -"+nomina.getDescuentoIrpf()+"\n");
		sb.append("Seguridad Sociaul: -"+nomina.getDescuentoSS()+"\n");
		return sb.toString();
	}

}
