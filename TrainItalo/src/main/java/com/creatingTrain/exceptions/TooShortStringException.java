package com.creatingTrain.exceptions;

public class TooShortStringException extends TrenoException{
	
	String message;

	public TooShortStringException(String sigla) {
	   	 super(sigla);
	   	 this.message = "La sigla ” +   del treno troppo corta, inserire almeno un'altro vagone";
	   	 
	}
	
	public String getMessage() {
 	      return super.getMessage() + "\n" + this.message;
     }

}
