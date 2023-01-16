package com.creatingTrain.exceptions;

public class FactoryException extends Exception {
	
	public FactoryException(String nomeFactory, String msg) {
		super(msg+" "+nomeFactory);
	}

}
