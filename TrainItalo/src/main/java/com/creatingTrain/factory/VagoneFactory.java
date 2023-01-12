package com.creatingTrain.factory;

import com.creatingTrain.treno.Cargo;
import com.creatingTrain.treno.Locomotiva;
import com.creatingTrain.treno.Passeggeri;
import com.creatingTrain.treno.Ristorante;

public interface VagoneFactory {
	
	public abstract Locomotiva getLocomotiva();
	public abstract Cargo getCargo();
	public abstract Passeggeri getPasseggeri();
	public abstract Ristorante getRistorante();
	public abstract int getMassimoPosti();

}
