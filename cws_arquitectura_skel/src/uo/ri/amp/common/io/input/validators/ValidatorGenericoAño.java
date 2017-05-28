package uo.ri.amp.common.io.input.validators;

/**
 * @author Adri�n
 * Con esta clase valido el a�o, debe ser entero y positivo.
 * Podr�a extenderse para que validara si es mayor que el actual
 * sin embargo no lo hago por falta de contexto.
 */
public class ValidatorGenericoA�o extends Validator {

	@Override
	public boolean validate(String str) {
		if(str == null || str.trim().equals(""))
			return false;
		Integer var;
		try{
			var = Integer.parseInt(str);
		}catch(NumberFormatException e){return false;}
		if(var < 0)
			return false;
		return true;
	}

}
