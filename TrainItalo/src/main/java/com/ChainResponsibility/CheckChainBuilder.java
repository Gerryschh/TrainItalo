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
			CheckChain cp = new ContainsPartial(); 
            CheckChain jd = new JaroDistance(0.75); jd.setNextChain(cp);
            CheckChain lev = new Levenshtein(2); lev.setNextChain(jd);
            CheckChain cd = new Contained(); cd.setNextChain(lev);
            CheckChain cs = new Contains(); cs.setNextChain(cd);
            CheckChain es = new EqualsStandardCS(); es.setNextChain(cs);
            es.setStrategy(s);
			instance=es;
		}
		return instance;
	}


	

}
