package com.ChainResponsibility.algorithm;

import java.util.List;
import java.util.Map;

import com.ChainResponsibility.CheckChain;


public class EqualsInputCS extends CheckChain {

	@Override
	public String checkInternal(String input) {
		Map<String, List<String>> map = getStrategy().dataMap();
		//Prende il riferimento di country dal DB
		for(String key: map.keySet()) {
			if(map.get(key).contains(input)) {
				//System.out.println("Trovato con equalsInput");
				return key;
			}
		}
		return null;
	}

}
