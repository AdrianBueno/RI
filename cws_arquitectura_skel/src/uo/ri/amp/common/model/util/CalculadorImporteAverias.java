package uo.ri.amp.common.model.util;

import java.util.Date;

import uo.ri.amp.common.model.Intervencion;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.types.AveriaStatus;

public class CalculadorImporteAverias extends Calculador {

	@Override
	public Double calcular(Object... object) {
		Mecanico m = (Mecanico)object[0];
		Date inicio = (Date)object[1];
		Date fin = (Date)object[2];
		Double importeAverias = 0.0;
		for(Intervencion intervencion : m.getIntervenciones(inicio, fin)){
			if(intervencion.getAveria().getStatus() == AveriaStatus.TERMINADA)
				importeAverias += intervencion.getAveria().getImporte();
		}
		return importeAverias;
	}

}
