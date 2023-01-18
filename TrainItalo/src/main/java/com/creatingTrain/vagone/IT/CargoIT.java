package com.creatingTrain.vagone.IT;

import java.util.Arrays;
import java.util.List;

import com.creatingTrain.treno.Cargo;

public class CargoIT implements Cargo {
	
	private final int caricoIT = 200, pesoIT = 300;
	private final List<String> elementiCaricatiIT = Arrays.asList("Caffe", "Stelle", "Armi");
	@Override
	public double getCarico() {
		// TODO Auto-generated method stub
		return caricoIT;
	}
	@Override
	public List<String> getElementiCaricati() {
		// TODO Auto-generated method stub
		return elementiCaricatiIT;
	}
	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return pesoIT;
	}

}
