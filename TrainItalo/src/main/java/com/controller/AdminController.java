package com.controller;

import javax.jws.WebParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.AliasManager;
import com.strategy.StrategyDB;

@Controller
public class AdminController {
	AliasManager am = new AliasManager();
	
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
	
	@GetMapping("/insertTrain")
	public String trainInsert(@WebParam String inputMatricolaTreno, @WebParam String TrainFactoryName, Model model) {
		
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


