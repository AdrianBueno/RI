package uo.ri.amp.common.io.input.validators;
/**
 * @author Adri�n
 * Clase abstracta base para implementar el strategy
 * Se encarga de hacer una validaci�n la cual ser� definida por sus subclases
 * Le dejo esta funcionalidad solamente, aunque pens� que se podr�a a�adir
 * un m�todo que devolviera un mensaje de error.
 */
public abstract class Validator {
	public abstract boolean validate(String str);
}
