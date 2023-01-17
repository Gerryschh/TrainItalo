package com.creatingTrain.factory;

import com.creatingTrain.treno.Cargo;
import com.creatingTrain.treno.Locomotiva;
import com.creatingTrain.treno.Passeggeri;
import com.creatingTrain.treno.Ristorante;
import com.creatingTrain.vagone.IT.CargoIT;
import com.creatingTrain.vagone.IT.LocomotivaIT;
import com.creatingTrain.vagone.IT.PasseggeriIT;
import com.creatingTrain.vagone.IT.RistoranteIT;
import com.creatingTrain.vagone.TN.CargoTN;
import com.creatingTrain.vagone.TN.LocomotivaTN;
import com.creatingTrain.vagone.TN.PasseggeriTN;
import com.creatingTrain.vagone.TN.RistoranteTN;

public class ITFactory implements VagoneFactory {
	
	private int massimoPostiIT=700;
	/*
	 * SONO STATI USATI DUE COSTRUTTORI IN MODO DA AVERE UN CASO DI MASSIMO POSTI GIà DEFINITO E UNO DEFINIBILE DALL'UTENTE
	 */
	public ITFactory() {
	}

	public ITFactory(int massimoPosti) {
		this.massimoPostiIT = massimoPosti;
	}


	@Override
	public Locomotiva getLocomotiva() {
		return new LocomotivaIT();
	}

	@Override
	public Cargo getCargo() {
		return new CargoIT();
	}

	@Override
	public Passeggeri getPasseggeri() {
		// TODO Auto-generated method stub
		return new PasseggeriIT();
	}

	@Override
	public Ristorante getRistorante() {
		// TODO Auto-generated method stub
		return new RistoranteIT();
	}
	
	public int getMassimoPosti() {
		return this.massimoPostiIT;
	}

}
