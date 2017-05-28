package uo.ri.amp.common.io.input.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
/**
 * @author Adrián
 * En esta clase valido una fecha con el formato dd/MM/yyyy
 */
public class ValidatorGenericoFecha extends Validator {
	@Override
	public boolean validate(String str) {
		try {
            SimpleDateFormat formatoFecha = 
            		new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(str);
        } catch (ParseException e) {
            return false;
        }
        return true;
	}

}
