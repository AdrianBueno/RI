package uo.ri.amp.common.model.util;
/**
 * @author Adrián
 * @version 1
 * Esta clase pretende permitir cambiar la forma de calcular el irpf
 * sin recompilar la clase que lo usa.
 */
public class CalculadorIRPF extends Calculador {
	@Override
	public Double calcular(Object... object) {
		Double baseMensual = (Double)object[0];
		Double brutoAnual =  (Double)object[1];
		if(brutoAnual < 12000)
			return baseMensual * 0.07;
		else if(brutoAnual < 15000)
			return baseMensual * 0.1;
		else if(brutoAnual < 20000)
			return baseMensual * 0.13;
		else if(brutoAnual < 25000)
			return baseMensual * 0.17;
		else if(brutoAnual < 30000)
			return baseMensual * 0.20;
		return baseMensual* 0.20;
	}

}
