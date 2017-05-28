package uo.ri.amp.common.exceptions;

public class PersistenceException extends Exception {
	private static final long serialVersionUID = 1L;
	private String error;
	public PersistenceException(String str){
		error = str;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.error;
	}
	
	
}
