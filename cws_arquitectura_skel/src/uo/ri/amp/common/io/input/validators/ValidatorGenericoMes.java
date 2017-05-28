package uo.ri.amp.common.io.input.validators;
/**
 * @author Adri�n
 * Esta clase se encarga de validar el mes, este debe ser un n�mero
 * y estar entre 1 y 24 ambos inclusivos.
 */
public class ValidatorGenericoMes extends Validator {

	@Override
	public boolean validate(String str) {
		if(str == null || str.trim().equals(""))
			return false;
		Integer var;
		try{
			var = Integer.parseInt(str);
		}catch(NumberFormatException e){
			return false;
		}
		if(var <= 0 || var > 24)
			return false;
		return true;
	}

}
