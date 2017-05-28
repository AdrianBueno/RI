package uo.ri.amp.common.properties;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
/**
 * @author Admin
 * Clase para gestionar los str de los mensajes de excepciones
 * Obsoleta.
 */
@Deprecated
public class ExceptionStr {
	private static final String BUNDLE_NAME 
	= "uo.ri.amp.common.properties.exception"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private ExceptionStr() {
	}

	public static String getStr(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
