package com.example.departmentmanagement.error;


public class DepartmentNotFoundException extends Exception{

	
	public DepartmentNotFoundException() {  
	    super();  
	    }  
	
	public DepartmentNotFoundException(String message) {  
	    super(message);  
	    }  
	
	public DepartmentNotFoundException(String message, Throwable cause) {  
	    super(message, cause);  
	    }  
	
	public DepartmentNotFoundException(Throwable cause) {  
	    super(cause);  
	    }  
	
	protected DepartmentNotFoundException(String Message, Throwable cause,boolean enableSuppression ,boolean writableStackTrace ) {  
	    super(Message, cause, enableSuppression, writableStackTrace);  
	    }
}
