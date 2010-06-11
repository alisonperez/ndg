package br.org.indt.ndg.exception;

public class NDGServerException extends Exception{
	

	private static final long serialVersionUID = 1L;


	public NDGServerException(String errorCode){
		super(errorCode);
	}
	
	
	
}
