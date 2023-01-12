package com.creatingTrain.treno;

import java.util.List;

public interface Ristorante extends Carrozza{

	public int getNumeroTavoli();
	public int getMaxNumeroPersone();
	public List<String> getMenu();
	public int getPeso();
}
