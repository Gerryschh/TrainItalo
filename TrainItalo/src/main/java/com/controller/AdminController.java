package com.controller;

import javax.jws.WebParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.AliasManager;
import com.strategy.StrategyDB;

@Controller
@RequestMapping("/admin")
public class AdminController {
	AliasManager am = new AliasManager();
	
	@GetMapping("/checkAliases")
	public String checkAliases(@WebParam String[] checkAlias) {
		am.approveAlias(checkAlias);
		return "aliasApproval";
	}
}
