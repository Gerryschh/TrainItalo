package com.creatingTrain.factory;

import com.creatingTrain.treno.Cargo;
import com.creatingTrain.treno.Locomotiva;
import com.creatingTrain.treno.Passeggeri;
import com.creatingTrain.treno.Ristorante;
import com.creatingTrain.vagone.FR.CargoFR;
import com.creatingTrain.vagone.FR.LocomotivaFR;
import com.creatingTrain.vagone.FR.PasseggeriFR;
import com.creatingTrain.vagone.FR.RistoranteFR;

public class FRFactory implements VagoneFactory {
	
	private int massimoPostiFR=500;
	
	/*
	 * SONO STATI USATI DUE COSTRUTTORI IN MODO DA AVERE UN CASO DI MASSIMO POSTI GIà DEFINITO E UNO DEFINIBILE DALL'UTENTE
	 */
	
	public FRFactory() {
	}

	public FRFactory(int massimoPostiFR) {
		this.massimoPostiFR = massimoPostiFR;
	}

	@Override
	public Locomotiva getLocomotiva() {
		return new LocomotivaFR();
	}

	@Override
	public Cargo getCargo() {
		// TODO Auto-generated method stub
		return new CargoFR();
	}

	@Override
	public Passeggeri getPasseggeri() {
		// TODO Auto-generated method stub
		return new PasseggeriFR();
	}

	@Override
	public Ristorante getRistorante() {
		// TODO Auto-generated method stub
		return new RistoranteFR();
	}

	public int getMassimoPosti() {
		return this.massimoPostiFR;
	}


}
