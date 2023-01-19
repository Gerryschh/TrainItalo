package com.creatingTrain.vagone.FR;

import com.creatingTrain.treno.Locomotiva;

public class LocomotivaFR implements Locomotiva {

	private final int potenzaFR=1000;
	private final int pesoFR=70, pesoTrainabileFR=3000;
	

	@Override
	public int getPotenza() {
		// TODO Auto-generated method stub
		return potenzaFR;
	}

	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return pesoFR;
	}

	@Override
	public int getPesoTrainabile() {
		// TODO Auto-generated method stub
		return pesoTrainabileFR;
	}

	@Override
	public String toString() {
		return "LocomotivaFR [potenzaFR=" + potenzaFR + ", pesoFR=" + pesoFR + ", pesoTrainabileFR=" + pesoTrainabileFR
				+ "]";
	}

	
}
