package com.creatingTrain.vagone.TN;

import java.util.Arrays;
import java.util.List;

import com.creatingTrain.treno.Ristorante;

public class RistoranteTN implements Ristorante{
	private final int numeroTavoliTN=200, pesoTN= 150;
	private final int numeroPersoneTN=200;
	private final List<String> menuTN = Arrays.asList("pesto", "dolce", "caffe");
	

	@Override
	public int getNumeroTavoli() {
		return numeroTavoliTN;
	}

	@Override
	public int getMaxNumeroPersone() {
		return numeroPersoneTN;
	}

	@Override
	public List<String> getMenu() {
		return menuTN;
	}

	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return pesoTN;
	}

	@Override
	public String toString() {
		return "RistoranteTN [numeroTavoliTN=" + numeroTavoliTN + ", pesoTN=" + pesoTN + ", numeroPersoneTN="
				+ numeroPersoneTN + ", menuTN=" + menuTN + "]";
	}
	
	
}
