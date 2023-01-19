package com.creatingTrain.vagone.TN;

import java.util.Arrays;
import java.util.List;

import com.creatingTrain.treno.Cargo;

public class CargoTN implements Cargo {
	
	private final int caricoTN = 300, pesoTN = 500;
	private final List<String> elementiCaricatiTN = Arrays.asList("Caffe", "Stelle", "Armi");
	

	@Override
	public double getCarico() {
		// TODO Auto-generated method stub
		return caricoTN;
	}

	@Override
	public List<String> getElementiCaricati() {
		// TODO Auto-generated method stub
		return elementiCaricatiTN;
	}

	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return pesoTN;
	}

	@Override
	public String toString() {
		return "CargoTN [caricoTN=" + caricoTN + ", pesoTN=" + pesoTN + ", elementiCaricatiTN=" + elementiCaricatiTN
				+ "]";
	}
	
	
}
