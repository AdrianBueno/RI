package uo.ri.amp.common.exceptions;

public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String error;

	public BusinessException(String string) {
		this.error = string;
	}
	
	@Override
	public String getMessage() {
		return error;
	}
	

}
