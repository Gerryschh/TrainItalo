package com.ChainResponsibility;

import com.ChainResponsibility.algorithm.Contained;
import com.ChainResponsibility.algorithm.Contains;
import com.ChainResponsibility.algorithm.ContainsPartial;
import com.ChainResponsibility.algorithm.EqualsInputCS;
import com.ChainResponsibility.algorithm.EqualsStandardCS;
import com.ChainResponsibility.algorithm.JaroDistance;
import com.ChainResponsibility.algorithm.Levenshtein;
import com.strategy.Strategy;

public class CheckChainBuilder {
	
	private static CheckChain instance=null;

	
	public static CheckChain getChain(Strategy s) {
		if (instance== null) {
			CheckChain cd = new Contained();
			CheckChain cs = new Contains(); 
			cs.setNextChain(cd);
			CheckChain cp = new ContainsPartial(); 
			cp.setNextChain(cs);
			CheckChain lev = new Levenshtein(2); 
			lev.setNextChain(cp);
			CheckChain jd = new JaroDistance(0.75); 
			jd.setNextChain(lev);
			CheckChain ei = new EqualsInputCS(); 
			ei.setNextChain(jd);
			CheckChain es = new EqualsStandardCS(); 
			es.setNextChain(ei);
			es.setStrategy(s);
			instance=ei;
		}
		return instance;
	}


	

}
