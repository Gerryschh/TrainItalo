package com.creatingTrain.treno;

import java.util.List;

public interface Cargo extends Carrozza{

	public double getCarico();
	public List<String> getElementiCaricati();
	public int getPeso();
	
}
