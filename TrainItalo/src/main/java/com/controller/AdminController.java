package com.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.jws.WebParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.creatingTrain.exceptions.ExceedException;
import com.creatingTrain.exceptions.FactoryException;
import com.creatingTrain.exceptions.TooShortStringException;
import com.creatingTrain.exceptions.WrongCombinationException;
import com.creatingTrain.exceptions.wrongLocomotive.MissingHeadLocomotiveException;
import com.manager.AliasManager;
import com.manager.TrainFactoryManager;
import com.manager.TrainManager;

@Controller
public class AdminController {
	AliasManager am = new AliasManager();
	TrainManager tm = new TrainManager();
	TrainFactoryManager tfm = new TrainFactoryManager();
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

	@GetMapping("/admin")
	public String homeAdmin() {
		return "admin";
	}

	@GetMapping("/checkAliases")
	public String checkAliases(@WebParam String[] checkAlias) {
		if(checkAlias == null)
		{
			return "aliasApproval";
		}
		else
		{
			am.approveAlias(checkAlias);
			return "aliasApproval";
		}
	}

	@GetMapping("/preInsertTrain")
	public String preInsert() {
		return "insertTrain";
	}

	@PostMapping("/insertTrain")
	public String trainInsert(@WebParam String inputMatricolaTreno, @WebParam String trainFactoryName, 
			@WebParam String inputDeparture, @WebParam String inputArrival, @WebParam String inputDepartureHour,
			@WebParam String inputArrivalHour, Model model) throws MissingHeadLocomotiveException, TooShortStringException, ExceedException, WrongCombinationException, FactoryException, ParseException {

		String msg = "";
		try {
			tm.checkAndAddTrain(inputMatricolaTreno, trainFactoryName, inputDeparture, inputArrival, inputDepartureHour, inputArrivalHour);
			msg = "Treno con matricola " + inputMatricolaTreno + " aggiunto con successo";
		}
		catch (Exception e) {
			msg = "Errore nell'aggiunta del treno con matricola " + inputMatricolaTreno;
			model.addAttribute("msg", msg);
		}
		return "insertTrain";
	}

	@GetMapping("/trainList")
	public String trainList() {
		return "trainList";
	}

	@GetMapping("/countryList")
	public String countryList() {
		return "countryList";
	}
}


