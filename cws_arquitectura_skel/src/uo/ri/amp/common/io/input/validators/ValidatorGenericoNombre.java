package uo.ri.amp.common.io.input.validators;

public class ValidatorGenericoNombre extends Validator {

	@Override
	public boolean validate(String str) {
		if(str == null || str.trim().equals(""))
			return false;
		return true;
	}

}
