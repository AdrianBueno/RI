package uo.ri.amp.common.exceptions;

public class UiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String error;

	public UiException(String string){
		this.error = string;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
