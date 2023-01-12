package com.creatingTrain.exceptions.exceed;

import com.creatingTrain.exceptions.ExceedException;

public class TooManyRestaurantsException extends ExceedException {
	
	String message;
	
	public TooManyRestaurantsException(String sigla, int ristoranti, int maxRistoranti) {
	   	 super(sigla);
	   	 this.message = "Hai inserito " + ristoranti + " ristoranti, ma il max è " + maxRistoranti;
	}
	 
	public String getMessage() {	 
		return super.getMessage() + "\n" + this.message; 
	}
}
