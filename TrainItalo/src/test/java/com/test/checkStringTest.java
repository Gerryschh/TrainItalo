package com.test;

import java.util.List;
import java.util.Map;

import com.ChainResponsibility.CheckChain;
import com.ChainResponsibility.CheckChainBuilder;
import com.beans.Alias;
import com.manager.AliasManager;
import com.strategy.Strategy;
import com.strategy.StrategyDB;

public class checkStringTest {

	public static void main(String[] args) {
		Strategy s= new StrategyDB();		
		Map<String, List<String>> map= s.dataMap();
		CheckChain chain= CheckChainBuilder.getChain(s);
		String input = "efweagewwe";
		chain.check(input);

	}

}
