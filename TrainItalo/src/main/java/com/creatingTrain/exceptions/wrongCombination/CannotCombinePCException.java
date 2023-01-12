package com.creatingTrain.exceptions.wrongCombination;

import com.creatingTrain.exceptions.WrongCombinationException;

public class CannotCombinePCException extends WrongCombinationException {
	private String message;

	public CannotCombinePCException(String sigla) {
		super(sigla);
		this.message = "La carrozza Cargo non puo' essere combinato con quella Passeggeri";
	
	}
	public String getMessage() {
		return super.getMessage() + "\n" + this.message;
	}
}
