package uo.ri.amp.common.model.util;

import java.util.Date;

import alb.util.date.DateUtil;

/*
 * @author Adrián
 * @version 1
 * Con esta clase se pretende poder cambiar la forma de calcular la paga extra
 * sin tener que recompilar la clase que use esta función
 *
 */
public class CalculadorPagaExtra extends Calculador {

	@Override
	public Double calcular(Object... object) {
		Double salarioMensual = (Double) object[0];
		Date fecha = (Date)object[1];
		int mes = DateUtil.month(fecha);
		if(mes == 7 || mes == 12)
			return salarioMensual;
		return 0.0;
	}

}
