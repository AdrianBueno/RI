package uo.ri.amp.common.io.input.validators;
/**
 * @author Adrián
 * Se encarga de la validación del salario.
 * Podria extenderse para no permitir un salario mayor que una determinada
 * cantidad para evitar errores u acciones malintencionadas.
 */
public class ValidatorGenericoSalarioAnual extends Validator {

	@Override
	public boolean validate(String str) {
		if(str == null || str.trim().equals(""))
			return false;
		try{Double.parseDouble(str);
		}catch(NumberFormatException e){return false;}
		return true;
	}

}
