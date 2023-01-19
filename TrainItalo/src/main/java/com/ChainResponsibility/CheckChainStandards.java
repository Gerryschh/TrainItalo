package com.ChainResponsibility;


public abstract class CheckChainStandards extends CheckChain {
	
	public final String checkInternal(String input) {
        for (String standard : getStrategy().dataMap().keySet()) {
            if(compare(input, standard)) {
                return standard;
            }
            if(getStrategy().dataMap().get(standard)!= null){
                for(String aliases: getStrategy().dataMap().get(standard)) {
                    if(compare(input, aliases)) {
                        return standard;
                    }
                }
            }
        }
        return null;
    };
	
	protected abstract boolean compare(String input, String standard);
}
