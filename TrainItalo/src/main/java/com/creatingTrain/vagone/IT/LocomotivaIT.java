package com.creatingTrain.vagone.IT;

import com.creatingTrain.treno.Locomotiva;

public class LocomotivaIT implements Locomotiva {

	private final int potenzaIT=800;
	private final int pesoIT=70, pesoTrainabileIT=2600;
	@Override
	public int getPotenza() {
		// TODO Auto-generated method stub
		return potenzaIT;
	}
	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return pesoIT;
	}
	@Override
	public int getPesoTrainabile() {
		// TODO Auto-generated method stub
		return pesoTrainabileIT;
	}
}
