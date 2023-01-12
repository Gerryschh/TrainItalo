package com.creatingTrain.vagone.FR;

import com.creatingTrain.treno.Passeggeri;

public class PasseggeriFR implements Passeggeri{
	
	private final int numeroPostiFR = 100, postiDisabiliFR = 10, pesoFR = 250;

	@Override
	public int getNumeroPosti() {
		// TODO Auto-generated method stub
		return numeroPostiFR;
	}

	@Override
	public int getPostiDisabili() {
		// TODO Auto-generated method stub
		return postiDisabiliFR;
	}

	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return pesoFR;
	}

	@Override
	public String toString() {
		return "PasseggeriFR [numeroPostiFR=" + numeroPostiFR + ", postiDisabiliFR=" + postiDisabiliFR + ", pesoFR="
				+ pesoFR + "]";
	}

	

}
