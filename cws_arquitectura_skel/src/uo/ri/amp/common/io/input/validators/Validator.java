package uo.ri.amp.common.io.input.validators;
/**
 * @author Adrián
 * Clase abstracta base para implementar el strategy
 * Se encarga de hacer una validación la cual será definida por sus subclases
 * Le dejo esta funcionalidad solamente, aunque pensé que se podría añadir
 * un método que devolviera un mensaje de error.
 */
public abstract class Validator {
	public abstract boolean validate(String str);
}
