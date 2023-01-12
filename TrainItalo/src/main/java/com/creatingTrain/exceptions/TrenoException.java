package com.creatingTrain.exceptions;

public class TrenoException extends Exception {
	private String sigla;

	public TrenoException(String sigla) {
		super("Errore nella costruzione del treno con sigla: " + sigla);
		this.sigla = sigla;
	}
	
}
