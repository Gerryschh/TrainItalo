package com.creatingTrain.vagone.FR;

import java.util.Arrays;
import java.util.List;

import com.creatingTrain.treno.Cargo;

public class CargoFR implements Cargo {
	
	private final int caricoFR = 300, pesoFR = 50;
	private final List<String> elementiCaricatiFR = Arrays.asList("Caffe", "Stelle", "Armi");
	

	@Override
	public double getCarico() {
		// TODO Auto-generated method stub
		return caricoFR;
	}

	@Override
	public List<String> getElementiCaricati() {
		// TODO Auto-generated method stub
		return elementiCaricatiFR;
	}

	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return pesoFR;
	}

	@Override
	public String toString() {
		return "CargoFR [caricoFR=" + caricoFR + ", pesoFR=" + pesoFR + ", elementiCaricatiFR=" + elementiCaricatiFR
				+ "]";
	}
	
	
}