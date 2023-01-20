package com.creatingTrain.exceptions.wrongCombination;

import com.creatingTrain.exceptions.WrongCombinationException;

public class CannotCombineRCException extends WrongCombinationException {
	private String message;

	public CannotCombineRCException(String sigla) {
		super(sigla);
		this.message = "La carrozza Cargo non puo' essere combinato con quella Ristorante";
	
	}
	public String getMessage() {
		return super.getMessage() + ". " + this.message;
	}
}
