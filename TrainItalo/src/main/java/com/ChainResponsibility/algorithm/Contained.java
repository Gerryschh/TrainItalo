package com.ChainResponsibility.algorithm;

import com.ChainResponsibility.CheckChainStandards;

public class Contained extends CheckChainStandards{

	@Override
	protected boolean compare(String input, String standard) {
		return standard.contains(input);
	}

}
