package uo.ri.amp.common.properties;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class UiStr {
	private static final String BUNDLE_NAME = 
			"uo.ri.amp.common.properties.ui"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private UiStr() {
	}

	public static String getStr(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
