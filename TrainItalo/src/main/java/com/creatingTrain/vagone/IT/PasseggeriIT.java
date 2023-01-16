package com.creatingTrain.vagone.IT;

import com.creatingTrain.treno.Passeggeri;

public class PasseggeriIT implements Passeggeri {

	private final int numeroPostiIT = 80, postiDisabiliIT = 20, pesoIT = 200;

	@Override
	public int getNumeroPosti() {
		// TODO Auto-generated method stub
		return numeroPostiIT;
	}

	@Override
	public int getPostiDisabili() {
		// TODO Auto-generated method stub
		return postiDisabiliIT;
	}

	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return pesoIT;
	}
}
