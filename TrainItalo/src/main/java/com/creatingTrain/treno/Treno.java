package com.creatingTrain.treno;

import java.util.List;

public class Treno {
	private String nomeVagone;
	private List<Carrozza> carrozze;
	private Locomotiva locomotiva;
	
	
	public Treno(String nomeVagone, List<Carrozza> carrozze, Locomotiva locomotiva) {
		this.nomeVagone = nomeVagone;
		this.carrozze = carrozze;
		this.locomotiva = locomotiva;
	}


	@Override
	public String toString() {
		return "Treno nomeVagone=" + nomeVagone + ",\nlocomotiva=" + locomotiva + ",\ncarrozze=" + carrozze ;
	}
	
	
	
	
}
