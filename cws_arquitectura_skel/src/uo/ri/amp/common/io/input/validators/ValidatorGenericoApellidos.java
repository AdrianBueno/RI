package uo.ri.amp.common.io.input.validators;
/**
 * @author Adri�n
 * Una versi�n mejorada de este validador permitir�a comprobar
 * que se han introducido 2 cadenas, o validar su longitud para poner un m�ximo
 */
public class ValidatorGenericoApellidos extends Validator {

	@Override
	public boolean validate(String str) {
		if(str == null || str.trim().equals(""))
			return false;
		return true;
	}

}
