package uo.ri.amp.common.io.input.validators;
/**
 * @author Adrián
 * Una versión mejorada de este validador permitiría comprobar
 * que se han introducido 2 cadenas, o validar su longitud para poner un máximo
 */
public class ValidatorGenericoApellidos extends Validator {

	@Override
	public boolean validate(String str) {
		if(str == null || str.trim().equals(""))
			return false;
		return true;
	}

}
