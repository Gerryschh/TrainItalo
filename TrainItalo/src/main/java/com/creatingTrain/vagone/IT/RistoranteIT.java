package com.creatingTrain.vagone.IT;

import java.util.Arrays;
import java.util.List;

import com.creatingTrain.treno.Ristorante;

public class RistoranteIT implements Ristorante {

	private final int numeroTavoliIT=180, pesoIT= 180;
	private final int numeroPersoneIT=100;
	private final List<String> menuIT = Arrays.asList("pesto", "dolce", "caffe");
	
	@Override
	public int getNumeroTavoli() {
		// TODO Auto-generated method stub
		return numeroTavoliIT;
	}

	@Override
	public int getMaxNumeroPersone() {
		// TODO Auto-generated method stub
		return numeroPersoneIT;
	}

	@Override
	public List<String> getMenu() {
		// TODO Auto-generated method stub
		return menuIT;
	}

	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return pesoIT;
	}

}
