package com.creatingTrain.exceptions.exceed;

import com.creatingTrain.exceptions.ExceedException;

public class TooManyPeopleException extends ExceedException{

	private String message;
	
	public TooManyPeopleException(String sigla, int postiVagone, int postiTreno, int postiTrenoMax) {
		super(sigla);
		this.message = "Numero di posti " + postiTreno + " supera il limite " + postiTrenoMax+". Rimuovi " + (postiTreno-postiTrenoMax)/postiVagone + " vagoni";
		
	}
	
	public String getMessage() {
		return super.getMessage() + "\n" + this.message;
	}
}
