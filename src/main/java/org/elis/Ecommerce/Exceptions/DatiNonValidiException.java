package org.elis.Ecommerce.Exceptions;

public class DatiNonValidiException extends RuntimeException{
	private Object request;
	
	public DatiNonValidiException(Object o, String message) {
		super(message);
		request = o;
	}
	

	public DatiNonValidiException(String message) {
		super(message);
	}


	public Object getRequest() {
		return request;
	}

	public void setRequest(Object request) {
		this.request = request;
	}
	
}
