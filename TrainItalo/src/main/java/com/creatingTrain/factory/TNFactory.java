package com.creatingTrain.factory;

import com.creatingTrain.treno.Cargo;
import com.creatingTrain.treno.Locomotiva;
import com.creatingTrain.treno.Passeggeri;
import com.creatingTrain.treno.Ristorante;
import com.creatingTrain.vagone.TN.CargoTN;
import com.creatingTrain.vagone.TN.LocomotivaTN;
import com.creatingTrain.vagone.TN.PasseggeriTN;
import com.creatingTrain.vagone.TN.RistoranteTN;

public class TNFactory implements VagoneFactory {
	
private int massimoPostiTN=1000;
	/*
	 * SONO STATI USATI DUE COSTRUTTORI IN MODO DA AVERE UN CASO DI MASSIMO POSTI GIà DEFINITO E UNO DEFINIBILE DALL'UTENTE
	 */
	public TNFactory() {
	}

	public TNFactory(int massimoPosti) {
		this.massimoPostiTN = massimoPosti;
	}


	@Override
	public Locomotiva getLocomotiva() {
		return new LocomotivaTN();
	}

	@Override
	public Cargo getCargo() {
		return new CargoTN();
	}

	@Override
	public Passeggeri getPasseggeri() {
		// TODO Auto-generated method stub
		return new PasseggeriTN();
	}

	@Override
	public Ristorante getRistorante() {
		// TODO Auto-generated method stub
		return new RistoranteTN();
	}
	
	public int getMassimoPosti() {
		return this.massimoPostiTN;
	}
	
	

}
