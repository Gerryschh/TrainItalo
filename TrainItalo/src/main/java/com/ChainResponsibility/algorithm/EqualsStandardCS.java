package com.ChainResponsibility.algorithm;

import com.ChainResponsibility.CheckChainStandards;

public class EqualsStandardCS extends CheckChainStandards{

	@Override
	protected boolean compare(String input, String standard) {
		return input.equals(standard);
	}

}
