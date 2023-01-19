package com.ChainResponsibility;


public abstract class CheckChainStandards extends CheckChain {
	
	public final String checkInternal(String input) {
		for (String standard : getStrategy().dataMap().keySet()) {
			if(compare(input, standard)) {
				System.out.println(input + "-" + standard + " trovato con " + this.getClass().getSimpleName());
				return standard;
			}
		}
		return null;
	};
	
	protected abstract boolean compare(String input, String standard);
}
