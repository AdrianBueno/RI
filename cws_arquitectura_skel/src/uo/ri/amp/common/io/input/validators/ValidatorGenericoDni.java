package uo.ri.amp.common.io.input.validators;
/**
 * 
 * @author Adrián
 * Implementación de un patrón Strategy.
 */
public class ValidatorGenericoDni extends Validator {
	
	@Override
	public boolean validate(String str) {
		if(str == null || str.trim().equals(""))
			return true;
		else
			return false;
	}

}
