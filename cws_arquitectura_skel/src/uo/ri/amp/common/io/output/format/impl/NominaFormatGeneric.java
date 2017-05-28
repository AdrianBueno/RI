package uo.ri.amp.common.io.output.format.impl;

import java.util.Calendar;

import alb.util.console.Console;
import uo.ri.amp.common.io.output.format.NominaFormat;
import uo.ri.amp.common.model.Nomina;

public class NominaFormatGeneric extends NominaFormat {

	public NominaFormatGeneric(Nomina nomina) {
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
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nomina.getFecha());
		Console.printf("Año: %-4.4d Mes: %-4.4d", calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+"\n");
		sb.append("Neto: "+nomina.getSalarioNeto()+"\n");
		return sb.toString();
	}

}
