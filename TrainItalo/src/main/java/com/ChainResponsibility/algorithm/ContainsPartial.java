package com.ChainResponsibility.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ChainResponsibility.CheckChain;

public class ContainsPartial extends CheckChain {
	@Override
	public String checkInternal(String input) {
        //L'IDEA E' QUELLA DI SEPARARE LE STRINGHE E CONTROLLARE I SINGOLI ELEMENTI. 
        //SE HO KOREA SUD DEVE ESSERE UGUALE A SUD KOREA
        List<String> stringaDaRicondurre=Arrays.asList(input.split(" "));
        List<String> copyStringaDaRicondurre=new ArrayList<String>(stringaDaRicondurre);
        for (String key : super.getStrategy().dataMap().keySet()) {
            List<String> paeseDaRicondurre=Arrays.asList(key.split(" "));
            List<String> copyPaeseDaRicondurre=new ArrayList<String>(paeseDaRicondurre);
            copyStringaDaRicondurre.retainAll( paeseDaRicondurre);
            copyPaeseDaRicondurre.retainAll( stringaDaRicondurre);
            if(copyStringaDaRicondurre.size()>2*stringaDaRicondurre.size()/3||
                    copyPaeseDaRicondurre.size()>2*paeseDaRicondurre.size()/3) 
                return key;
        }
        return null;

	}
}
